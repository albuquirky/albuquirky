package edu.cnm.deepdive.albuquirky.controller.ui.profile;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import edu.cnm.deepdive.albuquirky.model.User;
import edu.cnm.deepdive.albuquirky.service.GoogleSignInService;
import edu.cnm.deepdive.albuquirky.service.UserRepository;
import io.reactivex.disposables.CompositeDisposable;

public class ProfileViewModel extends AndroidViewModel implements LifecycleObserver {

  private final GoogleSignInService signInService;
  private final UserRepository userRepository;
  private final MutableLiveData<User> user;
  private final MutableLiveData<Throwable> throwable;
  private final CompositeDisposable pending;


  public ProfileViewModel(@NonNull Application application) {
    super(application);
    signInService = GoogleSignInService.getInstance();
    userRepository = new UserRepository(application);
    user = new MutableLiveData<>();
    throwable = new MutableLiveData<>();
    pending = new CompositeDisposable();
    loadCurrentUser();
  }

  public LiveData<User> getUser() {
    return user;
  }

  public LiveData<Throwable> getThrowable() {
    return throwable;
  }

  public void save(User user) {
    pending.add(
        userRepository.save(user)
            .subscribe(
                () -> {},
                throwable::postValue
            )
    );
  }
  private void loadCurrentUser() {
    pending.add(
        userRepository.getOrCreate(signInService.getAccount())
            .subscribe(
                user::postValue,
                throwable::postValue
            )
    );
  }

  @OnLifecycleEvent(Event.ON_STOP)
  private void clearPending() {
    pending.clear();
  }
}