package edu.cnm.deepdive.albuquirky;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.albuquirky.service.GoogleSignInService;

/**
 * Application Class that uses Stetho and GoogleSignInService on creation
 */
public class AlbuquirkyApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
    GoogleSignInService.setContext(this);
  }
}
