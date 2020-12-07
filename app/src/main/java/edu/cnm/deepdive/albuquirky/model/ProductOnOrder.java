package edu.cnm.deepdive.albuquirky.model;

import com.google.gson.annotations.Expose;

public class ProductOnOrder {

  @Expose
  private long id;

  @Expose
  private long product;

  @Expose
  private long order;

  @Expose
  private int itemQuantity;

  @Expose
  private int unitPrice;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getProduct() {
    return product;
  }

  public void setProduct(long product) {
    this.product = product;
  }

  public long getOrder() {
    return order;
  }

  public void setOrder(long order) {
    this.order = order;
  }

  public int getItemQuantity() {
    return itemQuantity;
  }

  public void setItemQuantity(int itemQuantity) {
    this.itemQuantity = itemQuantity;
  }

  public int getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(int unitPrice) {
    this.unitPrice = unitPrice;
  }

}
