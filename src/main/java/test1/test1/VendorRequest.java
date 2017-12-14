package test1.test1;

import io.restassured.response.Response;

public class VendorRequest {
	
	Action action=new Action();
	VendorReqGen vendorData=new VendorReqGen();
	
	Request req=new Request("application/json");
	Endpoints endpoint=new Endpoints();
	String respVendorID;
	
	
	public String addVendor(String accomType,String postAction,String vendorId)
	{
		if(postAction.equalsIgnoreCase("add"))
		{
			action.setAction("add");
			
			//String accomodationType,String postAction,String vendorID)
			action.setVendor(vendorData.setVendorData(accomType,postAction,""));
			//vendorData.setVendorDetails();
			
			Response resp=req.doPost(action, endpoint.addHMS);
			respVendorID=resp.path("vendorId");
			System.out.println("REsponse vendoor id is "+respVendorID);
			return respVendorID;
		}
		else if(postAction.equals("edit"))
		{
			action.setAction("edit");
			action.setVendor(vendorData.setVendorData(accomType,postAction,vendorId));
			//vendorData.setVendorDetails();
			
			Response resp=req.doPost(action, endpoint.addHMS);
			respVendorID=resp.path("vendorId");
			System.out.println("REsponse vendoor id is "+respVendorID);
			return respVendorID;
		}
		else
		{
			
		}
		return respVendorID;
		
		
		
		
	}
	
	public String editVendor()
	{
		action.setAction("edit");
		return respVendorID;
		
	}

}
