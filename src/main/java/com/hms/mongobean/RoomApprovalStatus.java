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
@JsonPropertyOrder({
"addOrUpdateBeddingDetails",
"addRoom",
"loadInv",
"addOrUpdateAmentiesDetails"
})
public class RoomApprovalStatus {

@JsonProperty("addOrUpdateBeddingDetails")
private Boolean addOrUpdateBeddingDetails;
@JsonProperty("addRoom")
private Boolean addRoom;
@JsonProperty("loadInv")
private Boolean loadInv;
@JsonProperty("addOrUpdateAmentiesDetails")
private Boolean addOrUpdateAmentiesDetails;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("addOrUpdateBeddingDetails")
public Boolean getAddOrUpdateBeddingDetails() {
return addOrUpdateBeddingDetails;
}

@JsonProperty("addOrUpdateBeddingDetails")
public void setAddOrUpdateBeddingDetails(Boolean addOrUpdateBeddingDetails) {
this.addOrUpdateBeddingDetails = addOrUpdateBeddingDetails;
}

@JsonProperty("addRoom")
public Boolean getAddRoom() {
return addRoom;
}

@JsonProperty("addRoom")
public void setAddRoom(Boolean addRoom) {
this.addRoom = addRoom;
}

@JsonProperty("loadInv")
public Boolean getLoadInv() {
return loadInv;
}

@JsonProperty("loadInv")
public void setLoadInv(Boolean loadInv) {
this.loadInv = loadInv;
}

@JsonProperty("addOrUpdateAmentiesDetails")
public Boolean getAddOrUpdateAmentiesDetails() {
return addOrUpdateAmentiesDetails;
}

@JsonProperty("addOrUpdateAmentiesDetails")
public void setAddOrUpdateAmentiesDetails(Boolean addOrUpdateAmentiesDetails) {
this.addOrUpdateAmentiesDetails = addOrUpdateAmentiesDetails;
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
