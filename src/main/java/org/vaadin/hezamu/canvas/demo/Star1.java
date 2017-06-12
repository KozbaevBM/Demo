package org.vaadin.hezamu.canvas.demo;
import org.vaadin.hezamu.canvas.Canvas;
public class Star1 
{
	Canvas canvas;
	int x, y, M0;
	double r, vx, vy, ax, ay ;
	public Star1(Canvas canvas, int x, int y)
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
	  public Star1 draw()
	  {	
	    canvas.beginPath();
		canvas.moveTo(x,y);
		canvas.lineTo(x+20,y);
		canvas.lineTo(x+30,y-20);
		canvas.lineTo(x+40,y);
		canvas.lineTo(x+60,y);
		canvas.lineTo(x+40,y+10);
		canvas.lineTo(x+50,y+35);
		canvas.lineTo(x+30,y+20);
		canvas.lineTo(x+10,y+35);
		canvas.lineTo(x+20,y+10);
		canvas.lineTo(x,y);
		canvas.setFillStyle("yellow");
		canvas.fill();
		canvas.stroke();
		return this;
	  }
	  public void erase()
		{
		 canvas.beginPath();
		    canvas.arc(x, y,60,0,2*Math.PI,false);
		    canvas.setFillStyle("blue");
		    canvas.setStrokeStyle("blue");
		    canvas.fill();
		  	canvas.stroke();
		}
		public void fly()
		{
			 ax = M0 * (330 - x) / Math.pow(r,3);
		     ay = M0 * (340 - y) / Math.pow(r,3);
		     vx += ax;
		     vy += ay;
		     x += vx;
		     y += vy;
			}
}
