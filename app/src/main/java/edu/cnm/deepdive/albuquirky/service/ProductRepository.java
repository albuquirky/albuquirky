package edu.cnm.deepdive.albuquirky.service;

import android.content.Context;
import edu.cnm.deepdive.albuquirky.model.Product;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class ProductRepository {

  private final Context context;
  private final GoogleSignInService signInService;
  private final AlbuquirkyWebService webService;

  public ProductRepository(Context context) {
    this.context = context;
    signInService = GoogleSignInService.getInstance();
    webService = AlbuquirkyWebService.getInstance();
  }

  public Single<List<Product>> getAll() {
    return signInService.refreshBearerToken()
        .observeOn(Schedulers.io())
        .flatMap(webService::getProducts);
  }

  public Single<List<Product>> searchByKeyword(String keyword) {
    return signInService.refreshBearerToken()
        .observeOn(Schedulers.io())
        .flatMap((token) -> webService.getProductsByKeyword(keyword));
  }

  public Single<Product> add(Product product) {
    return signInService.refreshBearerToken()
        .observeOn(Schedulers.io())
        .flatMap((token) -> webService.postProduct(token, product));
  }

  public Single<Product> retrieveProduct(long id) {
    return signInService.refreshBearerToken()
        .observeOn(Schedulers.io())
        .flatMap((token) -> webService.getProductById(token, id));
  }

}