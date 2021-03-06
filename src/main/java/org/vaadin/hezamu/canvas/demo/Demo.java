package org.vaadin.hezamu.canvas.demo;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.servlet.annotation.WebServlet;

import org.vaadin.hezamu.canvas.Canvas.CanvasMouseMoveListener;

import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.MouseEventDetails;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.vaadin.hezamu.canvas.demo.RestClient;
import org.vaadin.hezamu.canvas.Canvas;

@SuppressWarnings("serial")
//@Theme("valo")
//@Widgetset("org.vaadin.hezamu.canvas.demo.DemoWidgetset")
@Push
public class Demo extends UI {
	Moon moon1;
	Bigstar bigstar1;
	Star star1;
	Star1 star11;
	Planet planet1;
	GSONExample myGsona;

	Ship ship1;
		private Canvas canvas;


//	@WebServlet(value = { "/*", "/VAADIN/*" }, asyncSupported = true)
//	@VaadinServletConfiguration(productionMode = false, ui = Demo.class)
	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = Demo.class, widgetset = "org.vaadin.hezamu.canvas.demo.DemoWidgetset")
	public static class Servlet extends VaadinServlet {
	}
	
	public void anime(){
		final UI ui = UI.getCurrent();
		Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> 
		{
				ui.access(() -> {
				try {
				planet1.erase();
//				if (myGsona.Who == 0)
//				{
//					moon1.fly(bigstar1);
//					
//				}
			    moon1.erase();
			    bigstar1.erase();
			    star1.erase();
			    star11.erase();
			    ship1.erase();
			    moon1.draw();
				bigstar1.fly();
				bigstar1.draw();
				star1.fly();
				star1.draw();
				star11.draw();
				star11.fly();
				ship1.draw();
				ship1.fly(bigstar1);
				planet1.draw();
     			planet1.fly();
     			RestClient.getEvents();
				UI.getCurrent().push();
				}
				catch (Exception e){
					e.printStackTrace();
				}
			});
			anime();
		}, 100, 300, TimeUnit.MILLISECONDS);
		
	}
	
	@Override
	protected void init(VaadinRequest request) {
		VerticalLayout content = new VerticalLayout();
		setContent(content);

		content.addComponent(canvas = new Canvas());
	
		
		canvas.setHeight(1000,UNITS_PIXELS);
		canvas.setWidth(1000, UNITS_PIXELS);
		
		canvas.setFillStyle("blue");
	    canvas.fillRect(0, 0, 1000, 1000);
	    myGsona = new GSONExample();
	  
		bigstar1 = new Bigstar(canvas, 360, 360).draw();
		star1 = new Star(canvas, 230, 430).draw();
		star11 = new Star1(canvas, 330, 340).draw();
		ship1 = new Ship(canvas, 300, 150).draw();
		planet1 = new Planet(canvas, 100, 100).draw();
		moon1 = new Moon(canvas, 100, 500).draw();
		anime();
		
	}
	 
}
