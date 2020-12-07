package edu.cnm.deepdive.albuquirky.model;

import com.google.gson.annotations.Expose;
import java.util.Date;

public class Order {

  @Expose
  private long id;

  @Expose
  private long buyer;

  @Expose
  private long seller;

  @Expose
  private Date placedDate;

  public long getBuyer() {
    return buyer;
  }

  public void setBuyer(long buyer) {
    this.buyer = buyer;
  }

  public long getSeller() {
    return seller;
  }

  public void setSeller(long seller) {
    this.seller = seller;
  }

  public Date getPlacedDate() {
    return placedDate;
  }

  public void setPlacedDate(Date placedDate) {
    this.placedDate = placedDate;
  }

}
