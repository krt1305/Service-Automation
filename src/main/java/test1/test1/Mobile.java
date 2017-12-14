
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
"countryCode",
"number"
})
public class Mobile {

@JsonProperty("countryCode")
private String countryCode;
@JsonProperty("number")
private String number;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("countryCode")
public String getCountryCode() {
return countryCode;
}

@JsonProperty("countryCode")
public void setCountryCode(String countryCode) {
this.countryCode = countryCode;
}

@JsonProperty("number")
public String getNumber() {
return number;
}

@JsonProperty("number")
public void setNumber(String number) {
this.number = number;
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