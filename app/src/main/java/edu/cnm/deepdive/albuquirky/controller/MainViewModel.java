package edu.cnm.deepdive.albuquirky.controller;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import edu.cnm.deepdive.albuquirky.model.Product;
import edu.cnm.deepdive.albuquirky.model.SearchResponse.SearchData.ProdDto;
import edu.cnm.deepdive.albuquirky.service.ProductRepository;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;

public class MainViewModel extends AndroidViewModel implements LifecycleObserver {

  private final ProductRepository productRepository;
  private final MutableLiveData<List<Product>> results;
  private final MutableLiveData<Throwable> throwable;
  private final CompositeDisposable pending;

  public MainViewModel(@NonNull Application application) {
    super(application);
    productRepository = new ProductRepository(application);
    results = new MutableLiveData<>();
    throwable = new MutableLiveData<>();
    pending = new CompositeDisposable();
  }

  public void search(String keyword) {
    pending.add(
        productRepository.search(keyword)
            .subscribe(
                results::postValue,
                throwable::postValue
            )
    );
  }

  public LiveData<List<Product>> getResults() {
    return results;
  }

  public LiveData<Throwable> getThrowable() {
    return throwable;
  }

  @OnLifecycleEvent(Event.ON_STOP)
  private void clearPending() {
    pending.clear();
  }
}
