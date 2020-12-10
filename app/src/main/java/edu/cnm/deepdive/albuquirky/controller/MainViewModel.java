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
import edu.cnm.deepdive.albuquirky.service.ProductRepository;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;

/**
 * The MainViewModel class queries the database for a list of products to display in the
 * {@link edu.cnm.deepdive.albuquirky.controller.ui.browse.BrowserFragment}, and stores the results
 *  for easy retrieval.
 */
public class MainViewModel extends AndroidViewModel implements LifecycleObserver {

  private final ProductRepository productRepository;
  private final MutableLiveData<List<Product>> results;
  private final MutableLiveData<Throwable> throwable;
  private final CompositeDisposable pending;

  /**
   * The constructor initializes all of the MutableLiveData required to hold the information
   * received from the database.
   * @param application The application context.
   */
  public MainViewModel(@NonNull Application application) {
    super(application);
    productRepository = new ProductRepository(application);
    results = new MutableLiveData<>();
    throwable = new MutableLiveData<>();
    pending = new CompositeDisposable();
  }

  /**
   * Queries the database for a list of {@link Product} entities matching the {@code keyword}.
   * @param keyword The searching keyword entered by the user.
   */
  public void search(String keyword) {
    pending.add(
        productRepository.search(keyword)
            .subscribe(
                results::postValue,
                throwable::postValue
            )
    );
  }

  /**
   * Gets the current list of {@link Product} objects from the last search.
   * @return A {@code List} of {@link Product} objects matching the previous search.
   */
  public LiveData<List<Product>> getResults() {
    return results;
  }

  /**
   * Gets the most recent throwable error, if any.
   * @return The most recent throwable.
   */
  public LiveData<Throwable> getThrowable() {
    return throwable;
  }

  @OnLifecycleEvent(Event.ON_STOP)
  private void clearPending() {
    pending.clear();
  }

}