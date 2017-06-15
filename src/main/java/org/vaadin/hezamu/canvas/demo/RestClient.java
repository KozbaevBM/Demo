package org.vaadin.hezamu.canvas.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.sun.jersey.api.client.Client; 
import com.sun.jersey.api.client.ClientResponse; 
import com.sun.jersey.api.client.WebResource; 

public class RestClient{ 

	public static void getEvents() { 
		try { 

			Client client = Client.create(); 

			WebResource webResource = client 
					.resource("http://192.168.8.103:9090/springrest/events/"); 

			ClientResponse response = webResource.accept("application/json") 
					.get(ClientResponse.class); 

			if (response.getStatus() != 200 && response.getStatus() != 201) { 
				throw new RuntimeException("Failed : HTTP error code : " 
						+ response.getStatus()); 
			} 
			//GSONExample.fromJson();
			String output = response.getEntity(String.class); 
			System.out.println(output); 

		} catch (Exception e) { 

			e.printStackTrace(); 

		} 
	}


	public static void deleteEmployee()
	{
		try { 

			Client client = Client.create(); 

			WebResource webResource = client 
					.resource("http://192.168.8.103:9090/springrest/events/201"); 

			ClientResponse response = webResource.accept("application/json")
					.delete(ClientResponse.class); 

			if (response.getStatus() != 200 && response.getStatus() != 201) { 
				throw new RuntimeException("Failed : HTTP error code : " 
						+ response.getStatus()); 
			} 

			String output = response.getEntity(String.class); 
			System.out.println(output); 

		} catch (Exception e) { 

			e.printStackTrace(); 

		} 
		//	    final String uri = "http://localhost:9090/springrest/events";
		//	     
		//	    Map<String, String> params = new HashMap<String, String>();
		//	    params.put("id", "201");
		//	     
		//	    RestTemplate restTemplate = new RestTemplate();
		//	    restTemplate.delete ( uri,  params );
	}


	public static void getEventById() {
		//		// TODO Auto-generated method stub
		//		final String uri = "http://localhost:9090/springrest/events";	     
		//	    RestTemplate restTemplate = new RestTemplate();
		//	    String entityUrl = uri + "/" + 201;
		//	    restTemplate.delete(entityUrl);
	}

	public static void postAnything(int x, int y){
		try { 

			Client client = Client.create(); 

			WebResource webResource = client 
					.resource("http://192.168.8.103:9090/springrest/events/"); 

			ClientResponse response = webResource.accept("application/json")
					.type("application/json;charset=utf-8")
					.post(ClientResponse.class,"{\"id\":"+123L+",\"x\":"+x+",\"y\":"+y+",\"who\":"+1+"}");

			if (response.getStatus() != 200 && response.getStatus() != 201) { 
				throw new RuntimeException("Failed : HTTP error code : " 
						+ response.getStatus()); 
			} 

			String output = response.getEntity(String.class); 
			System.out.println(output); 

		} catch (Exception e) { 

			e.printStackTrace(); 

		} 
	}
}
