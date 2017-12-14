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
"vendorId",
"action",
"roomDetails"
})
public class RoomRQ {

@JsonProperty("vendorId")
private String vendorId;
@JsonProperty("action")
private String action;
@JsonProperty("roomDetails")
private List<RoomDetail> roomDetails = null;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("vendorId")
public String getVendorId() {
return vendorId;
}

@JsonProperty("vendorId")
public void setVendorId(String vendorId) {
this.vendorId = vendorId;
}

@JsonProperty("action")
public String getAction() {
return action;
}

@JsonProperty("action")
public void setAction(String action) {
this.action = action;
}

@JsonProperty("roomDetails")
public List<RoomDetail> getRoomDetails() {
return roomDetails;
}

@JsonProperty("roomDetails")
public void setRoomDetails(List<RoomDetail> roomDetails) {
this.roomDetails = roomDetails;
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