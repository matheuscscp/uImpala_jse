package org.unbiquitous.uImpala.jse.util.shapes;

import java.awt.Color;

import org.unbiquitous.uImpala.util.math.Point;

public class Circle extends SimetricShape {
	float radius;
	
	public Circle(Point center, Color paint, float radius) {
		super(center, paint, radius, 360);
	}
}
