package edu.cnm.deepdive.albuquirky.model;

import androidx.annotation.NonNull;
import com.google.gson.annotations.Expose;
import java.util.Date;

public class Product {

//         "id": 3,
//             "name": "sculpture",
//             "description": "clay",
//             "price": 10000,
//             "stock": 10,
//             "postedDate": "2020-12-10T01:56:29.659+00:00",

  @Expose
  private long id;
  @Expose
  private String name;
  @Expose
  private String description;
  @Expose
  private int price;
  @Expose
  private int stock;
  @Expose
  private Date postedDate;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

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

  public Date getPostedDate() {
    return postedDate;
  }

  public void setPostedDate(Date postedDate) {
    this.postedDate = postedDate;
  }

  @NonNull
  @Override
  public String toString() {
    return name + "\n" + description;
  }
}
