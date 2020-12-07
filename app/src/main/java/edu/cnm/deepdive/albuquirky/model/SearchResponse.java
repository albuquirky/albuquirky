package edu.cnm.deepdive.albuquirky.model;

import com.google.gson.annotations.Expose;

public class SearchResponse {
  @Expose
  private SearchData data;

  public SearchData getData() {
    return data;
  }

  public void setData(SearchData data) {
    this.data = data;
  }

  public static class SearchData {

    @Expose
    private String id;

    @Expose
    private String product;

    @Expose
    private String productDescription;
  }
}
