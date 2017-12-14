package test1.test1;

import java.util.ArrayList;
import java.util.List;

public class RoomReqGen {
	
	String action="Add";
	String price;
	Bed bed=new Bed();
	Occupancy occupancy=new Occupancy();
	Amenity amenity=new Amenity();
	RoomDetail roomdetail=new RoomDetail();
	RoomRQ roomrq=new RoomRQ();
	List <RoomDetail> roomdetailsList=new ArrayList<>();
	
	public List<RoomDetail> setRoomData()
	{
		//Set roomDetails
		//Set room name
		roomdetail.setRoomName("test room name");
		
		//Set bedding details
		
		List <Bed> bedList=new ArrayList<>();
		bed.setType("1DB");
		bed.setCount("1");
		
		bedList.add(bed);
				
		//Set occupancy type;
		occupancy.setMaxAdult("2");
		occupancy.setMaxChild("1");
		occupancy.setMaxGuest("3");
		occupancy.setExtraGuestCharges(100);
		
		//Set amenities
		List <Amenity> amenities=new ArrayList<>();
		amenity.setId("02");
		amenity.setName("Central Air Conditioning");
		amenity.setPrice("10");
		amenities.add(amenity);
		
		amenity.setId("1001");
		amenity.setName("2W Parking Covered");
		amenity.setPrice("200");
		amenities.add(amenity);
		roomdetail.setPrice("2000");
		
	   roomdetail.setBeds(bedList);
	   roomdetail.setOccupancy(occupancy);
	   roomdetail.setAmenities(amenities);
	   roomdetailsList.add(roomdetail);
	   roomrq.setRoomDetails(roomdetailsList);
	   
	   return roomdetailsList;
	   
		
		
		
	}
	

}
