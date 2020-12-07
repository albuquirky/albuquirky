package edu.cnm.deepdive.albuquirky.model;

import com.google.gson.annotations.Expose;

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

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

}
