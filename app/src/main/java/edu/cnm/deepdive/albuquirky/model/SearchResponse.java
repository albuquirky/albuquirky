package edu.cnm.deepdive.albuquirky.model;

import com.google.gson.annotations.Expose;
import java.util.List;

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
    private List<ProdDto> products;

    public List<ProdDto> getProducts() {
      return products;
    }

    public void setProducts(
        List<ProdDto> products) {
      this.products = products;
    }

    public static class ProdDto {

      @Expose
      private String id;

      @Expose
      private String product;

      @Expose
      private String productDescription;
    }
  }
}
