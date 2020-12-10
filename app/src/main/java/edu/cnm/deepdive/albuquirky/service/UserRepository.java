package edu.cnm.deepdive.albuquirky.service;

import android.content.Context;
import edu.cnm.deepdive.albuquirky.model.Profile;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

/**
 * API used to access database
 */
public class UserRepository {

  private final Context context;
  private final AlbuquirkyWebService webService;
  private final GoogleSignInService signInService;
  // TODO Add fields as appropriate for access to DAO's etc.

  /**
   * Initializes instance variables for UserRepository class
   *
   * @param context - environment data
   */
  public UserRepository(Context context) {
    this.context = context;
    webService = AlbuquirkyWebService.getInstance();
    signInService = GoogleSignInService.getInstance();
  }

  /**
   * Get profile from database of user currently logged into app
   *
   * @return Profile - user object
   */
  public Single<Profile> getProfileFromServer() {
    return signInService.refreshBearerToken()
        .observeOn(Schedulers.io())
        .flatMap(webService::getProfile);
    // TODO Add additional logic for persistence if appropriate.
  }

  /**
   * Saves information to database to profile passed as parameter
   *
   * @param profile - instance of user object
   * @return Profile - user object
   */
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