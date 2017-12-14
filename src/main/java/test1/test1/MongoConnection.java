package test1.test1;

import java.io.IOException;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class MongoConnection {

	 /*MongoClient mongo;
    DBCursor cursor;
   // DBCollection collection; 
	MongoDatabase db;
	MongoCollection<Document> collection ;
	
	public void setMongoConnection() {
		System.out.println("In set mongo connection");
		mongo = new MongoClient(
		new MongoClientURI("mongodb://homestayservice:homestayservice@192.168.17.116:27018/HomestayHost?authMechanism=SCRAM-SHA-1")
		);

		
		db=mongo.getDatabase("HomestayHost");
		collection = db.getCollection("HomeStayDetails");
		// cursor =collection.find();

		 while(cursor.hasNext()) {
		System.out.println(cursor.next());
		}
		
		}
		public Object getMongoDoc(String id) throws IOException
		{
		System.out.println("In get mongo doc function");
		System.out.println("Passed vendor id is " + id);
		cursor = db.getCollection("HomeStayDetails").find(new BasicDBObject("_id", new ObjectId(id)));
		System.out.println("Cursor size is " + cursor.size());
		if (cursor == null) {
		System.out.println("No mongo documents found");
		return null;

		} else {
		if (cursor.hasNext()) {
		System.out.println("Returning mongo doc");
		DBObject o = cursor.next();
		return o;
		}

		}
		return null;

		}
	*/
	
}
