
package test1.test1;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"propertyType",
"vendorType",
"accommodationType",
"location",
"address",
"mobile",
"facilities",
"vendorId",
"vendorName",
"vendorDescription"
})


public class Vendor {
@JsonProperty("vendorId")
private String vendorId;
	@JsonProperty("vendorName")
	private String vendorName;
	@JsonProperty("vendorDescription")
	private String vendorDescription;

@JsonProperty("propertyType")
private String propertyType;
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

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

@JsonProperty("vendorId")
public String getVendorId() {
return vendorId;
}

@JsonProperty("vendorId")
public void setVendorId(String vendorId) {
this.vendorId = vendorId;
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

}