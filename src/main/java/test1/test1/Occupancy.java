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
"maxAdult",
"maxChild",
"maxGuest",
"extraGuestCharges"
})
public class Occupancy {

@JsonProperty("maxAdult")
private String maxAdult;
@JsonProperty("maxChild")
private String maxChild;
@JsonProperty("maxGuest")
private String maxGuest;
@JsonProperty("extraGuestCharges")
private Integer extraGuestCharges;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("maxAdult")
public String getMaxAdult() {
return maxAdult;
}

@JsonProperty("maxAdult")
public void setMaxAdult(String maxAdult) {
this.maxAdult = maxAdult;
}

@JsonProperty("maxChild")
public String getMaxChild() {
return maxChild;
}

@JsonProperty("maxChild")
public void setMaxChild(String maxChild) {
this.maxChild = maxChild;
}

@JsonProperty("maxGuest")
public String getMaxGuest() {
return maxGuest;
}

@JsonProperty("maxGuest")
public void setMaxGuest(String maxGuest) {
this.maxGuest = maxGuest;
}

@JsonProperty("extraGuestCharges")
public Integer getExtraGuestCharges() {
return extraGuestCharges;
}

@JsonProperty("extraGuestCharges")
public void setExtraGuestCharges(Integer extraGuestCharges) {
this.extraGuestCharges = extraGuestCharges;
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