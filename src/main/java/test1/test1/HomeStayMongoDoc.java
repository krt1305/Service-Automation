package test1.test1;



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
"userName",
"userType",
"clientIp",
"vendor",
"creationDate",
"createdBySystem",
"roomDetails",
"files",
"vendorId",
"approval",
"verificationDate"
})
public class HomeStayMongoDoc {

@JsonProperty("userName")
private String userName;
@JsonProperty("userType")
private String userType;
@JsonProperty("clientIp")
private String clientIp;
@JsonProperty("vendor")
private VendorMongo vendor;
@JsonProperty("creationDate")
private String creationDate;
@JsonProperty("createdBySystem")
private String createdBySystem;
@JsonProperty("roomDetails")
private List<RoomDetailMongo> roomDetailMongo = null;
@JsonProperty("files")
private List<File> files = null;
@JsonProperty("vendorId")
private String vendorId;
@JsonProperty("approval")
private Approval approval;
@JsonProperty("verificationDate")
private String verificationDate;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("userName")
public String getUserName() {
return userName;
}

@JsonProperty("userName")
public void setUserName(String userName) {
this.userName = userName;
}

@JsonProperty("userType")
public String getUserType() {
return userType;
}

@JsonProperty("userType")
public void setUserType(String userType) {
this.userType = userType;
}

@JsonProperty("clientIp")
public String getClientIp() {
return clientIp;
}

@JsonProperty("clientIp")
public void setClientIp(String clientIp) {
this.clientIp = clientIp;
}

@JsonProperty("vendor")
public VendorMongo getVendor() {
return vendor;
}

@JsonProperty("vendor")
public void setVendor(VendorMongo vendor) {
this.vendor = vendor;
}

@JsonProperty("creationDate")
public String getCreationDate() {
return creationDate;
}

@JsonProperty("creationDate")
public void setCreationDate(String creationDate) {
this.creationDate = creationDate;
}

@JsonProperty("createdBySystem")
public String getCreatedBySystem() {
return createdBySystem;
}

@JsonProperty("createdBySystem")
public void setCreatedBySystem(String createdBySystem) {
this.createdBySystem = createdBySystem;
}

@JsonProperty("roomDetail")
public List<RoomDetailMongo> getRoomDetailMongo() {
  return roomDetailMongo;
}

@JsonProperty("roomDetail")
public void setRoomDetailMongo(List<RoomDetailMongo> roomDetailMongo) {
  this.roomDetailMongo = roomDetailMongo;
}

@JsonProperty("files")
public List<File> getFiles() {
return files;
}

@JsonProperty("files")
public void setFiles(List<File> files) {
this.files = files;
}

@JsonProperty("vendorId")
public String getVendorId() {
return vendorId;
}

@JsonProperty("vendorId")
public void setVendorId(String vendorId) {
this.vendorId = vendorId;
}

@JsonProperty("approval")
public Approval getApproval() {
return approval;
}

@JsonProperty("approval")
public void setApproval(Approval approval) {
this.approval = approval;
}

@JsonProperty("verificationDate")
public String getVerificationDate() {
return verificationDate;
}

@JsonProperty("verificationDate")
public void setVerificationDate(String verificationDate) {
this.verificationDate = verificationDate;
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
