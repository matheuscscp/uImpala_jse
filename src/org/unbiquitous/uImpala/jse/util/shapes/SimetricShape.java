package org.unbiquitous.uImpala.jse.util.shapes;

import org.lwjgl.opengl.GL11;
import org.unbiquitous.uImpala.util.Color;
import org.unbiquitous.uImpala.util.math.Point;

public class SimetricShape extends org.unbiquitous.uImpala.engine.asset.SimetricShape {
	private float angleInDegrees;
	
	public SimetricShape(Point center, Color paint, float radius, int sides) {
		super(center, paint, radius, sides);
	}
	
	org.newdawn.slick.Color paint;
	
	public void color(Color color){ 
		super.color(color);
		this.paint = fromColor(color);
	}
	
	org.newdawn.slick.Color fromColor(Color paint) {
		return new org.newdawn.slick.Color(paint.getRed(), paint.getGreen(), paint.getBlue(), paint.getAlpha());
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
}