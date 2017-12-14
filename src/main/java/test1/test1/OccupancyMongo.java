/* Copyright 2016 Yatra.com */
package test1.test1;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"maxAdult", "maxGuest", "maxChild", "maxInfant", "minAge", "freeStayAge", "extraGuestCharges", "ratePlans"})
public class OccupancyMongo {

  @JsonProperty("maxAdult")
  private Integer maxAdult;
  @JsonProperty("maxGuest")
  private Integer maxGuest;
  @JsonProperty("maxChild")
  private Integer maxChild;
  @JsonProperty("maxInfant")
  private Integer maxInfant;
  @JsonProperty("minAge")
  private Integer minAge;
  @JsonProperty("freeStayAge")
  private Integer freeStayAge;
  @JsonProperty("extraGuestCharges")
  private Double extraGuestCharges;
  @JsonProperty("ratePlans")
  private Object ratePlans;
  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  @JsonProperty("maxAdult")
  public Integer getMaxAdult() {
    return maxAdult;
  }

  @JsonProperty("maxAdult")
  public void setMaxAdult(Integer maxAdult) {
    this.maxAdult = maxAdult;
  }

  @JsonProperty("maxGuest")
  public Integer getMaxGuest() {
    return maxGuest;
  }

  @JsonProperty("maxGuest")
  public void setMaxGuest(Integer maxGuest) {
    this.maxGuest = maxGuest;
  }

  @JsonProperty("maxChild")
  public Integer getMaxChild() {
    return maxChild;
  }

  @JsonProperty("maxChild")
  public void setMaxChild(Integer maxChild) {
    this.maxChild = maxChild;
  }

  @JsonProperty("maxInfant")
  public Integer getMaxInfant() {
    return maxInfant;
  }

  @JsonProperty("maxInfant")
  public void setMaxInfant(Integer maxInfant) {
    this.maxInfant = maxInfant;
  }

  @JsonProperty("minAge")
  public Integer getMinAge() {
    return minAge;
  }

  @JsonProperty("minAge")
  public void setMinAge(Integer minAge) {
    this.minAge = minAge;
  }

  @JsonProperty("freeStayAge")
  public Integer getFreeStayAge() {
    return freeStayAge;
  }

  @JsonProperty("freeStayAge")
  public void setFreeStayAge(Integer freeStayAge) {
    this.freeStayAge = freeStayAge;
  }

  @JsonProperty("extraGuestCharges")
  public Double getExtraGuestCharges() {
    return extraGuestCharges;
  }

  @JsonProperty("extraGuestCharges")
  public void setExtraGuestCharges(Double extraGuestCharges) {
    this.extraGuestCharges = extraGuestCharges;
  }

  @JsonProperty("ratePlans")
  public Object getRatePlans() {
    return ratePlans;
  }

  @JsonProperty("ratePlans")
  public void setRatePlans(Object ratePlans) {
    this.ratePlans = ratePlans;
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
