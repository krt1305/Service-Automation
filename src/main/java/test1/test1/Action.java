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
"action",
"vendor"
})
public class Action {

@JsonProperty("action")
private String action;
@JsonProperty("vendor")
private Vendor vendor;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("action")
public String getAction() {
return action;
}

@JsonProperty("action")
public void setAction(String action) {
this.action = action;
}

@JsonProperty("vendor")
public Vendor getVendor() {
return vendor;
}

@JsonProperty("vendor")
public void setVendor(Vendor vendor) {
this.vendor = vendor;
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