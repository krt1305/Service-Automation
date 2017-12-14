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
"roomName",
"beds",
"occupancy",
"amenities",
"noOfRooms",
"price"
})
public class RoomDetail {

@JsonProperty("roomName")
private String roomName;
@JsonProperty("beds")
private List<Bed> beds = null;
@JsonProperty("occupancy")
private Occupancy occupancy;
@JsonProperty("amenities")
private List<Amenity> amenities = null;
@JsonProperty("noOfRooms")
private String noOfRooms;
@JsonProperty("price")
private String price;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("roomName")
public String getRoomName() {
return roomName;
}

@JsonProperty("roomName")
public void setRoomName(String roomName) {
this.roomName = roomName;
}

@JsonProperty("beds")
public List<Bed> getBeds() {
return beds;
}

@JsonProperty("beds")
public void setBeds(List<Bed> beds) {
this.beds = beds;
}

@JsonProperty("occupancy")
public Occupancy getOccupancy() {
return occupancy;
}

@JsonProperty("occupancy")
public void setOccupancy(Occupancy occupancy) {
this.occupancy = occupancy;
}

@JsonProperty("amenities")
public List<Amenity> getAmenities() {
return amenities;
}

@JsonProperty("amenities")
public void setAmenities(List<Amenity> amenities) {
this.amenities = amenities;
}

@JsonProperty("noOfRooms")
public String getNoOfRooms() {
return noOfRooms;
}

@JsonProperty("noOfRooms")
public void setNoOfRooms(String noOfRooms) {
this.noOfRooms = noOfRooms;
}

@JsonProperty("price")
public String getPrice() {
return price;
}

@JsonProperty("price")
public void setPrice(String price) {
this.price = price;
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