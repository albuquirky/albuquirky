package edu.cnm.deepdive.albuquirky.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

// TODO Make any additions to turn this into an Entity class if appropriate.

/**
 * User model class for database
 */
public class User {

  @Expose
  @SerializedName("id")
  private long externalId;

  @Expose
  private String username;

  @Expose
  private String address;

  /**
   * Gets external id
   *
   * @return externalId - long
   */
  public long getExternalId() {
    return externalId;
  }

  /**
   * Sets external id
   *
   * @param externalId - long
   */
  public void setExternalId(long externalId) {
    this.externalId = externalId;
  }

  /**
   * Gets username of user
   *
   * @return username - String
   */
  public String getUsername() {
    return username;
  }

  /**
   * Sets username of user to parameter passed
   *
   * @param username - String
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * Gets address of user
   *
   * @return address - String
   */
  public String getAddress() {
    return address;
  }

  /**
   * Sets address of user to parameter passed
   *
   * @param address - String
   */
  public void setAddress(String address) {
    this.address = address;
  }

}
