package org.vaadin.hezamu.canvas.demo;
import org.vaadin.hezamu.canvas.Canvas;
public class Faceplanet {
	Canvas canvas;
	public Faceplanet(Canvas canvas)
	{
		this.canvas = canvas;
	}
		 public Faceplanet draw()
		  {	
		   canvas.beginPath();
	       canvas.moveTo(726, 0);
		   canvas.bezierCurveTo(630, 150,630, 500, 726, 580);
		   canvas.setFillStyle("black");
		   canvas.fill();
		   canvas.stroke();
		   return this;	
		  }
		 
	
}
