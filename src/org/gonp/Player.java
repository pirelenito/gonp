package org.gonp;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Player {
	private FloatBuffer vertexBuffer;
	private ShortBuffer indexBuffer;
	private float[] coordinates = { 
			1, -1, 0,
			0, -1, 0,
			0, 0, 0,
			0, 0, 0,
			1, -1, 0,
			1, 0, 0
	};
	private short[] indexes = {0,1,2,3,4,5};

	public Player(GL10 gl) {
		vertexBuffer = BufferFactory.floatBuffer(coordinates);
		indexBuffer = BufferFactory.shortBuffer(indexes);
	}

	public void render(GL10 gl) {
	    // set the color of our element
	    gl.glColor4f(0f, 0.5f, 0f, 0.5f);
	 
	    // define the vertices we want to draw
	    gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
	 
	    // finally draw the vertices
	    gl.glDrawElements(GL10.GL_TRIANGLES, coordinates.length/3, GL10.GL_UNSIGNED_SHORT, indexBuffer);
	}
}
