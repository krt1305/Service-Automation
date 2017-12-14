package test1.test1;

import java.io.IOException;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.*;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDB {

	static MongoClient mongo ;
	static MongoDatabase mongoDB;
	//static DB db ; 
	static MongoCollection  collection;
//	static DBCollection collection ;
	static DBCursor cursor;
	static DBObject o;
	public static String mongoDocJsonStr;
	static HomeStayMongoDoc homeStayMongoDoc=new HomeStayMongoDoc();
	static VendorMongo vendorMongo=new VendorMongo();
	
	
	public static void main(String[] args) {

		setMongoConnection();
		//System.out.println("Mongo doc "+getMongoDocJsonStr("59a56d881cd29b0001016b43"));
		
		System.out.println("Before get mongo doc");
		getMongoDocJsonStr("59a56d881cd29b0001016b43");
		System.out.println("After get mongo doc");

	}
	
	public static void setMongoConnection()
	{
		System.out.println("In set mongo DB connection");
		mongo = new MongoClient(
				new MongoClientURI("mongodb://homestayservice:homestayservice@192.168.17.116:27018/HomestayHost?authMechanism=SCRAM-SHA-1")
				);
		System.out.println("After setting mongo client url");
		//db = mongo.getDB("HomestayHost");
				
		mongoDB= mongo.getDatabase("HomestayHost");
				
		//		collection = db.getCollection("HomeStayDetails");
		//		cursor = collection.find();
		//		System.out.println("Cursor size is  "+ cursor.size());
				
				
			/*	while (cursor.hasNext()) {
					System.out.println(cursor.next());
				  }
				*/
		
	}
	
	/*public static Object getMongoDoc(String id)
	{
		System.out.println("Cursor size is " + cursor.size());
		if (cursor == null)
		{
			System.out.println("No mongo documents found");
			return null;

		} 
		else {
		if (cursor.hasNext()) 
		{
			cursor = db.getCollection("HomeStayDetails").find(new BasicDBObject("userName", new ObjectId(id)));
			System.out.println("Returning mongo doc");
			o = cursor.next();
			System.out.println("Mongo doc " + o);
			return o;
		}

		}
		return null;
	}
	*/
	
	
	 public static String getMongoDocJsonStr(String id) {
		 System.out.println("IN get mongo DOc json");
		
		    FindIterable<Document> document = mongoDB.getCollection("HomeStayDetails").find(new BasicDBObject("_id", new ObjectId(id)));
		    // assertTrue(document == null, "No Mongo Document for Vendor " + _id);
		    for (Document doc : document) {
		      ObjectMapper mapper = new ObjectMapper();
		      mongoDocJsonStr = doc.toJson().toString();
		      System.out.println("Mongo document is "+mongoDocJsonStr);
		      try {
		        homeStayMongoDoc = mapper.readValue(mongoDocJsonStr, HomeStayMongoDoc.class);
		        vendorMongo = homeStayMongoDoc.getVendor();
		      } catch (IOException e) {
		        ;
		      }
		   //   roomDetailsMongo = homeStayMongoDoc.getRoomDetailMongo();
		    }
		    return mongoDocJsonStr;
		  }
	

}
