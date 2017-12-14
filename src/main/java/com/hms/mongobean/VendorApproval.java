/* Copyright 2016 Yatra.com */
package com.hms.mongobean;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"updateAmenityList", "updateBrandInfo", "updateCategoryMapping", "insertVendorInfo", "updateGroupInfo",
        "updateVendorDesc", "updateCancelInfo", "updateContactInfo", "updateImageDetails", "updateThemeMapping", "insertScSt"})
public class VendorApproval {

  @JsonProperty("updateAmenityList")
  private Boolean updateAmenityList;
  @JsonProperty("updateBrandInfo")
  private Boolean updateBrandInfo;
  @JsonProperty("updateCategoryMapping")
  private Boolean updateCategoryMapping;
  @JsonProperty("insertVendorInfo")
  private Boolean insertVendorInfo;
  @JsonProperty("updateGroupInfo")
  private Boolean updateGroupInfo;
  @JsonProperty("updateVendorDesc")
  private Boolean updateVendorDesc;
  @JsonProperty("updateCancelInfo")
  private Boolean updateCancelInfo;
  @JsonProperty("updateContactInfo")
  private Boolean updateContactInfo;
  @JsonProperty("updateImageDetails")
  private Boolean updateImageDetails;
  @JsonProperty("updateThemeMapping")
  private Boolean updateThemeMapping;
  @JsonProperty("insertScSt")
  private Boolean insertScSt;
  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  @JsonProperty("updateAmenityList")
  public Boolean getUpdateAmenityList() {
    return updateAmenityList;
  }

  @JsonProperty("updateAmenityList")
  public void setUpdateAmenityList(Boolean updateAmenityList) {
    this.updateAmenityList = updateAmenityList;
  }

  @JsonProperty("updateBrandInfo")
  public Boolean getUpdateBrandInfo() {
    return updateBrandInfo;
  }

  @JsonProperty("updateBrandInfo")
  public void setUpdateBrandInfo(Boolean updateBrandInfo) {
    this.updateBrandInfo = updateBrandInfo;
  }

  @JsonProperty("updateCategoryMapping")
  public Boolean getUpdateCategoryMapping() {
    return updateCategoryMapping;
  }

  @JsonProperty("updateCategoryMapping")
  public void setUpdateCategoryMapping(Boolean updateCategoryMapping) {
    this.updateCategoryMapping = updateCategoryMapping;
  }

  @JsonProperty("insertVendorInfo")
  public Boolean getInsertVendorInfo() {
    return insertVendorInfo;
  }

  @JsonProperty("insertVendorInfo")
  public void setInsertVendorInfo(Boolean insertVendorInfo) {
    this.insertVendorInfo = insertVendorInfo;
  }

  @JsonProperty("updateGroupInfo")
  public Boolean getUpdateGroupInfo() {
    return updateGroupInfo;
  }

  @JsonProperty("updateGroupInfo")
  public void setUpdateGroupInfo(Boolean updateGroupInfo) {
    this.updateGroupInfo = updateGroupInfo;
  }

  @JsonProperty("updateVendorDesc")
  public Boolean getUpdateVendorDesc() {
    return updateVendorDesc;
  }

  @JsonProperty("updateVendorDesc")
  public void setUpdateVendorDesc(Boolean updateVendorDesc) {
    this.updateVendorDesc = updateVendorDesc;
  }

  @JsonProperty("updateCancelInfo")
  public Boolean getUpdateCancelInfo() {
    return updateCancelInfo;
  }

  @JsonProperty("updateCancelInfo")
  public void setUpdateCancelInfo(Boolean updateCancelInfo) {
    this.updateCancelInfo = updateCancelInfo;
  }

  @JsonProperty("updateContactInfo")
  public Boolean getUpdateContactInfo() {
    return updateContactInfo;
  }

  @JsonProperty("updateContactInfo")
  public void setUpdateContactInfo(Boolean updateContactInfo) {
    this.updateContactInfo = updateContactInfo;
  }

  @JsonProperty("updateImageDetails")
  public Boolean getUpdateImageDetails() {
    return updateImageDetails;
  }

  @JsonProperty("updateImageDetails")
  public void setUpdateImageDetails(Boolean updateImageDetails) {
    this.updateImageDetails = updateImageDetails;
  }

  @JsonProperty("updateThemeMapping")
  public Boolean getUpdateThemeMapping() {
    return updateThemeMapping;
  }

  @JsonProperty("updateThemeMapping")
  public void setUpdateThemeMapping(Boolean updateThemeMapping) {
    this.updateThemeMapping = updateThemeMapping;
  }

  @JsonProperty("insertScSt")
  public Boolean getInsertScSt() {
    return insertScSt;
  }

  @JsonProperty("insertScSt")
  public void setInsertScSt(Boolean insertScSt) {
    this.insertScSt = insertScSt;
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
