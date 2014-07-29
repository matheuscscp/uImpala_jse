package org.unbiquitous.uImpala.jse.util.shapes;

import org.lwjgl.opengl.GL11;
import org.unbiquitous.uImpala.util.Color;
import org.unbiquitous.uImpala.util.math.Point;

public class Rectangle extends org.unbiquitous.uImpala.engine.asset.Rectangle {
	
	public Rectangle(Point center, Color paint, float width, float height) {
		super(center, paint, width, height);
	}

	private float angleInDegrees = 0;
	
	public void rotate(float angleInDegrees) {
		this.angleInDegrees = angleInDegrees;
	}
	
	public void render(){
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);
		paint.bind();
		GL11.glLoadIdentity();
		GL11.glTranslatef(center.x, center.y, 0.0f);
		GL11.glRotatef(angleInDegrees, 0.0f, 0.0f, 1.0f);
		GL11.glBegin(GL11.GL_POLYGON);
			GL11.glVertex2d(- width/2, - height/2);
			GL11.glVertex2d(+ width/2, - height/2);
			GL11.glVertex2d(+ width/2, + height/2);
			GL11.glVertex2d(- width/2, + height/2);
		GL11.glEnd();
	}
	
	org.newdawn.slick.Color paint;
	
	public void color(Color color){ 
		super.color(color);
		this.paint = fromColor(color);
	}
	
	org.newdawn.slick.Color fromColor(Color paint) {
		return new org.newdawn.slick.Color(paint.getRed(), paint.getGreen(), paint.getBlue(), paint.getAlpha());
	}
}
