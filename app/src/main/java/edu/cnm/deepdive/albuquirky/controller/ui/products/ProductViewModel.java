package edu.cnm.deepdive.albuquirky.controller.ui.products;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import edu.cnm.deepdive.albuquirky.model.Image;
import edu.cnm.deepdive.albuquirky.model.Product;
import edu.cnm.deepdive.albuquirky.service.ProductRepository;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;

public class ProductViewModel extends AndroidViewModel implements LifecycleObserver {

  private final ProductRepository productRepository;
  private final MutableLiveData<List<Product>> products;
  private final MutableLiveData<Product> product;
  private final MutableLiveData<List<Image>> images;
  private final MutableLiveData<Image> image;
  private final MutableLiveData<Throwable> throwable;
  private final CompositeDisposable pending;

  public ProductViewModel(@NonNull Application application) {
    super(application);
    productRepository = new ProductRepository(application);
    products = new MutableLiveData<>();
    product = new MutableLiveData<>();
    images = new MutableLiveData<>();
    image = new MutableLiveData<>();
    throwable = new MutableLiveData<>();
    pending = new CompositeDisposable();
  }

  public LiveData<List<Product>> getProducts() {
    return products;
  }

  public LiveData<Product> getProduct() {
    return product;
  }

  public LiveData<List<Image>> getImages() {
    return images;
  }

  public LiveData<Image> getImage() {
    return image;
  }

  public LiveData<Throwable> getThrowable() {
    return throwable;
  }

  public void currentProduct(long id) {
    pending.add(
        productRepository.retrieveProduct(id)
            .subscribe(
                product::postValue,
                throwable::postValue
            )
    );
  }

  @OnLifecycleEvent(Event.ON_STOP)
  private void clearPending() {
    pending.clear();
  }

}
