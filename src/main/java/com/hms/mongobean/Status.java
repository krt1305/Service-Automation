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
"PRICING",
"PROPERTY",
"TITLE",
"ROOM"
})
public class Status {

@JsonProperty("PRICING")
private String pRICING;
@JsonProperty("PROPERTY")
private String pROPERTY;
@JsonProperty("TITLE")
private String tITLE;
@JsonProperty("ROOM")
private String rOOM;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("PRICING")
public String getPRICING() {
return pRICING;
}

@JsonProperty("PRICING")
public void setPRICING(String pRICING) {
this.pRICING = pRICING;
}

@JsonProperty("PROPERTY")
public String getPROPERTY() {
return pROPERTY;
}

@JsonProperty("PROPERTY")
public void setPROPERTY(String pROPERTY) {
this.pROPERTY = pROPERTY;
}

@JsonProperty("TITLE")
public String getTITLE() {
return tITLE;
}

@JsonProperty("TITLE")
public void setTITLE(String tITLE) {
this.tITLE = tITLE;
}

@JsonProperty("ROOM")
public String getROOM() {
return rOOM;
}

@JsonProperty("ROOM")
public void setROOM(String rOOM) {
this.rOOM = rOOM;
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
