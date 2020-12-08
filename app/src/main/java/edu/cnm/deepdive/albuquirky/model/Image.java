package edu.cnm.deepdive.albuquirky.model;

import com.google.gson.annotations.Expose;

public class Image {

  @Expose
  private long id;

  @Expose
  private String imageFileName;

  @Expose
  private String description;

  @Expose
  private long product;

  public String getImageFileName() {
    return imageFileName;
  }

  public void setImageFileName(String imageFileName) {
    this.imageFileName = imageFileName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public long getProduct() {
    return product;
  }

  public void setProduct(long product) {
    this.product = product;
  }

}
