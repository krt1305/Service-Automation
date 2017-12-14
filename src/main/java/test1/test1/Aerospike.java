package test1.test1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import com.aerospike.client.AerospikeClient;
import com.aerospike.client.AerospikeException;
import com.aerospike.client.Bin;
import com.aerospike.client.Host;
import com.aerospike.client.Key;
import com.aerospike.client.Record;
import com.aerospike.client.Value;
import com.aerospike.client.policy.ClientPolicy;
import com.aerospike.client.policy.WritePolicy;

public class Aerospike 
{
	
	/* Host host = new Host("127.0.0.1",3000);
	
	 ClientPolicy clientPolicy = new ClientPolicy();
	 WritePolicy writePolicy = new WritePolicy();
	
	 AerospikeClient client = new AerospikeClient(clientPolicy, host);
	 
	 try {
	  //get key
	  Key key = new Key("test", "aero_yatra", "product");
	  
	  //Create Bins for various data types
	  Bin b1 = new Bin("Orgnization", "MATRIX"); //String
	  
	  Bin b2 = new Bin("total-members", 201); //int
	  
	  Bin b3 = new Bin("total-budget", 5850283.00); //flaot
	  
	  List ls = new ArrayList();
	  ls.add("yatra");
	  ls.add("mmt");
	  Bin b4 = new Bin("list", Value.getAsList(ls)); //List
	  
	  Map map = new HashMap();
	  map.put("Hey", "Hello");
	  map.put("Hoo", "Haa");
	  Bin b5 = new Bin("map", Value.getAsMap(map)); //Map
	  
	  Person p = new Person("Rohit", 23, "Cyber Park");
	  Bin b6 = new Bin("pojo", Value.getAsBlob(p)); //Simple POJO for a Person Object
	  
	  
	  //Write the records
	  client.put(writePolicy, key, b1, b2, b3, b4, b5, b6);
	  
	  //Read the records
	  Record record = client.get(null, key);
	  
	  //Print all the record 
	  for(String binKey : record.bins.keySet()){
	   System.out.println(binKey+" <-----> "+record.bins.get(binKey));
	  }
	  
	  //To access the POJO object from records we need to cast the Reference
	  Person person = (Person)record.bins.get("pojo"); //Cast the reference to Person
	  System.out.println("\nAccessing the POJO object");
	  person.display();
	  
	  //Now remove all the record based on the key
	  //client.delete(writePolicy, key);
	  
	  System.out.println("\nAll the operations {Write, Read, Delete} has been performed successfull");
	 } catch (AerospikeException e) {
	  e.printStackTrace();
	 }finally{
	  client.close();
	 }
	 
	    }
	}*/

}
