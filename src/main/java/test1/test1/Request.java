package test1.test1;


import  io.restassured.builder.RequestSpecBuilder;
import  io.restassured.response.Response;
import  io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class Request {
	
	
	RequestSpecBuilder builder = new RequestSpecBuilder();
    RequestSpecification requestSpec;
    String contentType;
	
    public Request(String contentType) {
    	System.out.println("IN request constructor with content type");
        this.contentType = contentType;
      //  builder.addHeader("Authorization", "BEARER SE1TL2JkNGY2NDIxLTlkNDQtNDYyOC1hOWM3LWU0NWEwZGU3NGVmMTo");
        builder.addHeader("Authorization", "Basic SE1TL2UyZTY4MDI5LTU3MDctNDA1Yi04YWUwLWRhZGI0ZmE4N2U5NTo=");
       // builder.addHeader("Authorization","Basic SE1TL2Y4MjZmNzA1LTVhZmMtNDYwZC1iYjQ4LWY3M2FjYTVkYTdjZTo=");
        builder.setContentType(contentType);
       // config = RestAssured.config().encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false));
      //  builder.setConfig(config);
        requestSpec = builder.build();

    }
    public Request()
    {
    	requestSpec = builder.build();
    }
    public void addHeaders()
    {
//    	/this.contentType = contentType;
        builder.addHeader("X-Api-Key","a");
       // builder.setContentType(contentType);
       // config = RestAssured.config().encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false));
      //  builder.setConfig(config);
        requestSpec = builder.build();

    	
    }
    
	public Response doGet(String urlPath)
	{
		 return given().spec(requestSpec).when().get(urlPath).then().extract().response();
	}
	
	public Response doGet(String urlPath,String header)
	{
		this.contentType = contentType;
        builder.addHeader("X-Api-Key","a");
        requestSpec = builder.build();
		 return given().log().all().spec(requestSpec).contentType(contentType).when().get(urlPath)
	                .then().log().all().extract().response();
	}
	
	 public Response doPost(Object object, String urlPath) {
		 contentType="application/json";
	        return given().log().all().spec(requestSpec).contentType(contentType).body(object).when().post(urlPath)
	                .then().log().all().extract().response();
	    }
	 
	 public Response doPutAdmin(Object object, String urlPath) {
		 contentType="application/json";
		 System.out.println("Content type is "+contentType);
		 System.out.println("Request spec is "+requestSpec);
	        return given().log().all().spec(requestSpec).contentType(contentType).header("Authorization","Basic WVRBR0VOVC80OWMyMTVkNi1jYzIwLTRhZWMtYTU1MS0xMzdiZjNkNjg1ZDE6").contentType(contentType).body(object).when().put(urlPath).
	                then().log().all().extract().response();
	    }
	
	 public Response doGetWithAuth(String urlPath)
	 {

		 System.out.println("URL is "+urlPath);
		 return given().log().all().spec(requestSpec).header("Authorization","Basic SE1TL2UyZTY4MDI5LTU3MDctNDA1Yi04YWUwLWRhZGI0ZmE4N2U5NTo=").when().get(urlPath)
	                .then().log().all().extract().response();
		 
	 }
	 
	 public Response doPost(String urlPath)
	 {
		 System.out.println("URL is "+urlPath);
		 return given().log().all().spec(requestSpec).header("Authorization","Basic SE1TL2UyZTY4MDI5LTU3MDctNDA1Yi04YWUwLWRhZGI0ZmE4N2U5NTo=").when().post(urlPath)
	                .then().log().all().extract().response();
	 }
	 public Response doPut(String urlPath)
	 {
	
		
		return given().spec(requestSpec).when().put(urlPath).then().extract().response();
		 
	 }
	 
	 public Response uploadImage(Object obj,String urlPath) 
	  {
	 
		    // String filePath = ComConst.imageFilePath;
		 System.out.println("Image response is ***********************************");
		  Response response = given().log().all().header("Authorization","Basic SE1TL2UyZTY4MDI5LTU3MDctNDA1Yi04YWUwLWRhZGI0ZmE4N2U5NTo=").multiPart("image", ComLib.downloadImageFile())
		            .multiPart("metaData", obj).when().post(urlPath).then().log().all().extract().response();
		 
	
		    return response;
		  }
	
	 

}
