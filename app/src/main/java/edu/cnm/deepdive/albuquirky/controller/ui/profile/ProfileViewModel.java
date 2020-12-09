package edu.cnm.deepdive.albuquirky.controller.ui.profile;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import edu.cnm.deepdive.albuquirky.model.Profile;
import edu.cnm.deepdive.albuquirky.model.User;
import edu.cnm.deepdive.albuquirky.service.GoogleSignInService;
import edu.cnm.deepdive.albuquirky.service.UserRepository;
import io.reactivex.disposables.CompositeDisposable;

public class ProfileViewModel extends AndroidViewModel implements LifecycleObserver {

  private final GoogleSignInService signInService;
  private final UserRepository userRepository;
  private final MutableLiveData<Profile> profile;
  private final MutableLiveData<Throwable> throwable;
  private final CompositeDisposable pending;


  public ProfileViewModel(@NonNull Application application) {
    super(application);
    signInService = GoogleSignInService.getInstance();
    userRepository = new UserRepository(application);
    profile = new MutableLiveData<>();
    throwable = new MutableLiveData<>();
    pending = new CompositeDisposable();
    loadCurrentProfile();
  }

  public LiveData<Profile> getUser() {
    return profile;
  }

  public LiveData<Throwable> getThrowable() {
    return throwable;
  }

  public void save(Profile profile) {
    pending.add(
        userRepository.save(profile)
            .subscribe(
                this.profile::postValue,
                throwable::postValue
            )
    );
  }
  private void loadCurrentProfile() {
    pending.add(
        userRepository.getProfileFromServer()
            .subscribe(
                profile::postValue,
                throwable::postValue
            )
    );
  }

  @OnLifecycleEvent(Event.ON_STOP)
  private void clearPending() {
    pending.clear();
  }
}