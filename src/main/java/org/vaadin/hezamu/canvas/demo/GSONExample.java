package org.vaadin.hezamu.canvas.demo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
 

public class GSONExample {
   
    public static void fromJson()
    {
        String response = "application/json";
        
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Track track = gson.fromJson(response, Track.class);
        int Who = track.getWho();

        
        System.out.println("id " + track.getID() + "X:" + track.getX() +
                "Y:" + track.getY() + "Who:" + track.getWho());
 
    }

	public int Who;
	

		
}