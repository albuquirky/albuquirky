package edu.cnm.deepdive.albuquirky.model;

import com.google.gson.annotations.Expose;

/**
 * Profile model class for database table
 */
public class Profile {

  @Expose
  private long id;

  @Expose
  private String username;

  @Expose
  private String email;

  @Expose
  private String image;

  @Expose
  private String address;

  /**
   * Gets profile id
   *
   * @return id - long
   */
  public long getId() {
    return id;
  }

  /**
   * Sets profile id to parameter passed
   *
   * @param id - long
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Gets username of profile
   *
   * @return username - String
   */
  public String getUsername() {
    return username;
  }

  /**
   * Sets username of profile to parameter passed
   *
   * @param username - String
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * Gets email of profile
   *
   * @return email - String
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets email of profile to parameter passed
   *
   * @param email - String
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Gets image of profile
   *
   * @return image - String
   */
  public String getImage() {
    return image;
  }

  /**
   * Sets image name to parameter passed
   *
   * @param image - String
   */
  public void setImage(String image) {
    this.image = image;
  }

  /**
   * Gets address of profile
   *
   * @return address - String
   */
  public String getAddress() {
    return address;
  }

  /**
   * Sets address of profile to parameter passed
   *
   * @param address - String
   */
  public void setAddress(String address) {
    this.address = address;
  }


}
