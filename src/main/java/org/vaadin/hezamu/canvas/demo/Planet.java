package org.vaadin.hezamu.canvas.demo;
import org.vaadin.hezamu.canvas.Canvas;
public class Planet {
	Canvas canvas;
	int x, y, M0;
	double r, vx, vy, ax, ay ;
	public Planet(Canvas canvas, int x, int y)
	{
		 this.canvas = canvas;
		 this.x = x;
		 this.y = y;
		 r = 277;
		 vx = 0.1;
		 vy = 1.5;
		 ax = 0.0;
	     ay = 0.0;
	     M0 = 5000;
	}
	     public Planet draw()
		  {	
		    canvas.beginPath();
		    canvas.arc(x, y,80,0,2*Math.PI,false);
   	    	canvas.setFillStyle("grey");
   	      //  canvas.setStrokeStyle("black");
		    canvas.fill();
		    canvas.stroke();
		    canvas.beginPath();
		    canvas.moveTo(x-40, y+70);
		    canvas.bezierCurveTo(x-50, y+70,x-50, y-50, x+50, y-60);
		 //   canvas.setStrokeStyle("black");
		   	canvas.stroke();
		    canvas.beginPath();
		    canvas.moveTo(x-50, y-65);
		    canvas.bezierCurveTo(x-450, y-250,x+350, y+350, x+80, y+10);
		  //  canvas.setStrokeStyle("black");
		  	canvas.stroke();
			return this;			
			}
	     public void erase()
			{
	    	    canvas.beginPath();
			    canvas.arc(x, y,200,0,2*Math.PI,false);
//	   	  	    canvas.moveTo(x-40, y+70);
//			    canvas.bezierCurveTo(x-50, y+70,x-50, y-50, x+50, y-60);
//			    canvas.moveTo(x-50, y-65);
//			    canvas.bezierCurveTo(x-450, y-250,x+350, y+350, x+80, y+10);
			    canvas.setFillStyle("blue");
			    canvas.setStrokeStyle("blue");
			    canvas.fill();
			  	canvas.stroke();
			}
	     public void fly()
	 	{
	 		 ax = M0 * (500 - x) / Math.pow(r,3);
	 	     ay = M0 * (500 - y) / Math.pow(r,3);
	 	     vx += ax;
	 	     vy += ay;
	 	     x += vx;
	 	     y += vy;
	 			 			}
}
