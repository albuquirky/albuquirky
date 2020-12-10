package edu.cnm.deepdive.albuquirky.model;

import com.google.gson.annotations.Expose;
import java.util.Date;

/**
 * Order model class for database table
 */
public class Order {

  @Expose
  private long id;

  @Expose
  private long buyer;

  @Expose
  private long seller;

  @Expose
  private Date placedDate;

  /**
   * Gets id of buyer of order
   *
   * @return buyer - long
   */
  public long getBuyer() {
    return buyer;
  }

  /**
   * Sets id of buyer of order to parameter passed
   *
   * @param buyer - long
   */
  public void setBuyer(long buyer) {
    this.buyer = buyer;
  }

  /**
   * Gets id of seller of order
   *
   * @return seller - long
   */
  public long getSeller() {
    return seller;
  }

  /**
   * Sets id of seller of order to parameter passed
   *
   * @param seller - long
   */
  public void setSeller(long seller) {
    this.seller = seller;
  }

  /**
   * Gets date of when order was placed
   *
   * @return placedDate - Date
   */
  public Date getPlacedDate() {
    return placedDate;
  }

  /**
   * Sets date of when order was placed to parameter passed
   *
   * @param placedDate - Date
   */
  public void setPlacedDate(Date placedDate) {
    this.placedDate = placedDate;
  }

}
