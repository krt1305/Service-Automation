package test1.test1;

/* Copyright 2016 Yatra.com */


import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoomsApproval {
  @JsonIgnore
  private Map<String, RoomApprovalStatus> additionalProperties = new HashMap<String, RoomApprovalStatus>();

  @JsonAnyGetter
  public Map<String, RoomApprovalStatus> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, RoomApprovalStatus value) {
    this.additionalProperties.put(name, value);
  }

}

