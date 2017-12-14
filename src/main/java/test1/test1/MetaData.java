/* Copyright 2016 Yatra.com */
package test1.test1;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonPropertyOrder({"vendorId", "roomId" ,"caption", "product", "default"})
public class MetaData {

  @JsonProperty("vendorId")	
  private String vendorId;
  @JsonProperty("roomId")
  @JsonIgnore//(value = true)
  private String roomId;
  @JsonProperty("caption")
  private String caption;
  @JsonProperty("product")
  private String product;
  @JsonProperty("default")
  private Boolean _default;

  @JsonProperty("vendorId")
  public String getVendorId() {
    return vendorId;
  }

  @JsonProperty("vendorId")
  public void setVendorId(String vendorId) {
    this.vendorId = vendorId;
  }

  @JsonProperty("roomId")
  public String getRoomId() {
    return roomId;
  }

  @JsonProperty("roomId")
  public void setRoomId(String roomId) {
    this.roomId = roomId;
  }

  @JsonProperty("caption")
  public String getCaption() {
    return caption;
  }

  @JsonProperty("caption")
  public void setCaption(String caption) {
    this.caption = caption;
  }

  @JsonProperty("product")
  public String getProduct() {
    return product;
  }

  @JsonProperty("product")
  public void setProduct(String product) {
    this.product = product;
  }

  @JsonProperty("default")
  public Boolean getDefault() {
    return _default;
  }

  @JsonProperty("default")
  public void setDefault(Boolean _default) {
    this._default = _default;
  }

}
