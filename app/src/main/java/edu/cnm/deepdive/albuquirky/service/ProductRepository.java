package edu.cnm.deepdive.albuquirky.service;

import android.content.Context;
import edu.cnm.deepdive.albuquirky.BuildConfig;
import edu.cnm.deepdive.albuquirky.model.SearchResponse.SearchData.ProdDto;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class ProductRepository {

  public final Context context;
  private final AlbuquirkyWebService serviceProxy;

  public ProductRepository(Context context) {
    this.context = context;
    serviceProxy = AlbuquirkyWebService.getInstance();
  }


  public Single<List<ProdDto>> search(String query) {
    return serviceProxy.search(BuildConfig.AUTHORIZATION_HEADER)
        .map((response) -> response.getData().getProducts())
        .subscribeOn(Schedulers.io());
  }
}