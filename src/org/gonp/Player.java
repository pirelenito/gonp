package org.gonp;

import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Player {
	private FloatBuffer vertexes = NativeBufferFactory.floatBuffer(new float[] { 
			1, -1, 0,
			0, -1, 0,
			0, 0, 0,
			1, 0, 0
	});
	
	private ShortBuffer indexes = NativeBufferFactory.shortBuffer(new short[] {
			0,1,2,2,0,3
	});
	
	private float width = .2f;
	private float height = .1f;
	private float x = -width/2;
	private float y = 1;

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void render(GL10 gl) {
	    gl.glLoadIdentity();
		gl.glColor4f(0f, 0.5f, 0f, 0.5f);
		
		gl.glTranslatef(x, y, 0);
		gl.glScalef(width, height, 0);
	    
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexes);
	    gl.glDrawElements(GL10.GL_TRIANGLES, indexes.capacity(), GL10.GL_UNSIGNED_SHORT, indexes);
	}
}
