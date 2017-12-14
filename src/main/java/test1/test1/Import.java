package test1.test1;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.security.auth.login.LoginContext;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;
import net.sourceforge.jtds.util.Logger;

public class Import extends Util {

	DbConnection con=new DbConnection();
	ResultSet hms;
	Request request=new Request();
	MongoDB mongo=new MongoDB();
	Util util=new Util();
	int statusCode;
	String vendor;
	HomeStayMongoDoc homeStayMongoDoc=null;
	ObjectMapper mapper =new ObjectMapper();
	SoftAssert softassert=new SoftAssert();
	String mongoResponse;
	//int totalImages;
	VendorMongo mongovendor;
	List <RoomDetailMongo> roomMogo;
	Endpoints endpoint=new Endpoints();
	public ExtentReports extent;
	public ExtentTest logger;
	
	@BeforeSuite
	public void init()
	{
		
		con.setConn();
		mongo.setMongoConnection();
		util.initReport();
	/*	if (extent == null) 
		{
			Date d=new Date();
			String fileName=d.toString().replace(":", "_").replace(" ", "_")+".html";
			extent = new ExtentReports(System.getProperty("user.dir")+"\\REPORTS\\"+fileName, true, DisplayOrder.NEWEST_FIRST);
		
		}
		*/
	}
	
	
	/*@Test
	public void importNonHomestayProperties() throws SQLException
	{
		String nonHomestayProperties="select distinct top 1 vendor_id , property_type FROM DS_REGISTERED_VENDOR a left join DS_MANGLED_CITY_NAMES b on a.City=b.Right_City_Name where a.HotelSearchKey is not null and a.HotelSearchKey != '' and a.PROPERTY_TYPE!='homestay' and a.active in ('Y','T') and a.City in ('automation',b.Right_City_Name) and b.AUTO_SUGGEST_ENABLE in ('Y')";
		hms=con.getDBResultSet(nonHomestayProperties);
		while(hms.next())
		{
			vendor=hms.getString(1);
		}
		statusCode=util.importHomestay(vendor);
		Assert.assertEquals(500, statusCode);
		hms=null;
	
		
	}
	
	@Test
	public void importNonApprovedVendors() throws SQLException
	{
		String inactiveProperties="select distinct top 1 vendor_id FROM DS_REGISTERED_VENDOR a left join DS_MANGLED_CITY_NAMES b on a.City=b.Right_City_Name where a.HotelSearchKey is not null and a.HotelSearchKey != '' and a.PROPERTY_TYPE='homestay' and a.active in ('U') and a.City in ('automation',b.Right_City_Name) and b.AUTO_SUGGEST_ENABLE in ('Y')";
		hms=con.getDBResultSet(inactiveProperties);
		while(hms.next())
		{
			vendor=hms.getString(1);
		}
		statusCode=util.importHomestay(vendor);
		Assert.assertEquals(500, statusCode);
		hms=null;
	
	
	}
	
	//Check why 404
	@Test
	public void importDeletedVendors() throws SQLException
	{
		String deletedVendor="select distinct top 1 vendor_id FROM DS_REGISTERED_VENDOR a left join DS_MANGLED_CITY_NAMES b on a.City=b.Right_City_Name where a.HotelSearchKey is not null and a.HotelSearchKey != '' and a.PROPERTY_TYPE='homestay' and a.active in ('Y') and a.deleted='Y' and a.City in ('automation',b.Right_City_Name) and b.AUTO_SUGGEST_ENABLE in ('Y')";
		hms=con.getDBResultSet(deletedVendor);
		while(hms.next())
		{
			vendor=hms.getString(1);
		}
		statusCode=util.importHomestay(vendor);
		Assert.assertEquals(500, statusCode);
		hms=null;
	
	}
	
	
	//Check why 404
	@Test
	public void importNoAutoSuggestCity() throws SQLException
	{
		String noAutoSuggestCity="select distinct top 1 vendor_id FROM DS_REGISTERED_VENDOR a left join DS_MANGLED_CITY_NAMES b on a.City=b.Right_City_Name where a.HotelSearchKey is not null and a.HotelSearchKey != '' and a.PROPERTY_TYPE='homestay' and a.active in ('Y')  and a.City in ('automation',b.Right_City_Name) and b.AUTO_SUGGEST_ENABLE in ('N')";
		hms=con.getDBResultSet(noAutoSuggestCity);
		while(hms.next())
		{
			vendor=hms.getString(1);
		}
		statusCode=util.importHomestay(vendor);
		Assert.assertEquals(500, statusCode);
		hms=null;
	}
	
	
	//should have been 200..giving 404
	@Test
	public void importAutomationCity() throws SQLException
	{
		String automationCity="select distinct top 1 vendor_id FROM DS_REGISTERED_VENDOR a left join DS_MANGLED_CITY_NAMES b on a.City=b.Right_City_Name where a.HotelSearchKey is not null and a.HotelSearchKey != '' and a.PROPERTY_TYPE='homestay' and a.active in ('Y')  and a.City in ('automation') and b.AUTO_SUGGEST_ENABLE in ('Y')";
		hms=con.getDBResultSet(automationCity);
		while(hms.next())
		{
			vendor=hms.getString(1);
		}
		statusCode=util.importHomestay(vendor);
		Assert.assertEquals(500, statusCode);
		hms=null;
	}
	
	
	//GIving 404
	@Test
	public void importUnlistedVendors() throws SQLException
	{
		String unlistedProperty="select distinct top 1 vendor_id FROM DS_REGISTERED_VENDOR a left join DS_MANGLED_CITY_NAMES b on a.City=b.Right_City_Name where a.HotelSearchKey is not null and a.HotelSearchKey != '' and a.PROPERTY_TYPE='homestay' and a.active in ('Y','T') and a.City in ('automation',b.Right_City_Name) and a.stop_Sell='Y' and b.AUTO_SUGGEST_ENABLE in ('Y')";
		hms=con.getDBResultSet(unlistedProperty);
		while(hms.next())
		{
			vendor=hms.getString(1);
		}
		statusCode=util.importHomestay(vendor);
		Assert.assertEquals(500, statusCode);
		hms=null;
	}
	
	//Getting 500
	
	@Test
	public void vendorWithNoImages() throws SQLException, IOException
	{
		int totalImages;
		System.out.println("Vendor without images *************************************************");
		String validVendors="select distinct top 1 vendor_id FROM DS_REGISTERED_VENDOR a left join DS_MANGLED_CITY_NAMES b on a.City=b.Right_City_Name where a.HotelSearchKey is not null and a.HotelSearchKey != '' and a.PROPERTY_TYPE='homestay' and a.active in ('Y','T') and a.City in ('automation',b.Right_City_Name) and b.AUTO_SUGGEST_ENABLE in ('Y')";
		hms=con.getDBResultSet(validVendors);
		while(hms.next())
		{
			vendor=hms.getString(1);
			totalImages=util.verifyImagesPresent(vendor);
			if(totalImages==0)
			{
				statusCode=util.importHomestay(vendor);
				Assert.assertEquals(500, statusCode);
				break;
				
			}
			else
			{
				System.out.println("Vendor has images...Skipping");
				//Check the status of the images
				
			}
			
			hms=null;
		}
		
	}
	
	
	
	@Test
	public void verifyVendorWithImages() throws SQLException, IOException
	{
		int totalImages;
		System.out.println("Vendor with images *************************************************");
		String validVendors="select distinct  vendor_id FROM DS_REGISTERED_VENDOR a left join DS_MANGLED_CITY_NAMES b on a.City=b.Right_City_Name where a.HotelSearchKey is not null and a.HotelSearchKey != '' and a.PROPERTY_TYPE='homestay' and a.active in ('Y','T') and a.City in ('automation',b.Right_City_Name) and b.AUTO_SUGGEST_ENABLE in ('Y')";
		hms=con.getDBResultSet(validVendors);
		int count = 0;
		
	 while(hms.next())
		{
		 	System.out.println("Vendor "+count);
			//System.out.println("In while");
			vendor=hms.getString(1);
			totalImages=util.verifyImagesPresent(vendor);
			if(totalImages==0)
			{
				//System.out.println("Vendor does not have images.Skipping");
				continue;
				
			}
			else
			{
				System.out.println("Vendor has image");
				boolean isApproved=util.verifyIsImageApproved(vendor);
				String propType;
				if(isApproved==true)
				{
					System.out.println("Approved image is true for vendor "+vendor);
					System.out.println("importing venor id "+vendor);
					statusCode=util.importHomestay(vendor);
					System.out.println();
					Assert.assertEquals(200, statusCode);
					break;
					
				}
				
			
			}
			
			
		}
	 
	 hms=null;
		
	}
	
	
	/*
	
	@Test
	public void importRoomOnly() throws SQLException, IOException
	{
		int totalImages;
		String roomOnlyVendor="select distinct  vendor_id FROM DS_REGISTERED_VENDOR a left join DS_MANGLED_CITY_NAMES b on a.City=b.Right_City_Name where a.HotelSearchKey is not null and a.HotelSearchKey != '' and a.PROPERTY_TYPE='homestay' and a.OccupancyType='room' and a.active in ('Y','T') and a.City in ('automation',b.Right_City_Name) and a.stop_Sell='Y' and b.AUTO_SUGGEST_ENABLE in ('Y')";
		hms=con.getDBResultSet(roomOnlyVendor);
		 while(hms.next())
			{
			 	
				System.out.println("In while");
				vendor=hms.getString(1);
				totalImages=util.verifyImagesPresent(vendor);
				if(totalImages==0)
				{
					//System.out.println("Vendor does not have images.Skipping");
					continue;
					
				}
				else
				{
					System.out.println("Vendor has image");
					boolean isApproved=util.verifyIsImageApproved(vendor);
					String propType;
					if(isApproved==true)
					{
						System.out.println("Approved image is true for vendor "+vendor);
						statusCode=util.importHomestay(vendor);
						System.out.println();
						//PENDING - add for 201 status code
						Assert.assertEquals(200, statusCode);
						break;
						
					}
					
				
				}
				
				
			}
		 
		
		hms=null;
		
	}
	
	
	
	@Test
	public void importRoomEntireProp() throws SQLException, IOException
	{
		int totalImages;
		String roomOnlyVendor="select distinct  vendor_id FROM DS_REGISTERED_VENDOR a left join DS_MANGLED_CITY_NAMES b on a.City=b.Right_City_Name where a.HotelSearchKey is not null and a.HotelSearchKey != '' and a.PROPERTY_TYPE='homestay' and a.OccupancyType='roomAndApartment' and a.active in ('Y','T') and a.City in ('automation',b.Right_City_Name) and a.stop_Sell='Y' and b.AUTO_SUGGEST_ENABLE in ('Y')";
		hms=con.getDBResultSet(roomOnlyVendor);
		 while(hms.next())
			{
			 	
				System.out.println("In while");
				vendor=hms.getString(1);
				totalImages=util.verifyImagesPresent(vendor);
				if(totalImages==0)
				{
					//System.out.println("Vendor does not have images.Skipping");
					continue;
					
				}
				else
				{
					System.out.println("Vendor has image");
					boolean isApproved=util.verifyIsImageApproved(vendor);
					String propType;
					if(isApproved==true)
					{
						System.out.println("Approved image is true for vendor "+vendor);
						statusCode=util.importHomestay(vendor);
						System.out.println();
						Assert.assertEquals(200, statusCode);
						break;
						
					}
					
				
				}
				
				
			}
		 
		
		hms=null;
	}
	
	
	/*@Test
	public void importEntireProp() throws SQLException, IOException
	{
		
		//entireApartment
		int totalImages;
		String roomOnlyVendor="select distinct  vendor_id FROM DS_REGISTERED_VENDOR a left join DS_MANGLED_CITY_NAMES b on a.City=b.Right_City_Name where a.HotelSearchKey is not null and a.HotelSearchKey != '' and a.PROPERTY_TYPE='homestay' and a.OccupancyType='entireApartment' and a.active in ('Y','T') and a.City in ('automation',b.Right_City_Name) and a.stop_Sell='Y' and b.AUTO_SUGGEST_ENABLE in ('Y')";
		hms=con.getDBResultSet(roomOnlyVendor);
		 while(hms.next())
			{
			 	
				System.out.println("In while");
				vendor=hms.getString(1);
				totalImages=util.verifyImagesPresent(vendor);
				if(totalImages==0)
				{
					//System.out.println("Vendor does not have images.Skipping");
					continue;
					
				}
				else
				{
					System.out.println("Vendor has image");
					boolean isApproved=util.verifyIsImageApproved(vendor);
					String propType;
					if(isApproved==true)
					{
						System.out.println("Approved image is true for vendor "+vendor);
						statusCode=util.importHomestay(vendor);
						System.out.println();
						Assert.assertEquals(201, statusCode);
						break;
						
					}
					
				
				}
				
				
			}
		 
		
		hms=null;
		
	}
	
	
	
*/	
	@Test
	public void addVendorWithRoomOnly()
	{
		
		String accomodationType="room";
		logger=util.extent.startTest("room");
	    logger.log(LogStatus.INFO, "Adding entire property accomodation type");
		
	  //add vendor
	  		VendorRequest vendorRQ=new VendorRequest();
	  		String vendor=vendorRQ.addVendor(accomodationType,"add","");
	  		logger.log(LogStatus.INFO, "Validating mongo after vendor creation");
	  		System.out.println("Vendor id in add vendor with room only is "+vendor);
	  		util.validateVendorMongoDetails(vendor,accomodationType);
	  		 
	  		logger.log(LogStatus.INFO, "Getting vendor status :");
	  	   
	  		//Validate vendor details after hitting Get vendor status
	  	    util.getVendorStatus(vendor);
		
		//PENDING 
		// Where should the room price be given
			logger.log(LogStatus.INFO, "Adding room ");
			RoomRequest roomrq=new RoomRequest();
			String roomId = null;
			try {
				roomId = roomrq.addRoom(vendor);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			//Add images for vendor level 
			logger.log(LogStatus.INFO, "Adding images for vendor");
			List<Response> resp=util.uploadVendorImage(3,false , vendor,"caption");
			System.out.println("Response list size " +resp.size());
			logger.log(LogStatus.INFO,"Validating vendor images");
			util.validateVendorImageStatus(vendor);
			
			//Update room level images		
			util.uploadRoomImage(1, false, vendor,roomId,"caption");
			util.validateRoomImages(vendor);
			
			
			//Update vendor title and vendor description
			vendorRQ=new VendorRequest();
			vendorRQ.addVendor(accomodationType,"edit",vendor);
			
			//Publish property 
			   util.publishProperty(vendor);
			   util.approveProperty(vendor);
	
		
	}
	
	@Test
	public void addEntirePropVendor()
	{
		//roomAndApartment
		String accomodationType="entireApartment";
		logger=util.extent.startTest("addEntirePropRoomVendor");
	    logger.log(LogStatus.INFO, "Adding entire property accomodation type");
		
	  //add vendor
	  		VendorRequest vendorRQ=new VendorRequest();
	  		String vendor=vendorRQ.addVendor(accomodationType,"add","");
	  		logger.log(LogStatus.INFO, "Validating mongo after vendor creation");
	  		util.validateVendorMongoDetails(vendor,accomodationType);
	  		 
	  		logger.log(LogStatus.INFO, "Getting vendor status :");
	  	   
	  		//Validate vendor details after hitting Get vendor status
	  	    util.getVendorStatus(vendor);
		
		//PENDING 
		// Where should the room price be given
			logger.log(LogStatus.INFO, "Adding room ");
			RoomRequest roomrq=new RoomRequest();
			String roomId = null;
			try {
				roomId = roomrq.addRoom(vendor);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			//Add images for vendor level 
			logger.log(LogStatus.INFO, "Adding images for vendor");
			List<Response> resp=util.uploadVendorImage(3,false , vendor,"caption");
			System.out.println("Response list size " +resp.size());
			logger.log(LogStatus.INFO,"Validating vendor images");
			util.validateVendorImageStatus(vendor);
			
			logger.log(LogStatus.INFO, "Uploading one room image");
			//Update one image for room level images		
			util.uploadRoomImage(1, false, vendor,roomId,"caption");
			logger.log(LogStatus.INFO, "Validating uploaded room images");
			util.validateRoomImages(vendor);
						
			//Update vendor title and vendor description
			logger.log(LogStatus.INFO, "Adding venor title and description");
			vendorRQ=new VendorRequest();
			vendorRQ.addVendor(accomodationType,"edit",vendor);

			logger.log(LogStatus.INFO, "Publishing property");
			//Publish property 
			   util.publishProperty(vendor);
			 logger.log(LogStatus.INFO, "Approving property");
			 util.approveProperty(vendor);
		
	}

	
	@Test
	public void addEntirePropRoomVendor() throws JsonProcessingException, IOException
	{
	
	//	String accomodationType="roomAndApartment";
		String accomodationType="entireApartment";
		logger=util.extent.startTest("addEntirePropRoomVendor");
	    logger.log(LogStatus.INFO, "Adding vendor with accomodation type entire property and apartment");

		//add vendor
		VendorRequest vendorRQ=new VendorRequest();
		String vendor=vendorRQ.addVendor(accomodationType,"add","");
		logger.log(LogStatus.INFO, "Validating mongo after vendor creation");
		util.validateVendorMongoDetails(vendor,accomodationType);
		 
		logger.log(LogStatus.INFO, "Getting vendor status :");
	   
		//Validate vendor details after hitting Get vendor status
	    util.getVendorStatus(vendor);	
		
		//PENDING 
		// Where should the room price be given
			
		RoomRequest roomrq=new RoomRequest();
		String roomId=roomrq.addRoom(vendor);
		

		//Add images for vendor level 
		logger.log(LogStatus.INFO, "Adding images for vendor");
		List<Response> resp=util.uploadVendorImage(3,false , vendor,"caption");
		System.out.println("Response list size " +resp.size());
		logger.log(LogStatus.INFO,"Validating vendor images");
		util.validateVendorImageStatus(vendor);
		
		//Update room level images		
		logger.log(LogStatus.INFO, "Uploading room level images");
		util.uploadRoomImage(1, false, vendor,roomId,"caption");
		logger.log(LogStatus.INFO, "Validating room leveel images");	
		util.validateRoomImages(vendor);
			
		//Update vendor title and vendor description
		vendorRQ=new VendorRequest();
		logger.log(LogStatus.INFO, "Adding vendor title and description");
		vendorRQ.addVendor(accomodationType,"edit",vendor);
				
		//Publish property 
		   util.publishProperty(vendor);
		   logger.log(LogStatus.INFO, "Publishing vendor "+vendor);
		   util.approveProperty(vendor);
		   logger.log(LogStatus.INFO, "Approving property for vendor "+vendor );
		
	}


	
	
	
	@AfterSuite()
	public void tearDown()
	{
		con.closeConnection();
		
	}
	
	
	
	
}
