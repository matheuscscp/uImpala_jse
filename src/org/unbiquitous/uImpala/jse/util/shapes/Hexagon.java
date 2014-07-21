package org.unbiquitous.uImpala.jse.util.shapes;

import java.awt.Color;
import org.unbiquitous.uImpala.util.math.Point;

public class Hexagon extends SimetricShape {
	float radius;
	
	public Hexagon(Point center, Color paint, float radius) {
		super(center, paint, radius, 6);
		this.radius = radius;
	}
	
}
