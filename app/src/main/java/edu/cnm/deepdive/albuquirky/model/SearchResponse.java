package edu.cnm.deepdive.albuquirky.model;

import com.google.gson.annotations.Expose;
import java.util.List;

/**
 * SearchResponse model class for database
 */
public class SearchResponse {

  @Expose
  private SearchData data;

  /**
   * Gets data
   *
   * @return data - SearchData
   */
  public SearchData getData() {
    return data;
  }

  /**
   * Sets data of SearchResponse to parameter passed
   *
   * @param data - SearchData
   */
  public void setData(SearchData data) {
    this.data = data;
  }

  /**
   * SearchData model class
   */
  public static class SearchData {

    @Expose
    private List<ProdDto> products;

    /**
     * Gets ProdDto object
     *
     * @return products - List<ProdDto>
     */
    public List<ProdDto> getProducts() {
      return products;
    }

    /**
     * Sets this.products object to parameter passed
     *
     * @param products - List<ProdDto>
     */
    public void setProducts(
        List<ProdDto> products) {
      this.products = products;
    }

    /**
     * Object with id, product, and productDescription
     */
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
