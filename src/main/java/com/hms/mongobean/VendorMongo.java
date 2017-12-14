package com.hms.mongobean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties( ignoreUnknown=true)
@JsonPropertyOrder({
"propertyType",
"vendorName",
"vendorDescription",
"vendorType",
"accommodationType",
"location",
"address",
"mobile",
"facilities",
"checkInPolicy",
"cancellation",
"margin",
"markUp",
"hotelStar",
"noOfRooms",
"noOfFloors",
"hotelClass",
"payAtHotel",
"creationDate",
"active",
"stopSell",
"bookInstantly",
"propertyManagedBy",
"noOfBathRooms",
"emailId",
"isChannelMgr",
"paymentTerm",
"status",
"vendorStatus",
"editable",
"systemMargin",
"isGovtVerified"
})
public class VendorMongo {

@JsonProperty("propertyType")
private String propertyType;
@JsonProperty("vendorName")
private String vendorName;
@JsonProperty("vendorDescription")
private String vendorDescription;
@JsonProperty("vendorType")
private List<String> vendorType = null;
@JsonProperty("accommodationType")
private String accommodationType;
@JsonProperty("location")
private Location location;
@JsonProperty("address")
private Address address;
@JsonProperty("mobile")
private Mobile mobile;
@JsonProperty("facilities")
private List<Facility> facilities = null;
@JsonProperty("checkInPolicy")
private CheckInPolicy checkInPolicy;
@JsonProperty("cancellation")
private Cancellation cancellation;
@JsonProperty("margin")
private String margin;
@JsonProperty("markUp")
private String markUp;
@JsonProperty("hotelStar")
private String hotelStar;
@JsonProperty("noOfRooms")
private Integer noOfRooms;
@JsonProperty("noOfFloors")
private String noOfFloors;
@JsonProperty("hotelClass")
private String hotelClass;
@JsonProperty("payAtHotel")
private String payAtHotel;
@JsonProperty("creationDate")
private String creationDate;
@JsonProperty("active")
private String active;
@JsonProperty("stopSell")
private String stopSell;
@JsonProperty("bookInstantly")
private String bookInstantly;
@JsonProperty("propertyManagedBy")
private String propertyManagedBy;
@JsonProperty("noOfBathRooms")
private Integer noOfBathRooms;
@JsonProperty("emailId")
private String emailId;
@JsonProperty("isChannelMgr")
private String isChannelMgr;
@JsonProperty("paymentTerm")
private String paymentTerm;
@JsonProperty("status")
private Status status;
@JsonProperty("vendorStatus")
private String vendorStatus;
@JsonProperty("editable")
private String editable;
@JsonProperty("systemMargin")
private String systemMargin;
@JsonProperty("isGovtVerified")
private String isGovtVerified;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("propertyType")
public String getPropertyType() {
return propertyType;
}

@JsonProperty("propertyType")
public void setPropertyType(String propertyType) {
this.propertyType = propertyType;
}

@JsonProperty("vendorName")
public String getVendorName() {
return vendorName;
}

@JsonProperty("vendorName")
public void setVendorName(String vendorName) {
this.vendorName = vendorName;
}

@JsonProperty("vendorDescription")
public String getVendorDescription() {
return vendorDescription;
}

@JsonProperty("vendorDescription")
public void setVendorDescription(String vendorDescription) {
this.vendorDescription = vendorDescription;
}

@JsonProperty("vendorType")
public List<String> getVendorType() {
return vendorType;
}

@JsonProperty("vendorType")
public void setVendorType(List<String> vendorType) {
this.vendorType = vendorType;
}

@JsonProperty("accommodationType")
public String getAccommodationType() {
return accommodationType;
}

@JsonProperty("accommodationType")
public void setAccommodationType(String accommodationType) {
this.accommodationType = accommodationType;
}

@JsonProperty("location")
public Location getLocation() {
return location;
}

@JsonProperty("location")
public void setLocation(Location location) {
this.location = location;
}

@JsonProperty("address")
public Address getAddress() {
return address;
}

@JsonProperty("address")
public void setAddress(Address address) {
this.address = address;
}

@JsonProperty("mobile")
public Mobile getMobile() {
return mobile;
}

@JsonProperty("mobile")
public void setMobile(Mobile mobile) {
this.mobile = mobile;
}

@JsonProperty("facilities")
public List<Facility> getFacilities() {
return facilities;
}

@JsonProperty("facilities")
public void setFacilities(List<Facility> facilities) {
this.facilities = facilities;
}

@JsonProperty("checkInPolicy")
public CheckInPolicy getCheckInPolicy() {
return checkInPolicy;
}

@JsonProperty("checkInPolicy")
public void setCheckInPolicy(CheckInPolicy checkInPolicy) {
this.checkInPolicy = checkInPolicy;
}

@JsonProperty("cancellation")
public Cancellation getCancellation() {
return cancellation;
}

@JsonProperty("cancellation")
public void setCancellation(Cancellation cancellation) {
this.cancellation = cancellation;
}

@JsonProperty("margin")
public String getMargin() {
return margin;
}

@JsonProperty("margin")
public void setMargin(String margin) {
this.margin = margin;
}

@JsonProperty("markUp")
public String getMarkUp() {
return markUp;
}

@JsonProperty("markUp")
public void setMarkUp(String markUp) {
this.markUp = markUp;
}

@JsonProperty("hotelStar")
public String getHotelStar() {
return hotelStar;
}

@JsonProperty("hotelStar")
public void setHotelStar(String hotelStar) {
this.hotelStar = hotelStar;
}

@JsonProperty("noOfRooms")
public Integer getNoOfRooms() {
return noOfRooms;
}

@JsonProperty("noOfRooms")
public void setNoOfRooms(Integer noOfRooms) {
this.noOfRooms = noOfRooms;
}

@JsonProperty("noOfFloors")
public String getNoOfFloors() {
return noOfFloors;
}

@JsonProperty("noOfFloors")
public void setNoOfFloors(String noOfFloors) {
this.noOfFloors = noOfFloors;
}

@JsonProperty("hotelClass")
public String getHotelClass() {
return hotelClass;
}

@JsonProperty("hotelClass")
public void setHotelClass(String hotelClass) {
this.hotelClass = hotelClass;
}

@JsonProperty("payAtHotel")
public String getPayAtHotel() {
return payAtHotel;
}

@JsonProperty("payAtHotel")
public void setPayAtHotel(String payAtHotel) {
this.payAtHotel = payAtHotel;
}

@JsonProperty("creationDate")
public String getCreationDate() {
return creationDate;
}

@JsonProperty("creationDate")
public void setCreationDate(String creationDate) {
this.creationDate = creationDate;
}

@JsonProperty("active")
public String getActive() {
return active;
}

@JsonProperty("active")
public void setActive(String active) {
this.active = active;
}

@JsonProperty("stopSell")
public String getStopSell() {
return stopSell;
}

@JsonProperty("stopSell")
public void setStopSell(String stopSell) {
this.stopSell = stopSell;
}

@JsonProperty("bookInstantly")
public String getBookInstantly() {
return bookInstantly;
}

@JsonProperty("bookInstantly")
public void setBookInstantly(String bookInstantly) {
this.bookInstantly = bookInstantly;
}

@JsonProperty("propertyManagedBy")
public String getPropertyManagedBy() {
return propertyManagedBy;
}

@JsonProperty("propertyManagedBy")
public void setPropertyManagedBy(String propertyManagedBy) {
this.propertyManagedBy = propertyManagedBy;
}

@JsonProperty("noOfBathRooms")
public Integer getNoOfBathRooms() {
return noOfBathRooms;
}

@JsonProperty("noOfBathRooms")
public void setNoOfBathRooms(Integer noOfBathRooms) {
this.noOfBathRooms = noOfBathRooms;
}

@JsonProperty("emailId")
public String getEmailId() {
return emailId;
}

@JsonProperty("emailId")
public void setEmailId(String emailId) {
this.emailId = emailId;
}

@JsonProperty("isChannelMgr")
public String getIsChannelMgr() {
return isChannelMgr;
}

@JsonProperty("isChannelMgr")
public void setIsChannelMgr(String isChannelMgr) {
this.isChannelMgr = isChannelMgr;
}

@JsonProperty("paymentTerm")
public String getPaymentTerm() {
return paymentTerm;
}

@JsonProperty("paymentTerm")
public void setPaymentTerm(String paymentTerm) {
this.paymentTerm = paymentTerm;
}

@JsonProperty("status")
public Status getStatus() {
return status;
}

@JsonProperty("status")
public void setStatus(Status status) {
this.status = status;
}

@JsonProperty("vendorStatus")
public String getVendorStatus() {
return vendorStatus;
}

@JsonProperty("vendorStatus")
public void setVendorStatus(String vendorStatus) {
this.vendorStatus = vendorStatus;
}

@JsonProperty("editable")
public String getEditable() {
return editable;
}

@JsonProperty("editable")
public void setEditable(String editable) {
this.editable = editable;
}

@JsonProperty("systemMargin")
public String getSystemMargin() {
return systemMargin;
}

@JsonProperty("systemMargin")
public void setSystemMargin(String systemMargin) {
this.systemMargin = systemMargin;
}

@JsonProperty("isGovtVerified")
public String getIsGovtVerified() {
return isGovtVerified;
}

@JsonProperty("isGovtVerified")
public void setIsGovtVerified(String isGovtVerified) {
this.isGovtVerified = isGovtVerified;
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
