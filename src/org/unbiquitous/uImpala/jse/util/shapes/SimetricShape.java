package org.unbiquitous.uImpala.jse.util.shapes;

import java.awt.Color;
import java.awt.Point;

import org.lwjgl.opengl.GL11;

public class SimetricShape extends Shape {
	float radius;
	int sides;
	private float angleInDegrees;
	
	public SimetricShape(Point center, Color paint, float radius, int sides) {
		super(center, paint);
		this.radius = radius;
		this.sides = sides;
	}
	
	public void render(){
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);
		paint.bind();
		GL11.glLoadIdentity();
		GL11.glTranslatef(center.x, center.y, 0.0f);
		GL11.glRotatef(angleInDegrees, 0.0f, 0.0f, 1.0f);
		GL11.glBegin(GL11.GL_POLYGON);
		renderPoints();
		GL11.glEnd();
	}

	private void renderPoints() {
		for (double i = 0; i < 360; i+=((float)360)/sides) {
			plotVertex(center, ((float)radius)/2, i+45);
		}
	}

	private void plotVertex(Point center, double radius, double degrees) {
		double degInRad = Math.toRadians(degrees);
		double x = Math.cos(degInRad) * radius;
		double y = Math.sin(degInRad) * radius;
		GL11.glVertex2d(x,y);
	}
	
	public void rotate(float angleInDegrees) {
		this.angleInDegrees = angleInDegrees;
	}
	
	public float radius(){	return radius;	}
}