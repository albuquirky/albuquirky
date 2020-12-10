package edu.cnm.deepdive.albuquirky.service;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import edu.cnm.deepdive.albuquirky.BuildConfig;
import io.reactivex.Single;

/**
 * Uses GoogleSignInClient and GoogleSignInAccount to log into application
 */
public class GoogleSignInService {

  private static Application context;

  private final GoogleSignInClient client;

  private GoogleSignInAccount account;

  private GoogleSignInService() {
    GoogleSignInOptions options = new GoogleSignInOptions.Builder()
        .requestEmail()
        .requestId()
        .requestProfile()
        .requestIdToken(BuildConfig.CLIENT_ID)
        .build();
    client = GoogleSignIn.getClient(context, options);
  }

  /**
   * Sets GoogleSignInService context to Application context
   *
   * @param context - Application
   */
  public static void setContext(Application context) {
    GoogleSignInService.context = context;
  }

  /**
   * Gets instance
   *
   * @return InstanceHolder.INSTANCE -
   */
  public static GoogleSignInService getInstance() {
    return InstanceHolder.INSTANCE;
  }

  /**
   * Gets GoogleSignInAccount
   *
   * @return account - GoogleSignInAccount
   */
  public GoogleSignInAccount getAccount() {
    return account;
  }

  /**
   * Refreshes google sign in and
   * listens for success or failure for account
   *
   * @return Single<GoogleSignInAccount>
   */
  public Single<GoogleSignInAccount> refresh() {
    return Single.create((emitter) ->
        client.silentSignIn()
            .addOnSuccessListener((account) -> {
              setAccount(account);
              emitter.onSuccess(account);
            })
            .addOnFailureListener(emitter::onError)
    );
  }

  /**
   * Refreshes bearer token
   *
   * @return Single<String>
   */
  public Single<String> refreshBearerToken() {
    //noinspection ReactiveStreamsNullableInLambdaInTransform
    return refresh()
        .map(GoogleSignInAccount::getIdToken)
        .map((token) -> String.format("Bearer %s", token));
  }

  /**
   * Starts sign in intent
   *
   * @param activity - Activity
   * @param requestCode  - int
   */
  public void startSignIn(Activity activity, int requestCode) {
    account = null;
    Intent intent = client.getSignInIntent();
    activity.startActivityForResult(intent, requestCode);
  }

  /**
   * Completes sign in
   *
   * @param data - Intent
   * @return Task<GoogleSignInAccount>
   */
  public Task<GoogleSignInAccount> completeSignIn(Intent data) {
    Task<GoogleSignInAccount> task = null;
    try {
      task = GoogleSignIn.getSignedInAccountFromIntent(data);
      setAccount(task.getResult(ApiException.class));
    } catch (ApiException e) {
      // Exception will be passed automatically to onFailureListener.
    }
    return task;
  }

  /**
   * Listens for sign out and sets account to null
   *
   * @return Task<Void>
   */
  public Task<Void> signOut() {
    return client.signOut()
        .addOnCompleteListener((ignored) -> setAccount(null));
  }

  private void setAccount(GoogleSignInAccount account) {
    this.account = account;
    if (account != null) {
      //noinspection ConstantConditions
      Log.d(getClass().getSimpleName(), account.getIdToken());
    }
  }

  private static class InstanceHolder {

    private static final GoogleSignInService INSTANCE = new GoogleSignInService();

  }

}