package edu.cnm.deepdive.albuquirky.service;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import edu.cnm.deepdive.albuquirky.model.Profile;
import io.reactivex.Completable;
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

  public Single<Profile> getProfileFromServer() {
    return signInService.refreshBearerToken()
        .observeOn(Schedulers.io())
        .flatMap(webService::getProfile);
    // TODO Add additional logic for persistence if appropriate.
  }

  public Single<Profile> save(Profile profile) {
    return signInService.refreshBearerToken()
        .observeOn(Schedulers.io())
        .flatMap((token) ->
            webService.putUsername(token, profile.getUsername())
                .flatMap((username) -> webService.putAddress(token, profile.getAddress()))
        )
        .map((address) -> profile);
  }


}