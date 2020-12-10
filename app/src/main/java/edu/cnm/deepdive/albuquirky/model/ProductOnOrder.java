package edu.cnm.deepdive.albuquirky.model;

import com.google.gson.annotations.Expose;

/**
 * ProductOnOrder model class for database
 */
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

  /**
   * Gets id of product on order
   *
   * @return - long
   */
  public long getId() {
    return id;
  }

  /**
   * Sets id of product on order to parameter passed
   *
   * @param id - long
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Gets product id of product on order
   *
   * @return - long
   */
  public long getProduct() {
    return product;
  }

  /**
   * Sets product id for product on order to parameter passed
   *
   * @param product - long
   */
  public void setProduct(long product) {
    this.product = product;
  }

  /**
   * Gets order number to product on order
   *
   * @return - long
   */
  public long getOrder() {
    return order;
  }

  /**
   * Sets order number for product on order to parameter passed
   *
   * @param order - long
   */
  public void setOrder(long order) {
    this.order = order;
  }

  /**
   * Gets number of product ordered
   *
   * @return - int
   */
  public int getItemQuantity() {
    return itemQuantity;
  }

  /**
   * Sets number of product ordered to parameter passed
   *
   * @param itemQuantity - int
   */
  public void setItemQuantity(int itemQuantity) {
    this.itemQuantity = itemQuantity;
  }

  /**
   * Gets unit price for product on order
   *
   * @return unitPrice - int
   */
  public int getUnitPrice() {
    return unitPrice;
  }

  /**
   * Sets unit price for product ordered to parametr passed
   *
   * @param unitPrice - int
   */
  public void setUnitPrice(int unitPrice) {
    this.unitPrice = unitPrice;
  }

}
