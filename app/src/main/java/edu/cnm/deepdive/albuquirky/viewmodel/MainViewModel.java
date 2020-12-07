package edu.cnm.deepdive.albuquirky.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.disposables.CompositeDisposable;

public class MainViewModel extends AndroidViewModel {

  private final CompositeDisposable pending;

  public MainViewModel(@NonNull Application application) {
    super(application);
    pending = new CompositeDisposable();


  public void search(String keyword) {
    pending.add(
        mainRepository.search(keyword)
            .subscribe(
                results::postValue,
                throwable::postValue
            )
    );
  }
}
