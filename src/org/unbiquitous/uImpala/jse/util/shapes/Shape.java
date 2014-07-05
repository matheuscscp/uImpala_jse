package org.unbiquitous.uImpala.jse.util.shapes;

import java.awt.Color;
import java.awt.Point;

public class Shape {
	Point center;
	Color awtPaint;
	org.newdawn.slick.Color paint;
	
	public Shape(Point center, Color paint) {
		center(center);
		color(paint);
	}
	
	public Color color(){ return awtPaint;}
	public void color(Color color){ 
		awtPaint = color;
		this.paint = fromColor(color);
	}
	
	org.newdawn.slick.Color fromColor(Color paint) {
		return new org.newdawn.slick.Color(paint.getRed(), paint.getGreen(), paint.getBlue(), paint.getAlpha());
	}
	
	public Point center(){	return (Point) center.clone();	}
	public void center(Point center){	this.center =  (Point) center.clone();	}
}
