package org.gonp;

import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

import android.graphics.PointF;

public class VertexObject {
	private final ShortBuffer indexes;
	private final FloatBuffer vertexes;
	
	private PointF position = new PointF();
	private PointF scale = new PointF(1f, 1f);

	public VertexObject(FloatBuffer vertexes, ShortBuffer indexes) {
		this.vertexes = vertexes;
		this.indexes = indexes;
	}
	
	public void render(GL10 gl) {
		gl.glPushMatrix();
		gl.glTranslatef(getPosition().x, getPosition().y, 0);
	    gl.glScalef(getScale().x, getScale().y, 1);
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexes);
	    gl.glDrawElements(GL10.GL_TRIANGLES, indexes.capacity(), GL10.GL_UNSIGNED_SHORT, indexes);
	    gl.glPopMatrix();
	}

	public void setPosition(PointF position) {
		this.position = position;
	}

	public PointF getPosition() {
		return position;
	}

	public void setScale(PointF scale) {
		this.scale = scale;
	}

	public PointF getScale() {
		return scale;
	}
}
