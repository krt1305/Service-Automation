package test1.test1;


import static io.restassured.RestAssured.given;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class ImportEndPoint extends DbConnection {
	static Connection conn;
	static Properties properties;
    static Statement stmt;
	 static ResultSet rs1;
	 String DATABASE_URL="jdbc:jtds:sqlserver:/s/192.168.17.10:1433;DatabaseName=TRAVELGURU_QA";
	 String dbUserName="desiya";
	 String dbPassword="@desiya123";
	 String DATABASE_DRIVER ="net.sourceforge.jtds.jdbc.Driver";
	//private String DATABASE_DRIVER="com.mysql.jdbc.Connection";	
	 static String importEndPoint="http://192.168.17.118:8090/homestay/import/";
	 static RequestSpecBuilder builder = new RequestSpecBuilder();
	 static String vendorId;
      static RequestSpecification requestSpec;
	
	public static void main(String args[]) 
	{
	
		 if( conn==null)
			{
				try {
	                Class.forName("net.sourceforge.jtds.jdbc.Driver");
	                conn =   DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.17.10:1433;DatabaseName=TRAVELGURU_QA", "desiya","@desiya123");
	                
	                System.out.println("database connection established successfully");
	              //  System.out.println("Network timeout is "+ conn.getNetworkTimeout());
	                System.out.println("Is read only "+ conn.isReadOnly());
	                System.out.println("Auto commit "+ conn.getAutoCommit());
	            } catch (ClassNotFoundException | SQLException e) {
	                e.printStackTrace();
	            }
				
			}
		    
		    
			 String nonHomestayProperties="select distinct top 5 vendor_id , property_type FROM DS_REGISTERED_VENDOR a left join DS_MANGLED_CITY_NAMES b on a.City=b.Right_City_Name where a.HotelSearchKey is not null and a.HotelSearchKey != '' and a.PROPERTY_TYPE!='homestay' and a.active in ('Y','T') and a.City in ('automation',b.Right_City_Name) and b.AUTO_SUGGEST_ENABLE in ('Y')";
		//	 con.getDBResultSet(nonHomestayProperties);
			 
			 // con.setConn();
			 try {
				stmt=conn.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 try {
				rs1=stmt.executeQuery(nonHomestayProperties);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// System.out.println(rs1.i);
			 List <String> hotelVendorIds=new ArrayList();
			 try {
				while(rs1.next())
				 {
					 System.out.println("Iteratnig resultset ");
					 System.out.println(rs1.getString(1));
					 hotelVendorIds.add(rs1.getString(1));
					// System.out.println("In while");
				 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("vendor id is "+hotelVendorIds.get(0));
			vendorId=hotelVendorIds.get(0);
			 String importdetail=importEndPoint+vendorId;
			System.out.println("IMport detail is "+  importdetail);
				// Add headers
				builder.addHeader("X-Api-Key", "abc");
				 requestSpec = builder.build();
				Response resp= given().log().all().spec(requestSpec).when().put(importdetail).then().log().all().extract().response();
				int statusCode=resp.getStatusCode();
				System.out.println("Status code is "+statusCode);
				if(statusCode==500)
				{
					System.out.println("PASS");
				}
				else
				{
					System.out.println("Expected 500");
				}
				
				
				
				//Now read elastic search and verify vendor was not imported
				//Pending
								
			 System.out.println("Verifying for INACTIVE VENDOR ID********************************************************");
				//verify inactive vendors
				String inactiveProperties="select distinct top 5 vendor_id FROM DS_REGISTERED_VENDOR a left join DS_MANGLED_CITY_NAMES b on a.City=b.Right_City_Name where a.HotelSearchKey is not null and a.HotelSearchKey != '' and a.PROPERTY_TYPE='homestay' and a.active in ('U') and a.City in ('automation',b.Right_City_Name) and b.AUTO_SUGGEST_ENABLE in ('Y')";
				Statement stmt1 = null;
				try {
					stmt1 = conn.createStatement();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				ResultSet rs2 = null;
				try {
					rs2 = stmt1.executeQuery(inactiveProperties);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				List <String> inactiveVendors=new ArrayList();
				 try {
					 	while(rs2.next())
					 {
						 System.out.println("Iteratnig resultset ");
						 System.out.println(rs2.getString(1));
						 inactiveVendors.add(rs2.getString(1));
						
					 }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
				builder.addHeader("X-Api-Key", "abc");
				requestSpec = builder.build();
				importdetail=importEndPoint+inactiveVendors.get(0);
				resp= given().log().all().spec(requestSpec).when().put(importdetail).then().log().all().extract().response();
				statusCode=resp.getStatusCode();
				System.out.println("Statuc code "+statusCode);
				//verify in Elastic search
				//Pending
				
				System.out.println("CHECKING DELETED VENDORS****************************************************************");
				
				String deletedVendor="select distinct top 5 vendor_id FROM DS_REGISTERED_VENDOR a left join DS_MANGLED_CITY_NAMES b on a.City=b.Right_City_Name where a.HotelSearchKey is not null and a.HotelSearchKey != '' and a.PROPERTY_TYPE='homestay' and a.active in ('Y') and a.deleted='Y' and a.City in ('automation',b.Right_City_Name) and b.AUTO_SUGGEST_ENABLE in ('Y')";
				Statement stmt2 = null;
				try {
					stmt2 = conn.createStatement();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ResultSet rs3 = null;
				try {
					rs3 = stmt2.executeQuery(deletedVendor);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				List <String> deletedVendors=new ArrayList();
				 try {
					 	while(rs3.next())
					 {
						 System.out.println("Iteratnig resultset ");
						 System.out.println(rs3.getString(1));
						 deletedVendors.add(rs3.getString(1));
						
					 }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
				builder.addHeader("X-Api-Key", "abc");
				requestSpec = builder.build();
				importdetail=importEndPoint+deletedVendors.get(0);
				resp= given().log().all().spec(requestSpec).when().put(importdetail).then().log().all().extract().response();
				statusCode=resp.getStatusCode();
				System.out.println("Statuc code "+statusCode);
		
				
				//FAIL
				//CHECK FOR CITIES WITHOUT AUTOSUGGEST
				System.out.println("Cities without AUTO SUGGEST*****************************************************************************************");
				
				String noAutoSuggestCity="select distinct top 5 vendor_id FROM DS_REGISTERED_VENDOR a left join DS_MANGLED_CITY_NAMES b on a.City=b.Right_City_Name where a.HotelSearchKey is not null and a.HotelSearchKey != '' and a.PROPERTY_TYPE='homestay' and a.active in ('Y')  and a.City in ('automation',b.Right_City_Name) and b.AUTO_SUGGEST_ENABLE in ('N')";
				
				Statement stmt3 = null;
				try {
					stmt3 = conn.createStatement();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ResultSet rs4 = null;
				try {
					rs4 = stmt3.executeQuery(deletedVendor);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				List <String> noAutoSuggestCityList=new ArrayList();
				 try {
					 	while(rs4.next())
					 {
						 System.out.println("Iteratnig resultset ");
						 System.out.println(rs4.getString(1));
						 noAutoSuggestCityList.add(rs4.getString(1));
						
					 }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
				builder.addHeader("X-Api-Key", "abc");
				requestSpec = builder.build();
				importdetail=importEndPoint+noAutoSuggestCityList.get(0);
				resp= given().log().all().spec(requestSpec).when().put(importdetail).then().log().all().extract().response();
				statusCode=resp.getStatusCode();
				System.out.println("Statuc code "+statusCode);
				
				//CHECK FOR AUTOMATION CITY
				
				System.out.println("CHecking for automation city**********************************************************");
                String automationCity="select distinct top 5 vendor_id FROM DS_REGISTERED_VENDOR a left join DS_MANGLED_CITY_NAMES b on a.City=b.Right_City_Name where a.HotelSearchKey is not null and a.HotelSearchKey != '' and a.PROPERTY_TYPE='homestay' and a.active in ('Y')  and a.City in ('automation') and b.AUTO_SUGGEST_ENABLE in ('Y')";
				
				try {
					Statement stmt4=conn.createStatement();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ResultSet rs5 = null;
				try {
					rs5 = stmt3.executeQuery(deletedVendor);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				List <String> automationCityList=new ArrayList();
				 try {
					 	while(rs5.next())
					 {
						 System.out.println("Iteratnig resultset ");
						 System.out.println(rs5.getString(1));
						 automationCityList.add(rs5.getString(1));
						
					 }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
				builder.addHeader("X-Api-Key", "abc");
				requestSpec = builder.build();
				importdetail=importEndPoint+automationCityList.get(0);
				resp= given().log().all().spec(requestSpec).when().put(importdetail).then().log().all().extract().response();
				statusCode=resp.getStatusCode();
				System.out.println("Status code "+statusCode);
				
				//verify unlisted property
				System.out.println("Verify for unlisted property**********************************************");
				String unlistedProperty="select distinct top 5 vendor_id FROM DS_REGISTERED_VENDOR a left join DS_MANGLED_CITY_NAMES b on a.City=b.Right_City_Name where a.HotelSearchKey is not null and a.HotelSearchKey != '' and a.PROPERTY_TYPE='homestay' and a.active in ('Y','T') and a.City in ('automation',b.Right_City_Name) and a.stop_Sell='Y' and b.AUTO_SUGGEST_ENABLE in ('Y')";
				
				
				Statement stmt5 = null;
				try {
					stmt5 = conn.createStatement();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ResultSet rs6 = null;
				try {
					rs6 = stmt5.executeQuery(unlistedProperty);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				List <String> unlistedVendorList=new ArrayList();
				 try {
					 	while(rs6.next())
					 {
						 System.out.println("Iteratnig resultset ");
						 System.out.println(rs6.getString(1));
						 unlistedVendorList.add(rs6.getString(1));
						
					 }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				 System.out.println("UNlisted vendor size is "+unlistedVendorList.size());
			
				builder.addHeader("X-Api-Key", "abc");
				requestSpec = builder.build();
				System.out.println("Unlisted vendor is "+unlistedVendorList.get(0));
				importdetail=importEndPoint+unlistedVendorList.get(0);
				resp= given().log().all().spec(requestSpec).when().put(importdetail).then().log().all().extract().response();
				statusCode=resp.getStatusCode();
				System.out.println("Status code "+statusCode);
				
				
		
			//verify vendor without images
			//	get list of all vendor ids which are live .Then hit B2C image endpoint  
				//select distinct vendor_id FROM DS_REGISTERED_VENDOR a left join DS_MANGLED_CITY_NAMES b on a.City=b.Right_City_Name where a.HotelSearchKey is not null and a.HotelSearchKey != '' and a.PROPERTY_TYPE='homestay' and a.active in ('Y','T') and a.City in ('automation',b.Right_City_Name) and b.AUTO_SUGGEST_ENABLE in ('Y')
				String vendorListQuery="select distinct vendor_id FROM DS_REGISTERED_VENDOR a left join DS_MANGLED_CITY_NAMES b on a.City=b.Right_City_Name where a.HotelSearchKey is not null and a.HotelSearchKey != '' and a.PROPERTY_TYPE='homestay' and a.active in ('Y','T') and a.City in ('automation',b.Right_City_Name) and b.AUTO_SUGGEST_ENABLE in ('Y')";
				Statement stmt10 = null;
				try {
					stmt10=conn.createStatement();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ResultSet rs10 = null;
				try {
					rs10 = stmt10.executeQuery(vendorListQuery);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				 try {
					 	while(rs10.next())
					 {
						 System.out.println("Iteratnig resultset ");
						 System.out.println(rs10.getString(1));
						 String vendor=rs10.getString(1);
						 //{{hms}}/homestay-services/v1/B2C/images/592fc706e4b06345a472e4e7?product=hotel
						 Endpoints endpoint=new Endpoints();
						 String b2cFinalEndpoint=endpoint.hmsBaseURL+endpoint.b2cImageEndPoint+vendor+"?product=hotel";
						 Request rs=new Request();
						 rs.doGet(b2cFinalEndpoint);
						 
					 }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						
		
			
			
			
			//add new vendor and verify
			
			
			//add new vendor ,delete and verify
			
			
		}
	
	
/*	public List<Map<String, Object>> getAllDocs()
  {
 
        int scrollSize = 1000;
        List<Map<String,Object>> esData = new ArrayList<Map<String,Object>>();
        SearchResponse response = null;
        int i = 0;
        while( response == null || response.getHits().hits().length != 0){
            response = client.prepareSearch(indexName) 
                    .setTypes(typeName)
                       .setQuery(QueryBuilders.matchAllQuery())
                       .setSize(scrollSize)
                       .setFrom(i * scrollSize)
                    .execute()
                    .actionGet();
            for(SearchHit hit : response.getHits()){
                esData.add(hit.getSource());
            }
            i++;
        }
        return esData;
}

	*/
	
	
	}
	 


	
