package edu.cnm.deepdive.albuquirky.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;

public class Commission {

  @Expose
  private long id;

  @Expose
  @SerializedName("commissionRequest")
  private String request;

  @Expose
  @SerializedName("waitlistPosition")
  private int position;

  @Expose
  private int seller;

  @Expose
  private Date timestamp;

  @Expose
  private long commissioner;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getRequest() {
    return request;
  }

  public void setRequest(String request) {
    this.request = request;
  }

  public int getPosition() {
    return position;
  }

  public void setPosition(int position) {
    this.position = position;
  }

  public int getSeller() {
    return seller;
  }

  public void setSeller(int seller) {
    this.seller = seller;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  public long getCommissioner() {
    return commissioner;
  }

  public void setCommissioner(long commissioner) {
    this.commissioner = commissioner;
  }

}
