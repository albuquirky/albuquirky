package edu.cnm.deepdive.albuquirky.service;

import android.content.Context;
import edu.cnm.deepdive.albuquirky.model.Product;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

/**
 * Repository to control access to getting and setting products by verifying bearer token
 */
public class ProductRepository {

  private final Context context;
  private final GoogleSignInService signInService;
  private final AlbuquirkyWebService webService;

  /**
   * Sign in with GoogleSignInService
   *
   * @param context - Context
   */
  public ProductRepository(Context context) {
    this.context = context;
    signInService = GoogleSignInService.getInstance();
    webService = AlbuquirkyWebService.getInstance();
  }

  /**
   * Refresh bearer token
   *
   * @return Single<List<Product>>
   */
  public Single<List<Product>> getAll() {
    return signInService.refreshBearerToken()
        .observeOn(Schedulers.io())
        .flatMap(webService::getProducts);
  }

  /**
   * Gets product by keyword
   *
   * @param keyword - String
   * @return Single<List<Product>>
   */
  public Single<List<Product>> searchByKeyword(String keyword) {
    return signInService.refreshBearerToken()
        .observeOn(Schedulers.io())
        .flatMap((token) -> webService.getProductsByKeyword(keyword));
  }

  /**
   * Add product to database
   *
   * @param product - Product
   * @return Single<Product>
   */
  public Single<Product> add(Product product) {
    return signInService.refreshBearerToken()
        .observeOn(Schedulers.io())
        .flatMap((token) -> webService.postProduct(token, product));
  }

  /**
   * Get product from database
   *
   * @param id - long
   * @return Single<Product>
   */
  public Single<Product> retrieveProduct(long id) {
    return signInService.refreshBearerToken()
        .observeOn(Schedulers.io())
        .flatMap((token) -> webService.getProductById(token, id));
  }

}