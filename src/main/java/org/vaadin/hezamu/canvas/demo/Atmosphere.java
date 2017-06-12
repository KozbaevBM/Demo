package org.vaadin.hezamu.canvas.demo;
import org.vaadin.hezamu.canvas.Canvas;

public class Atmosphere {
	Canvas canvas;
	public Atmosphere(Canvas canvas)
	{
		this.canvas = canvas;
	}
	 public Atmosphere draw()
	  {	
		canvas.beginPath();
	    canvas.moveTo(650, 0);
	    canvas.bezierCurveTo(600, 50,550, 500, 650, 580);
	 	canvas.stroke();
	 	return this;	
	  }
	
}
