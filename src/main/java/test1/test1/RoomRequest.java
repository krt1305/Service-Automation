package test1.test1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import io.restassured.response.Response;

public class RoomRequest {
	
	RoomRQ roomrq=new RoomRQ();
	RoomReqGen roomregGen=new RoomReqGen();
	
	Request req=new Request("application/json");
	Endpoints endpoint=new Endpoints();
	List <RoomDetail> roomdetailList;
	ObjectMapper mapper = new ObjectMapper();
	
	public String addRoom(String vendorId) throws JsonProcessingException, IOException
	{
		String roomId;
		roomrq.setAction("add");
		System.out.println("Setting vendor id for room "+vendorId);
		roomrq.setVendorId(vendorId);
		roomdetailList=roomregGen.setRoomData();
		roomrq.setRoomDetails(roomdetailList);
		Response resp=req.doPost(roomrq, endpoint.addRoomHMS);
			
		String response=resp.body().asString();
		JsonNode root = mapper.readTree(response);
		
		JsonNode arr=root.get("data").get(0);
		roomId=arr.get("roomId").textValue();
		System.out.println("Room id is "+roomId);
		
		return roomId;
	
	    
		
		
	}

}
