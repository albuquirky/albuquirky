package edu.cnm.deepdive.albuquirky.service;

import android.content.Context;
import edu.cnm.deepdive.albuquirky.model.Product;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class ProductRepository {

  public final Context context;
  private final AlbuquirkyWebService serviceProxy;
  private final GoogleSignInService signInService;

  public ProductRepository(Context context) {
    this.context = context;
    serviceProxy = AlbuquirkyWebService.getInstance();
    signInService = GoogleSignInService.getInstance();
  }


  public Single<List<Product>> search(String query) {
    return signInService.refreshBearerToken()
        .observeOn(Schedulers.io())
        .flatMap((token) -> serviceProxy.search(token, query));

  }
}