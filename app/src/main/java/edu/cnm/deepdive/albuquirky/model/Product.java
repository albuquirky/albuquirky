package edu.cnm.deepdive.albuquirky.model;

import androidx.annotation.NonNull;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;

/**
 * Product model class for database
 */
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
  private Date postedDate;

  /**
   * Gets product id
   *
   * @return id - long
   */
  public long getId() {
    return id;
  }

  /**
   * Sets product id to parameter passed
   *
   * @param id - long
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Gets name of pruduct
   *
   * @return name - String
   */
  public String getName() {
    return name;
  }

  /**
   * Sets name of product to parameter passed
   *
   * @param name - String
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets description of product
   *
   * @return description - String
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets description of product to parameter passed
   *
   * @param description - String
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Gets price of product
   *
   * @return price - int
   */
  public int getPrice() {
    return price;
  }

  /**
   * Sets price of product to paramter passed
   *
   * @param price - int
   */
  public void setPrice(int price) {
    this.price = price;
  }

  /**
   * Gets number in stock of product
   *
   * @return stock - int
   */
  public int getStock() {
    return stock;
  }

  /**
   * Sets number of stock of product to parameter passed
   *
   * @param stock - int
   */
  public void setStock(int stock) {
    this.stock = stock;
  }

  /**
   * Gets date product was posted
   *
   * @return postedDate - Date
   */
  public Date getPostedDate() {
    return postedDate;
  }

  /**
   * Sets date item was posted to parameter passed
   *
   * @param postedDate - Date
   */
  public void setPostedDate(Date postedDate) {
    this.postedDate = postedDate;
  }

  /**
   * Override of {@code toString} to return the name and description contents for the
   * {@link Product}.
   * @return The String version of the {@link Product} name and description.
   */
  @NonNull
  @Override
  public String toString() {
    return name + "\n" + description;
  }

}
