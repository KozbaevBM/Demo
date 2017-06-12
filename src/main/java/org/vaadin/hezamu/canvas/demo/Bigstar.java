package org.vaadin.hezamu.canvas.demo;

import java.util.Random;

import org.vaadin.hezamu.canvas.Canvas;

public class Bigstar 
{
	
Canvas canvas;
boolean right = true, down = true;
int x, y;

public Bigstar(Canvas canvas, int x, int y)
   {
	this.canvas = canvas;
	this.x = x;
	this.y = y;
   }
	public Bigstar draw()
	{
	canvas.beginPath();
	canvas.moveTo(x, y);
	canvas.lineTo(x+80,y-20);
	canvas.lineTo(x+100,y-100);
	canvas.lineTo(x+120,y-20);
	canvas.lineTo(x+200,y);
	canvas.lineTo(x+120,y+20);
	canvas.lineTo(x+100,y+100);
	canvas.lineTo(x+80,y+20);
	canvas.lineTo(x,y);
	canvas.lineTo(x+200,y);
	canvas.moveTo(x+100,y-100);
	canvas.lineTo(x+100,y+100);
	canvas.setFillStyle("yellow");
	canvas.fill();
	canvas.stroke();
	return this;
	}
	public void fly()
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
 	
	}
	public void erase()
	{
		canvas.beginPath();
		canvas.moveTo(x, y);
		canvas.lineTo(x+80,y-20);
		canvas.lineTo(x+100,y-100);
		canvas.lineTo(x+120,y-20);
		canvas.lineTo(x+200,y);
		canvas.lineTo(x+120,y+20);
		canvas.lineTo(x+100,y+100);
		canvas.lineTo(x+80,y+20);
		canvas.lineTo(x,y);
		canvas.lineTo(x+200,y);
		canvas.moveTo(x+100,y-100);
		canvas.lineTo(x+100,y+100);
		canvas.setFillStyle("blue");
		canvas.setStrokeStyle("blue");
		canvas.fill();
		canvas.stroke();

	}
 }


