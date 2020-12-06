package edu.cnm.deepdive.albuquirky.service;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import edu.cnm.deepdive.albuquirky.model.User;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class UserRepository {

  private final Context context;
  private final AlbuquirkyWebService webService;
  private final GoogleSignInService signInService;
  // TODO Add fields as appropriate for access to DAO's etc.

  public UserRepository(Context context) {
    this.context = context;
    webService = AlbuquirkyWebService.getInstance();
    signInService = GoogleSignInService.getInstance();
  }

  public Single<User> getProfileFromServer() {
    return signInService.refresh()
        .observeOn(Schedulers.io())
        .flatMap((account) -> webService.getProfile(getBearerToken(account)));
    // TODO Add additional logic for persistence if appropriate.
  }

  private String getBearerToken(GoogleSignInAccount account) {
    return String.format("Bearer %s", account.getIdToken());
  }
}
