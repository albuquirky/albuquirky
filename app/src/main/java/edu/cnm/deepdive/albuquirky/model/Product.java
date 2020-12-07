package edu.cnm.deepdive.albuquirky.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {

  @Expose
  private long id;

  @Expose
  @SerializedName("product_name")
  private String name;

  @Expose
  private String description;

  @Expose
  private int price;

  @Expose
  private int stock;

  @Expose
  private int postedDate;

  @Expose
  @SerializedName("profile")
  private int seller;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  public int getPostedDate() {
    return postedDate;
  }

  public void setPostedDate(int postedDate) {
    this.postedDate = postedDate;
  }

  public int getSeller() {
    return seller;
  }

  public void setSeller(int seller) {
    this.seller = seller;
  }

}
