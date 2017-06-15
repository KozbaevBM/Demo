package org.vaadin.hezamu.canvas.demo;
import org.vaadin.hezamu.canvas.Canvas;
public class Ship {
	Canvas canvas;
	int x, y;
	boolean right = true, down = true;
	
	public Ship(Canvas canvas, int x, int y)
	{
	 this.canvas = canvas;
	this.x = x;
	this.y = y;
	}
	 public Ship draw()
	  {	
		canvas.beginPath();
		canvas.moveTo(x,y);
		canvas.lineTo(x+50,y-5);
		canvas.lineTo(x+200,y-55);
		canvas.lineTo(x+185,y-90);
		canvas.lineTo(x+175,y-100);
		canvas.lineTo(x+150,y-93);
		canvas.lineTo(x+175,y-100);
		canvas.lineTo(x+175,y-130);
		canvas.lineTo(x+150,y-120);
		canvas.lineTo(x+150,y-93);
		canvas.lineTo(x+150,y-105);
		canvas.lineTo(x+100,y-90);
		canvas.lineTo(x+95,y-70);
		canvas.lineTo(x+40,y-50);
		canvas.lineTo(x,y);
		canvas.setFillStyle("green");
		canvas.fill();
		canvas.stroke();
		canvas.beginPath();
		canvas.moveTo(x+95,y-70);
		canvas.lineTo(x+70,y-120);
		canvas.lineTo(x+50,y-114);
		canvas.lineTo(x+45,y-53);		
		canvas.moveTo(x+60,y-10);
		canvas.lineTo(x+110,y+35);
		canvas.lineTo(x+125,y+30);
		canvas.lineTo(x+110,y-25);
		canvas.setFillStyle("white");
     	canvas.setStrokeStyle("black");
     	canvas.fill();
		canvas.stroke();
		return this;
	  }
	 public void erase()
		{
		 canvas.beginPath();
		    canvas.arc(x, y,250,0,2*Math.PI,false);
		    canvas.setFillStyle("blue");
		    canvas.setStrokeStyle("blue");
		    canvas.fill();
		  	canvas.stroke();
		}
	  public void fly(Bigstar bigstar1)
	 	{
	 		if (down)
	 		{
	 			y+=2;
	 			if(y>=700) down=false;
	 		}
	 		else
	 		{
	 			y-=2;
	 			if(y<=50) down=true;
	 		}
	 		if (right)
	 		{
	 			x+=5;
	 			if(x>=700) right=false;
	 		}
	 		else
	 		{
	 			x-=5;
	 			if(x<=0) right=true;
	 		}
	 		if((Math.abs((this.x+125)-(bigstar1.x+100))<=225) && (Math.abs(this.y-bigstar1.y)<=100))
	 		{
	 			System.out.println("collision");
	 			RestClient.postAnything( 0 , 0 );
	 			this.right=!right;
	 			this.down=!down;
	 		}
	 	}
}
