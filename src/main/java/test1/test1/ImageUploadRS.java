/* Copyright 2016 Yatra.com */
package test1.test1;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"statusCode", "statusMessage", "imageId"})
public class ImageUploadRS {

  @JsonProperty("statusCode")
  private String statusCode;
  @JsonProperty("statusMessage")
  private String statusMessage;
  @JsonProperty("imageId")
  private Integer imageId;
  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  @JsonProperty("statusCode")
  public String getStatusCode() {
    return statusCode;
  }

  @JsonProperty("statusCode")
  public void setStatusCode(String statusCode) {
    this.statusCode = statusCode;
  }

  @JsonProperty("statusMessage")
  public String getStatusMessage() {
    return statusMessage;
  }

  @JsonProperty("statusMessage")
  public void setStatusMessage(String statusMessage) {
    this.statusMessage = statusMessage;
  }

  @JsonProperty("imageId")
  public Integer getImageId() {
    return imageId;
  }

  @JsonProperty("imageId")
  public void setImageId(Integer imageId) {
    this.imageId = imageId;
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
