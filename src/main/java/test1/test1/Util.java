package test1.test1;


import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.KlovReporter;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.testng.collections.CollectionUtils;

import io.restassured.response.Response;


public class Util {
	
	public ExtentReports extent;
	public ExtentTest logger;
	String importHMS;
	Endpoints endpoint=new Endpoints();
	Request request;
	Location location=new Location();
	List<ImageUploadRS> imageUploadRS = new ArrayList<>();
	Response imageResponse;
    List<Response> vendorImageUploadRes = new ArrayList<>();
    Boolean isPublished;
    MongoDB mongo=new MongoDB();
    SoftAssert softAssert=new SoftAssert();
    HomeStayMongoDoc homeStayMongoDoc=null;
    VendorMongo mongovendor;
	List <RoomDetailMongo> roomMogo;
	Response resp;
	ObjectMapper mapper = new ObjectMapper();

	
	public void initReport()
	{
	
			extent=ExtentManager.getInstance();
			System.out.println("Extent is "+ extent);
		
	}
			
	
	public int importHomestay(String vendorId)
	{
		System.out.println("IMporting homestay");
		importHMS=endpoint.importEndPoint+vendorId;
		request.addHeaders();
		resp=request.doPut(importHMS);
		System.out.println("Status code is "+resp.statusCode());
		return resp.getStatusCode();
		
		
	}
	
	public int verifyImagesPresent(String vendorId) throws IOException
	{
		Request request=new Request("application/json");
		System.out.println("IN verify  images present");
		String b2cEndPoint=endpoint.hmsBaseURL+endpoint.b2cImageEndPoint+vendorId+"?product=hotel";
		System.out.println("B2c endpoint  in get images is  "+b2cEndPoint);
		resp=request.doGet(b2cEndPoint);
		String response=resp.body().asString();
		ArrayList <String> imagesStatus=new ArrayList();
		JsonNode root = mapper.readTree(response);
		/*if(root.hasNonNull("imageInfoList"))
		{
			return 1;
		}
		else
		{
			System.out.println("No images for vendor "+vendorId);
			return 0;
		}
		*/
		return 0;
		

		
	}
	
	public boolean verifyIsImageApproved(String vendorId) throws IOException
	{
		
		System.out.println("IN verify is image approved");
		String b2cEndPoint=endpoint.hmsBaseURL+endpoint.b2cImageEndPoint+vendorId+"?product=hotel";
		System.out.println("B2c endpoint  in get images is  "+b2cEndPoint);
		resp=request.doGet(b2cEndPoint);
		String response=resp.body().asString();
		ArrayList <String> imagesStatus=new ArrayList();
		JsonNode root = mapper.readTree(response);
		
		
	/*	if(root.hasNonNull("imageInfoList"))
		{
			
				System.out.println("Image info list node is present");
				JsonNode arr=root.get("imageInfoList");
				System.out.println("image info array list size is "+arr.size());
				for(int i=1;i<=arr.size();i++)
				{
					String imageStatus=arr.get(i).get("imageStatus").textValue();
					if(imageStatus.equalsIgnoreCase("Approved"))
					{
						return true;
						
					}
						
					else
					{
							continue;
							
					}
					
				}
		}
		else
		{
			System.out.println("No images for vendor ");
			
		}
		*/
		
		return false;
		
		
	}
	
	 public List<Response> uploadVendorImage(int imageCount, boolean _defaultFlag, String vendorId,String caption) 
	 {
		   Request request=new Request();
		    MetaData metaData = new MetaData();
		    metaData.setVendorId(vendorId);
		    metaData.setCaption(caption);
		    metaData.setProduct("Hotel");
		    metaData.setDefault(_defaultFlag);
		  
		    for (int i = 1; i <= imageCount; i++) {
		       imageResponse = request.uploadImage(metaData,endpoint.addVendorImages);
		      try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      imageUploadRS.add(imageResponse.as(ImageUploadRS.class));
		      vendorImageUploadRes.add(imageResponse);
		    }
		    return vendorImageUploadRes;
	 }
	
