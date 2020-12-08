package edu.cnm.deepdive.albuquirky.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.cnm.deepdive.albuquirky.BuildConfig;
import edu.cnm.deepdive.albuquirky.model.SearchResponse;
import edu.cnm.deepdive.albuquirky.model.User;
import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface AlbuquirkyWebService {

  @GET("profiles/me")
  Single<User> getProfile(@Header("Authorization") String bearerToken);

  @GET("search")
  Single<SearchResponse> search(@Header("Authorization")String authHeader);

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
