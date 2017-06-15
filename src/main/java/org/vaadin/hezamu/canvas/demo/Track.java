package org.vaadin.hezamu.canvas.demo;

public class Track{

	int x, y, who;
	Long id;
	
	public Track(long id, int x, int y, int who) {
		this.who= who;
		this.x = x;
		this.y = y;
		this.id = id;
		RestClient.postAnything(x, y);
		}

	public Long getID() {
		return id;
	}

	public void setID(Long id) {
		this.id = id;
	}

	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWho() {
		return who;
	}

	public void setWho(int who) {
		this.who = who;
	}
}
