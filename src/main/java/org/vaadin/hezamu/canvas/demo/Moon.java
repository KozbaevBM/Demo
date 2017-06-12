package org.vaadin.hezamu.canvas.demo;




import org.vaadin.hezamu.canvas.Canvas;


public class Moon {
	Canvas canvas;
	int x, y, M0;
	double r, vx, vy, ax, ay ;
	public Moon(Canvas canvas, int x, int y)
	{
	this.canvas = canvas;
	this.x = x;
	this.y = y;
	r = 500;
	vx = 0.1;
	vy = 1.5;
	ax = 0.0;
    ay = 0.0;
    M0 = 3000;
   
	}
	public Moon draw()
	{
		canvas.beginPath();
		canvas.arc(x ,y ,70,0,2*Math.PI,false);
		canvas.setFillStyle("white");
		canvas.fill();
		canvas.stroke();
		return this;
	}
	public void fly(Bigstar bigstar1)
	{
		 ax = M0 * (360 - x) / Math.pow(r,3);
	     ay = M0 * (360 - y) / Math.pow(r,3);
	     vx += ax;
	     vy += ay;
	     x += vx;
	     y += vy;
		
			}
	
	public void erase()
	{
		canvas.beginPath();
		canvas.arc(x ,y ,75,0,2*Math.PI,false);
		canvas.setStrokeStyle("blue");
		canvas.setFillStyle("blue");
		canvas.fill();
		canvas.stroke();
	}
	
	
}
