package edu.cnm.deepdive.albuquirky.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.cnm.deepdive.albuquirky.BuildConfig;
import edu.cnm.deepdive.albuquirky.model.Commission;
import edu.cnm.deepdive.albuquirky.model.Image;
import edu.cnm.deepdive.albuquirky.model.Order;
import edu.cnm.deepdive.albuquirky.model.Product;
import edu.cnm.deepdive.albuquirky.model.Profile;
import edu.cnm.deepdive.albuquirky.model.User;
import io.reactivex.Single;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AlbuquirkyWebService {

  @GET("profiles/me")
  Single<Profile> getProfile(@Header("Authorization") String bearerToken);

  @GET("profiles/{profileId}")
  Single<Profile> getProfileById(
      @Header("Authorization") String bearerToken, @Path("profileId") long id);

  @GET("profiles/me/username")
  Single<String> getUsername(@Header("Authorization") String bearerToken);

  @PUT("profiles/me/username")
  Single<String> putUsername(@Header("Authorization") String bearerToken, @Body String username);

  @GET("profiles/me/image")
  Single<String> getProfileImage(@Header("Authorization") String bearerToken);

  @PUT("profiles/me/image")
  Single<Product> postImage(@Header("Authorization") String bearerToken, @Body Image image);

  @GET("profiles/me/address")
  Single<String> getAddress(@Header("Authorization") String bearerToken);

  @PUT("profiles/me/address")
  Single<String> putAddress(@Header("Authorization") String bearerToken, @Body String address);

  @GET("orders/user-orders")
  Single<List<Order>> getUserOrders(@Header("Authorization") String bearerToken);

  @GET("orders/user-sold-orders")
  Single<List<Order>> getUserSoldOrders(@Header("Authorization") String bearerToken);

  @POST("orders")
  Single<Product> postOrder(@Header("Authorization") String bearerToken, @Body Order order);

  @GET("orders/{orderId}")
  Single<Order> getOrderById(
      @Header("Authorization") String bearerToken, @Path("orderId") long id);

  @GET("commissions/seller")
  Single<List<Commission>> getWaitlist(@Header("Authorization") String bearerToken);

  @GET("commissions/commissioner")
  Single<List<Commission>> getCommissions(@Header("Authorization") String bearerToken);

  @POST("commissions")
  Single<Product> postCommission(
      @Header("Authorization") String bearerToken, @Body Commission commission);

  @GET("commissions/{commissionId}")
  Single<Commission> getCommissionById(
      @Header("Authorization") String bearerToken, @Path("commissionId") long id);

  @DELETE("commissions/{commissionId}")
  // TODO Write delete.

  @GET("commissions/{commissionId}/commission-request")
  Single<String> getCommissionRequest(
      @Header("Authorization") String bearerToken, @Path("commissionId") long id);

  @PUT("commissions/{commissionId}/commission-request")
  Single<String> updateCommissionRequest(
      @Header("Authorization") String bearerToken, @Path("commissionId") long id);

  @GET("products/{keyword}")
  Single<List<Product>> getProductsByKeyword(@Path("keyword") String keyword);

  @GET("products/{userId}")
  Single<List<Product>> getProductsBySeller(
      @Header("Authorization") String bearerToken, @Path("userId") long id);

  @GET("products")
  Single<List<Product>> getProducts(@Header("Authorization") String bearerToken);

  @POST("products")
  Single<Product> postProduct(@Header("Authorization") String bearerToken, @Body Product product);

  @GET("products/{productId}")
  Single<Product> getProductById(
      @Header("Authorization") String bearerToken, @Path("productId") long id);

  @GET("products/{productId}/product-name")
  Single<String> getProductName(
      @Header("Authorization") String bearerToken, @Path("productId") long id);

  @PUT("products/{productId}/product-name")
  Single<String> updateProductName();

  @GET("products/{productId}/description")
  Single<String> getProductDescription(
      @Header("Authorization") String bearerToken, @Path("productId") long id);

  @PUT("products/{productId}/description")
  Single<String> updateProductDescription();

  @GET("products/{productId}/price")
  Single<Integer> getProductPrice(
      @Header("Authorization") String bearerToken, @Path("productId") long id);

  @PUT("products/{productId}/price")
  Single<Integer> updateProductPrice();

  @GET("products/{productId}/stock")
  Single<Integer> getProductStock(
      @Header("Authorization") String bearerToken, @Path("productId") long id);

  @PUT("products/{productId}/stock")
  Single<Integer> updateProductStock();

  @GET("images/{productId}")
  Single<List<Image>> getProductImages(
      @Header("Authorization") String bearerToken, @Path("productId") long id);

  @GET("images/{imageId}")
  Single<Image> getImageById(@Header("Authorization") String bearerToken, @Path("imageId") long id);

  @DELETE("images/{imageId}")
  // TODO Write delete.

  @GET("images/{imageId}/description")
  Single<String> getImageDescription(
      @Header("Authorization") String bearerToken, @Path("imageId") long id);

  @PUT("images/{imageId}/description")
  Single<String> updateImageDescription(
      @Header("Authorization") String bearerToken, @Path("imageId") long id);

  static AlbuquirkyWebService getInstance() {
    return InstanceHolder.INSTANCE;
  }

  class InstanceHolder {

    private static final AlbuquirkyWebService INSTANCE;

    static {
      Gson gson = new GsonBuilder()
          .excludeFieldsWithoutExposeAnnotation()
          .create();
      HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
      interceptor.setLevel(BuildConfig.DEBUG ? Level.BODY : Level.NONE);
      OkHttpClient client = new OkHttpClient.Builder()
          .addInterceptor(interceptor)
          .build();
      Retrofit retrofit = new Retrofit.Builder()
          .addConverterFactory(GsonConverterFactory.create(gson))
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .client(client)
          .baseUrl(BuildConfig.BASE_URL)
          .build();
      INSTANCE = retrofit.create(AlbuquirkyWebService.class);
    }

  }

}