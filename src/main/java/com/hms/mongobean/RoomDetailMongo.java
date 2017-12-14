

/* Copyright 2016 Yatra.com */
package com.hms.mongobean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"beds", "amenities", "roomName", "stopSell", "price", "cutOff", "maxNight", "minNight", "baseAlloc", "baseAllocFlag",
        "supplier", "currency", "rackRate", "smoking", "propertyLevel", "noOfRooms", "occupancy", "status", "roomId"})
public class RoomDetailMongo {

    @JsonProperty("beds")
    private List<Bed> beds = null;
    @JsonProperty("amenities")
    private List<Amenity> amenities = null;
    @JsonProperty("roomName")
    private String roomName;
    @JsonProperty("stopSell")
    private String stopSell;
    @JsonProperty("price")
    private String price;
    @JsonProperty("cutOff")
    private Integer cutOff;
    @JsonProperty("maxNight")
    private Integer maxNight;
    @JsonProperty("minNight")
    private Integer minNight;
    @JsonProperty("baseAlloc")
    private Integer baseAlloc;
    @JsonProperty("baseAllocFlag")
    private String baseAllocFlag;
    @JsonProperty("supplier")
    private String supplier;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("rackRate")
    private Double rackRate;
    @JsonProperty("smoking")
    private String smoking;
    @JsonProperty("propertyLevel")
    private String propertyLevel;
    @JsonProperty("noOfRooms")
    private Integer noOfRooms;
    @JsonProperty("occupancy")
    private OccupancyMongo occupancy;
    @JsonProperty("status")
    private Status status;
    @JsonProperty("roomId")
    private String roomId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("beds")
    public List<Bed> getBeds() {
        return beds;
    }

    @JsonProperty("beds")
    public void setBeds(List<Bed> beds) {
        this.beds = beds;
    }

    @JsonProperty("amenities")
    public List<Amenity> getAmenities() {
        return amenities;
    }

    @JsonProperty("amenities")
    public void setAmenities(List<Amenity> amenities) {
        this.amenities = amenities;
    }

    @JsonProperty("roomName")
    public String getRoomName() {
        return roomName;
    }

    @JsonProperty("roomName")
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    @JsonProperty("stopSell")
    public String getStopSell() {
        return stopSell;
    }

    @JsonProperty("stopSell")
    public void setStopSell(String stopSell) {
        this.stopSell = stopSell;
    }

    @JsonProperty("price")
    public String getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(String price) {
        this.price = price;
    }

    @JsonProperty("cutOff")
    public Integer getCutOff() {
        return cutOff;
    }

    @JsonProperty("cutOff")
    public void setCutOff(Integer cutOff) {
        this.cutOff = cutOff;
    }

    @JsonProperty("maxNight")
    public Integer getMaxNight() {
        return maxNight;
    }

    @JsonProperty("maxNight")
    public void setMaxNight(Integer maxNight) {
        this.maxNight = maxNight;
    }

    @JsonProperty("minNight")
    public Integer getMinNight() {
        return minNight;
    }

    @JsonProperty("minNight")
    public void setMinNight(Integer minNight) {
        this.minNight = minNight;
    }

    @JsonProperty("baseAlloc")
    public Integer getBaseAlloc() {
        return baseAlloc;
    }

    @JsonProperty("baseAlloc")
    public void setBaseAlloc(Integer baseAlloc) {
        this.baseAlloc = baseAlloc;
    }

    @JsonProperty("baseAllocFlag")
    public String getBaseAllocFlag() {
        return baseAllocFlag;
    }

    @JsonProperty("baseAllocFlag")
    public void setBaseAllocFlag(String baseAllocFlag) {
        this.baseAllocFlag = baseAllocFlag;
    }

    @JsonProperty("supplier")
    public String getSupplier() {
        return supplier;
    }

    @JsonProperty("supplier")
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("rackRate")
    public Double getRackRate() {
        return rackRate;
    }

    @JsonProperty("rackRate")
    public void setRackRate(Double rackRate) {
        this.rackRate = rackRate;
    }

    @JsonProperty("smoking")
    public String getSmoking() {
        return smoking;
    }

    @JsonProperty("smoking")
    public void setSmoking(String smoking) {
        this.smoking = smoking;
    }

    @JsonProperty("propertyLevel")
    public String getPropertyLevel() {
        return propertyLevel;
    }

    @JsonProperty("propertyLevel")
    public void setPropertyLevel(String propertyLevel) {
        this.propertyLevel = propertyLevel;
    }

    @JsonProperty("noOfRooms")
    public Integer getNoOfRooms() {
        return noOfRooms;
    }

    @JsonProperty("noOfRooms")
    public void setNoOfRooms(Integer noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    @JsonProperty("occupancy")
    public OccupancyMongo getOccupancy() {
        return occupancy;
    }

    @JsonProperty("occupancy")
    public void setOccupancy(OccupancyMongo occupancy) {
        this.occupancy = occupancy;
    }

    @JsonProperty("status")
    public Status getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Status status) {
        this.status = status;
    }

    @JsonProperty("roomId")
    public String getRoomId() {
        return roomId;
    }

    @JsonProperty("roomId")
    public void setRoomId(String roomId) {
        this.roomId = roomId;
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
