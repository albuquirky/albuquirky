package edu.cnm.deepdive.albuquirky.model;

import com.google.gson.annotations.Expose;

/**
 * Image model class for database table
 */
public class Image {

  @Expose
  private long id;

  @Expose
  private String imageFileName;

  @Expose
  private String description;

  @Expose
  private long product;

  /**
   * Gets name of image file
   *
   * @return imageFileName - String
   */
  public String getImageFileName() {
    return imageFileName;
  }

  /**
   * Sets name of image file to parameter passed
   *
   * @param imageFileName - String
   */
  public void setImageFileName(String imageFileName) {
    this.imageFileName = imageFileName;
  }

  /**
   * Gets description of image
   *
   * @return description - String
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets description of image to parameter passed
   *
   * @param description - String
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Gets product id
   *
   * @return product - long
   */
  public long getProduct() {
    return product;
  }

  /**
   * Sets product id to parameter passed
   *
   * @param product - long
   */
  public void setProduct(long product) {
    this.product = product;
  }

}
