package com.hms.mongobean;

/* Copyright 2016 Yatra.com */


import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"vendor", "rooms", "cache", "image"})
public class Approval {

  @JsonProperty("vendor")
  private VendorApproval vendor;
  @JsonProperty("rooms")
  private RoomsApproval rooms;
  @JsonProperty("cache")
  private String cache;
  @JsonProperty("image")
  private String image;
  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  @JsonProperty("vendor")
  public VendorApproval getVendor() {
    return vendor;
  }

  @JsonProperty("vendor")
  public void setVendor(VendorApproval vendor) {
    this.vendor = vendor;
  }

  @JsonProperty("rooms")
  public RoomsApproval getRooms() {
    return rooms;
  }

  @JsonProperty("rooms")
  public void setRooms(RoomsApproval rooms) {
    this.rooms = rooms;
  }

  @JsonProperty("cache")
  public String getCache() {
    return cache;
  }

  @JsonProperty("cache")
  public void setCache(String cache) {
    this.cache = cache;
  }

  @JsonProperty("image")
  public String getImage() {
    return image;
  }

  @JsonProperty("image")
  public void setImage(String image) {
    this.image = image;
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

}

