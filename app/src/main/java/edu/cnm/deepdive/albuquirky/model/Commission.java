package edu.cnm.deepdive.albuquirky.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;

/**
 * Commission model class for database table
 */
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

  /**
   * Get Commission id
   *
   * @return id - long
   */
  public long getId() {
    return id;
  }

  /**
   * Sets Commission id to parameter passed
   *
   * @param id - long
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Gets Commission request
   *
   * @return request - String
   */
  public String getRequest() {
    return request;
  }

  /**
   * Sets Commission request to parameter passed
   *
   * @param request - String
   */
  public void setRequest(String request) {
    this.request = request;
  }

  /**
   * Gets Commissions position in queue
   *
   * @return position - int
   */
  public int getPosition() {
    return position;
  }

  /**
   * Sets Commission position in queue to parameter passed
   *
   * @param position - int
   */
  public void setPosition(int position) {
    this.position = position;
  }

  /**
   * Gets seller number of Commission
   *
   * @return seller - int
   */
  public int getSeller() {
    return seller;
  }

  /**
   * Sets Commission's seller number to parameter passed
   *
   * @param seller - int
   */
  public void setSeller(int seller) {
    this.seller = seller;
  }

  /**
   * Gets Commission's timestamp
   *
   * @return timestamp - Date
   */
  public Date getTimestamp() {
    return timestamp;
  }

  /**
   * Sets Commission's timestamp to parameter passed
   *
   * @param timestamp
   */
  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  /**
   * Gets id of person who commissioned the Commission
   *
   * @return commissioner - long
   */
  public long getCommissioner() {
    return commissioner;
  }

  /**
   * Sets commissioner id to parameter passed
   *
   * @param commissioner - long
   */
  public void setCommissioner(long commissioner) {
    this.commissioner = commissioner;
  }

}