	 public List<Response> uploadRoomImage(int imageCount, boolean _defaultFlag, String vendorId, String roomId,String caption) {
		 System.out.println("Uploading images for room");
		 Request request=new Request();
		    List<Response> roomImageUploadRes = new ArrayList<>();
		    MetaData metaData = new MetaData();
		    metaData.setVendorId(vendorId);
		    metaData.setRoomId(roomId);		    
		    metaData.setCaption(caption);
		    metaData.setProduct("Hotel");
		    metaData.setDefault(_defaultFlag);
		    for (int i = 1; i <= imageCount; i++) {
		      Response imageResponse = request.uploadImage(metaData,endpoint.addVendorImages);
		      imageUploadRS.add(imageResponse.as(ImageUploadRS.class));
		      roomImageUploadRes.add(imageResponse);
		    }
		    return roomImageUploadRes;
		  }
	
	
	
	public void isImagePresent()
	{
		
	}

	
	/*public void initReport()
	{
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
		KlovReporter klov = new KlovReporter();
		klov.initMongoDbConnection("localhost", 27017);
		// specify project
		// ! you must specify a project, other a "Default project will be used"
		klov.setProjectName("Test project");
		// you must specify a reportName otherwise a default timestamp will be used
		klov.setReportName("test project");
		
		// URL of the KLOV server
		// you must specify the server URL to ensure all your runtime media is uploaded
		// to the server
		klov.setKlovUrl("http://localhost");

		
	}

	*/
	public void getVendorStatus(String vendor)
	{
		logger=extent.startTest(this.getClass().getSimpleName());
		logger.log(LogStatus.INFO, "Vendor status endpoint is "+endpoint.vendorStatus+vendor);
		Request request=new Request();
		resp=request.doGetWithAuth(endpoint.vendorStatus+vendor);
		String response=resp.body().asString();
		logger.log(LogStatus.INFO, "Vendor status response is "+response);
		JsonNode root = null;
		try {
			root = mapper.readTree(response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.log(LogStatus.INFO,"Validating vendor status response");
		String vendorId=root.get("vendorId").textValue();
		Assert.assertEquals(root.get("statusCode").textValue(), "200");
		Assert.assertEquals(root.get("statusMessage").textValue(), "success");
		Assert.assertEquals(root.get("vendorName").textValue(), StringUtils.EMPTY);
		Assert.assertEquals(root.get("publishButton").textValue(), "DISABLE");
		Assert.assertEquals(root.get("publishStatus").textValue(), "Incomplete");
		Assert.assertEquals(root.get("propertyType").textValue(), "HomeStay");
		Assert.assertEquals(root.get("imageCount").intValue(), 0);
		Assert.assertEquals(root.get("pendingImages").intValue(), 0);
		Assert.assertEquals(root.get("approvedImages").intValue(), 0);
		Assert.assertEquals(root.get("rejectedImages").intValue(), 0);
		Assert.assertEquals(root.get("imageTag").textValue(), vendorId);
		
		int statusNodeSize=root.get("propertyStatusList").size();
		System.out.println("Validating property approval status node");
		for(int i=1;i<statusNodeSize;i++)
		{
			if(root.get("propertyStatusList").get(i).get("type").equals("PRICING"))
			Assert.assertEquals(root.get("propertyStatusList").get(i).get("status"), "DISABLE");
			//VERIFY  Property Type status
			
			if(root.get("propertyStatusList").get(i).get("type").equals("PROPERTY"))
				Assert.assertEquals(root.get("propertyStatusList").get(i).get("status"), "COMPLETE");
			
			if(root.get("propertyStatusList").get(i).get("type").equals("TITLE"))
				Assert.assertEquals(root.get("propertyStatusList").get(i).get("status"), "DISABLE");
			
			if(root.get("propertyStatusList").get(i).get("type").equals("ROOM"))
				Assert.assertEquals(root.get("propertyStatusList").get(i).get("status"), "EDITABLE");
			
			if(root.get("propertyStatusList").get(i).get("type").equals("PHOTO"))
				Assert.assertEquals(root.get("propertyStatusList").get(i).get("status"), "DISABLE");
				
		}
		
			Assert.assertEquals(root.get("roomStatusList").size(), 0);	
		
		//Verify if room node has been created in Mongo
			System.out.println("Root is "+root);
			if(root.hasNonNull("roomDetails"))
			{
				int roomNodeSize=root.get("roomDetails").size();
				System.out.println("ROom details node is present");
				Assert.assertEquals(roomNodeSize, 1);
			}
			else
			{
				logger.log(LogStatus.INFO, "Room node has not been created after adding vendor");
				System.out.println("Room node has not been created after ading vendor");
			}

	}
	
	
	public void validateVendorImageStatus(String vendor)
	{
		logger=extent.startTest(this.getClass().getSimpleName());
		logger.log(LogStatus.INFO, "Vendor status endpoint is "+endpoint.vendorStatus+vendor);
		Request request=new Request();
		resp=request.doGetWithAuth(endpoint.vendorStatus+vendor);
		String response=resp.body().asString();
		logger.log(LogStatus.INFO, "Vendor status response is "+response);
		JsonNode root = null;
		try {
			root = mapper.readTree(response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.log(LogStatus.INFO,"Validating vendor status response");
		String vendorId=root.get("vendorId").textValue();
		logger.log(LogStatus.INFO, "Validating images count at vendor level");
		Assert.assertEquals(root.get("imageCount").intValue(), 3);
		Assert.assertEquals(root.get("pendingImages").intValue(), 3);
		
		
	}

	public void validateRoomImages(String vendor)
	{
		
		logger=extent.startTest(this.getClass().getSimpleName());
		logger.log(LogStatus.INFO, "Vendor status endpoint is "+endpoint.vendorStatus+vendor);
		Request request=new Request();
		resp=request.doGetWithAuth(endpoint.vendorStatus+vendor);
		String response=resp.body().asString();
		logger.log(LogStatus.INFO, "Vendor status response is "+response);
		JsonNode root = null;
		try {
			root = mapper.readTree(response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.log(LogStatus.INFO,"Validating vendor status response");
		String vendorId=root.get("vendorId").textValue();
		logger.log(LogStatus.INFO, "Validating images count at room level");
		System.out.println("Room status list count "+root.get("roomStatusList").size());
		Assert.assertEquals(root.get("roomStatusList").get(0).get("imageCount").intValue(),1);
		Assert.assertEquals(root.get("roomStatusList").get(0).get("pendingImages").intValue(),1);
	}
	
	
	
	public void publishProperty(String vendorID)
	{
		Request request=new Request();
		resp=request.doPost(endpoint.publishHMS+vendorID);
		Assert.assertEquals(200, resp.getStatusCode());
		validatePublishProperty(vendorID);
		
	}
	
	public void validatePublishProperty(String vendorID)
	{
		
		String mongoResponse=mongo.getMongoDocJsonStr(vendorID);
		try {
			homeStayMongoDoc = mapper.readValue(mongoResponse.getBytes(), HomeStayMongoDoc.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(homeStayMongoDoc);
		System.out.println("Validatting publish property=======================================");
		if(homeStayMongoDoc.getFiles()!=null)
		{
			Assert.assertEquals(homeStayMongoDoc.getFiles().get(0).getCategory(), "TC");
			Assert.assertEquals(homeStayMongoDoc.getFiles().get(0).getFilename(), "TG Stays Vendor Agreement.pdf");
			
		}
		
		
	}
	
	public void validateVendorMongoDetails(String vendor,String accomType)
	{
		//Validate MongoDoc after creation
		
		        logger=extent.startTest(this.getClass().getSimpleName());
		        logger.log(LogStatus.INFO, "Validating vendor mongo details after creation");     
				String mongoResponse=mongo.getMongoDocJsonStr(vendor);
			
				try {
					homeStayMongoDoc = mapper.readValue(mongoResponse.getBytes(), HomeStayMongoDoc.class);
					System.out.println(homeStayMongoDoc);//readTree(mongoResponse);
					
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				mongovendor =homeStayMongoDoc.getVendor();

				Assert.assertEquals(homeStayMongoDoc.getUserType(), "HMS");
				Assert.assertEquals(homeStayMongoDoc.getUserName(),"100500063");
				Assert.assertEquals(homeStayMongoDoc.getClientIp(),"192.168.18.152");
				Assert.assertEquals(mongovendor.getPropertyType(),"HomeStay");
				Assert.assertEquals(mongovendor.getMargin(),"10.0");
				Assert.assertEquals(mongovendor.getMarkUp(),"11.11");
				Assert.assertEquals(mongovendor.getHotelStar(),"0");
				Assert.assertEquals(mongovendor.getNoOfRooms().intValue(),0);
				Assert.assertEquals(mongovendor.getNoOfFloors(),"1");
				Assert.assertEquals(mongovendor.getHotelClass(),"General");
				Assert.assertEquals(mongovendor.getPayAtHotel(),"N");
				Assert.assertEquals(mongovendor.getActive(),"I");
				Assert.assertEquals(mongovendor.getStopSell(),"Y");
				Assert.assertEquals(mongovendor.getPropertyManagedBy(),"Owner");
				Assert.assertEquals(mongovendor.getEmailId(),"automatio1n@tgqa.com");
				Assert.assertEquals(mongovendor.getIsChannelMgr(),"N");
				Assert.assertEquals(mongovendor.getPaymentTerm(), "P");
				
				logger.log(LogStatus.INFO, "Validated mongo document");
				logger.log(LogStatus.INFO, "Validating vendor status node");
				
				//Check status should be incomplete		
				System.out.println("Validating if status is incomplete");
				Assert.assertEquals(mongovendor.getStatus().getPRICING(), "DISABLE");
				logger.log(LogStatus.INFO, "Vendor status pricing field "+mongovendor.getStatus().getPRICING());
				Assert.assertEquals(mongovendor.getStatus().getPROPERTY(), "COMPLETE");
				logger.log(LogStatus.INFO, "Vendor status pricing field "+mongovendor.getStatus().getPROPERTY());
				Assert.assertEquals(mongovendor.getStatus().getTITLE(), "DISABLE");
				logger.log(LogStatus.INFO, "Vendor status pricing field "+mongovendor.getStatus().getTITLE());
				Assert.assertEquals(mongovendor.getStatus().getROOM(), "EDITABLE");
				logger.log(LogStatus.INFO, "Vendor status pricing field "+mongovendor.getStatus().getROOM());	
			    logger.log(LogStatus.INFO, "Venor id is "+vendor);
			    logger.log(LogStatus.INFO, "Verifying if room node has been created for vendor "+vendor);

			    roomMogo=homeStayMongoDoc.getRoomDetailMongo();
			    if(roomMogo.size()!=1)
			    {
			    	logger.log(LogStatus.INFO, "After adding vendor room size is not 1");
			    }
			    else
			    {
			    	 if(roomMogo.get(0) !=null)
			 	    {
			 	    	logger.log(LogStatus.INFO, "Validating default room details");
			 	    	Assert.assertEquals(roomMogo.get(0).getRoomName(), "Entire Property");
			 	    	if(accomType.equalsIgnoreCase("room"))
			 	    		Assert.assertEquals(roomMogo.get(0).getStopSell(), "Y");
			 	    	else
			 	    		Assert.assertEquals(roomMogo.get(0).getStopSell(), "N");
			 	   
			 	    	Assert.assertEquals(roomMogo.get(0).getCutOff().intValue(), 1);
			 	    	Assert.assertEquals(roomMogo.get(0).getMaxNight().intValue(), 29);
			 	    	Assert.assertEquals(roomMogo.get(0).getMinNight().intValue(), 1);
			 	    	Assert.assertEquals(roomMogo.get(0).getBaseAlloc().intValue(), 0);
			 	    	Assert.assertEquals(roomMogo.get(0).getBaseAllocFlag(), "N");
			 	    	Assert.assertEquals(roomMogo.get(0).getSupplier(), "TRAVELGURU");
			 	    	Assert.assertEquals(roomMogo.get(0).getCurrency(), "INR");
			 	    	Assert.assertEquals(roomMogo.get(0).getSupplier(), "TRAVELGURU");
			 	    	Assert.assertEquals(roomMogo.get(0).getRackRate().doubleValue(), 0.0);
			 	    	Assert.assertEquals(roomMogo.get(0).getSmoking(), "N");
			 	    	Assert.assertEquals(roomMogo.get(0).getPropertyLevel(), "Y");
			 	    	Assert.assertEquals(roomMogo.get(0).getNoOfRooms().intValue(), 1);
			 	    	logger.log(LogStatus.INFO, "Validating default room status node");
			 	    	//Complete for room only
			 	    	if(accomType.equalsIgnoreCase("room"))
			 	    	Assert.assertEquals(roomMogo.get(0).getStatus().getPRICING(), "COMPLETE");
			 	    	else
			 	    		
			 	    	Assert.assertEquals(roomMogo.get(0).getStatus().getPRICING(), "ENABLE");
			 	    	logger.log(LogStatus.INFO, "Validating default room occupancy details");
			 	    	Assert.assertEquals(roomMogo.get(0).getOccupancy().getMaxAdult().intValue(), 0);
			 	    	Assert.assertEquals(roomMogo.get(0).getOccupancy().getMaxChild().intValue(), 0);
			 	    	Assert.assertEquals(roomMogo.get(0).getOccupancy().getMaxGuest().intValue(), 0);
			 	    	Assert.assertEquals(roomMogo.get(0).getOccupancy().getMaxInfant().intValue(), 0);
			 	    	Assert.assertEquals(roomMogo.get(0).getOccupancy().getMinAge().intValue(), 12);
			 	    	Assert.assertEquals(roomMogo.get(0).getOccupancy().getFreeStayAge().intValue(), 6);
			 	    	Assert.assertEquals(roomMogo.get(0).getOccupancy().getExtraGuestCharges().doubleValue(), 0.0);
			 	    	
			 	    	
			 	    }
			 	    else
			 	    {
			 	    	logger.log(LogStatus.FAIL, "Room detail node not present after adding vendor");
			 	    }
			    }
		
			    
			  
	}
	
	
	public void approveProperty(String vendorId)
	{
		Request request=new Request();
		HashMap map=new HashMap();
		map.put("vendorId", vendorId);
		map.put("status","Approved");
		resp=request.doPutAdmin(map,endpoint.approval);
		softAssert.assertEquals(200, resp.getStatusCode());
		//Assert.assertEquals(200, resp.getStatusCode());
		logger.log(LogStatus.INFO, "Validating approved property");
		validatePropertyAfterApproval(vendorId);
		
		
		
	}
	
	public void validatePropertyAfterApproval(String id)
	
	{
		
		String isActive;
		//Verify active detail
		System.out.println("Validating property after approval");
		//Verify approval node in mongo
		mongo.setMongoConnection();
		System.out.println("Getting mongo document from validate after approval ");
	//	mongo.getMongoDocJsonStr(id);
		
		String mongoResponse=mongo.getMongoDocJsonStr(id);
		JsonNode root = null;
		try {
			homeStayMongoDoc = mapper.readValue(mongoResponse.getBytes(), HomeStayMongoDoc.class);
			System.out.println(homeStayMongoDoc);//readTree(mongoResponse);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		logger.log(LogStatus.INFO, "Validating vendor status node");
		if(homeStayMongoDoc.getApproval().getVendor()!=null)
		{
			logger.log(LogStatus.INFO, "Vendor status node is not empty");
			System.out.println("Active status is "+homeStayMongoDoc.getVendor().getActive().toString());
			if(homeStayMongoDoc.getApproval().getVendor()!=null)
			{
				//Get status
				Assert.assertEquals(homeStayMongoDoc.getApproval().getVendor().getUpdateAmenityList(), Boolean.TRUE);
				Assert.assertEquals(homeStayMongoDoc.getApproval().getVendor().getUpdateBrandInfo(), Boolean.TRUE);
				Assert.assertEquals(homeStayMongoDoc.getApproval().getVendor().getUpdateCategoryMapping(), Boolean.TRUE);
				Assert.assertEquals(homeStayMongoDoc.getApproval().getVendor().getInsertVendorInfo(), Boolean.TRUE);
				Assert.assertEquals(homeStayMongoDoc.getApproval().getVendor().getUpdateGroupInfo(), Boolean.TRUE);
				Assert.assertEquals(homeStayMongoDoc.getApproval().getVendor().getUpdateBrandInfo(), Boolean.TRUE);
				Assert.assertEquals(homeStayMongoDoc.getApproval().getVendor().getUpdateCancelInfo(), Boolean.TRUE);
				Assert.assertEquals(homeStayMongoDoc.getApproval().getVendor().getUpdateContactInfo(), Boolean.TRUE);
				Assert.assertEquals(homeStayMongoDoc.getApproval().getVendor().getUpdateImageDetails(), Boolean.TRUE);
				Assert.assertEquals(homeStayMongoDoc.getApproval().getVendor().getInsertScSt(), Boolean.TRUE);
				logger.log(LogStatus.INFO, "Update amenity list node "+homeStayMongoDoc.getApproval().getVendor().getUpdateAmenityList());
				logger.log(LogStatus.INFO, "Update amenity list node "+homeStayMongoDoc.getApproval().getVendor().getUpdateBrandInfo());
				logger.log(LogStatus.INFO, "Update amenity list node "+homeStayMongoDoc.getApproval().getVendor().getUpdateCategoryMapping());
				logger.log(LogStatus.INFO, "Update amenity list node "+homeStayMongoDoc.getApproval().getVendor().getInsertVendorInfo());
				logger.log(LogStatus.INFO, "Update amenity list node "+homeStayMongoDoc.getApproval().getVendor().getUpdateGroupInfo());
				logger.log(LogStatus.INFO, "Update amenity list node "+homeStayMongoDoc.getApproval().getVendor().getUpdateBrandInfo());
				logger.log(LogStatus.INFO, "Update amenity list node "+homeStayMongoDoc.getApproval().getVendor().getUpdateCancelInfo());
				logger.log(LogStatus.INFO, "Update amenity list node "+homeStayMongoDoc.getApproval().getVendor().getUpdateContactInfo());
				logger.log(LogStatus.INFO, "Update amenity list node "+homeStayMongoDoc.getApproval().getVendor().getUpdateImageDetails());	
				logger.log(LogStatus.INFO, "Update amenity list node "+homeStayMongoDoc.getApproval().getVendor().getInsertScSt());
				
				
				
				
			}
				
					
		}	
		else
		{
			
			logger.log(LogStatus.FAIL, "Vendor aproval node not found after approval");
		}
		
		if(homeStayMongoDoc.getApproval().getCache()!=null)
		{
			logger.log(LogStatus.INFO, "Validating approval cache node");
			Assert.assertEquals(homeStayMongoDoc.getApproval().getCache(), "success");
		}
		else
		{
			System.out.println("Cache node is null");
			logger.log(LogStatus.INFO, "Approval cache node is null after approval");
		}
		if(homeStayMongoDoc.getApproval().getImage()!=null)
		{
			Assert.assertEquals(homeStayMongoDoc.getApproval().getImage(), "success");
			logger.log(LogStatus.INFO, "Valiating approval image node ");
		}
		
		else
		{
			System.out.println("Image node is null");
			logger.log(LogStatus.INFO, "Approval image node is null");
		}
		
		
		
		
		
		
	}
}
