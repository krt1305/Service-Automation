package test1.test1;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.node.Node;

public class ElasticSearchConnection {

	
	public void setConnection()
	{
//		Node node = nodeBuilder().clusterName("elasticsearch").client(true).node();
		Map<String, String> settingsMap = new HashMap<>();
		//settingsMap.put("cluster.name", "docker-cluster");
		settingsMap.put("cluster.name", "homestay_static");
		
//		settingsMap.put("port", "8090");
//		settingsMap.put("ip", "192.168.17.118");
		Settings settings = Settings.builder().put("cluster.name", "homestay_static").
	            put("client.transport.sniff", false).put("client.transport.ping_timeout", "30s").build();
		
		
	//	Settings settings = Settings.settingsBuilder().put(settingsMap).build();
		TransportClient client;
				try {
					client = TransportClient.builder().settings(settings).build()
							.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.17.118"), 9300));
					
					if(client.connectedNodes() == null)
					{
						System.out.println("Connected nodes is null");
						
					}
					else
					{
						System.out.println("Nodes are available");
					//	System.out.println("Is node available "+ client.connectedNodes());
					}
					SearchResponse response = client.prepareSearch()
							.setIndices("tghomestay")
							.setTypes("hotels")
							.get();
							System.out.println("response: " +response);
							//.setQuery(QueryBuilders.matchQuery("_id", "00081801")).execute().actionGet();
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
	}
	
	public void query()
	{
//		SearchResponse response = client.prepareSearch().execute().actionGet();
	//	List<SearchHit> searchHits = Arrays.asList(response.getHits().getHits());
	//	List<Person> results = new ArrayList<Person>();
//		searchHits.forEach(
//		  hit -> results.add(JSON.parseObject(hit.getSourceAsString(), Person.class)));

	}
	
	
	
			
}
