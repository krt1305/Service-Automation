package test1.test1;

import java.util.ArrayList;
import java.util.List;

public class VendorReqGen {
	
	Vendor vendor=new Vendor();
	Location location=new Location();
	Address address=new Address();
	Mobile mobile=new Mobile();
	String accomodationType;
	Facility facilityWifi=new Facility();
	Facility facilityKitchen=new Facility();
	Facility facilityBreakFast=new Facility();
	List<Facility> facilities = null;
	List<String> vendorType = null;
	Action action=new Action();
	
	public Vendor setVendorData(String accomodationType,String postAction,String vendorID)
	{

		if(postAction.equalsIgnoreCase("add"))
		{
			    vendorType = new ArrayList<>();
			    vendorType.add("29");
				
				location.setLatitude("27.1698576");
				location.setLongitude("77.9928847");
					
				//Set address details
				address.setAddLine1("1st Cross, Anand's home");
				address.setAddLine2("2nd cross");
				address.setArea("Test Area");
				address.setNearLandmark("near travelguru");
				address.setCity("TEST");
				address.setState("Rajastan");
				address.setCountry("India");
				address.setPin("560095");
				
				//Set Mobile details
				mobile.setCountryCode("91");
				mobile.setNumber("9591521157");
				
				//Set wifi facilities
				facilities = new ArrayList<>();
				facilityKitchen.setId("58");
				facilityKitchen.setName("WIFI");
				
				facilities.add(facilityKitchen);
				//Set wifi facilities
				facilityWifi.setId("1006");
				facilityWifi.setName("Kitchen With Cook");
				facilities.add(facilityWifi);
				
				
				//Set wifi facilities
				facilityBreakFast.setId("32");
				facilityBreakFast.setName("Breakfast Services");
				facilities.add(facilityBreakFast);
				
				vendor.setPropertyType("HomeStay");
				vendor.setVendorType(vendorType);
				vendor.setAccommodationType(accomodationType);
				vendor.setLocation(location);
				vendor.setAddress(address);
				vendor.setMobile(mobile);	
				vendor.setFacilities(facilities);
				action.setVendor(vendor);
				//return vendor;
				return vendor;
		}
		
		else if (postAction.equalsIgnoreCase("edit"))
		{
			vendorType = new ArrayList<>();
			vendor.setVendorId(vendorID);
			vendor.setVendorName("Test homestay");
			vendor.setVendorDescription("Test vendor description");
			action.setVendor(vendor);
			return vendor;
		}
		return vendor;
	   
		
	
	}
	
	
	public void editVendorData()
	{
		
		
	}
	

	public Vendor getVendor() {
		return vendor;
	}


	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}


	public Location getLocation() {
		return location;
	}


	public void setLocation(Location location) {
		this.location = location;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public Mobile getMobile() {
		return mobile;
	}


	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}


	public String getAccomodationType() {
		return accomodationType;
	}


	public void setAccomodationType(String accomodationType) {
		this.accomodationType = accomodationType;
	}
	
	//vendor.setPropertyType("HomeStay");
	
	
	

}
