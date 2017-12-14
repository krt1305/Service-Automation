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
@JsonPropertyOrder({
"anyTimeCheckIn",
"checkIn",
"checkOut"
})
public class CheckInPolicy {

@JsonProperty("anyTimeCheckIn")
private String anyTimeCheckIn;
@JsonProperty("checkIn")
private String checkIn;
@JsonProperty("checkOut")
private String checkOut;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("anyTimeCheckIn")
public String getAnyTimeCheckIn() {
return anyTimeCheckIn;
}

@JsonProperty("anyTimeCheckIn")
public void setAnyTimeCheckIn(String anyTimeCheckIn) {
this.anyTimeCheckIn = anyTimeCheckIn;
}

@JsonProperty("checkIn")
public String getCheckIn() {
return checkIn;
}

@JsonProperty("checkIn")
public void setCheckIn(String checkIn) {
this.checkIn = checkIn;
}

@JsonProperty("checkOut")
public String getCheckOut() {
return checkOut;
}

@JsonProperty("checkOut")
public void setCheckOut(String checkOut) {
this.checkOut = checkOut;
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
