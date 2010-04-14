package org.gonp;

import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Player {
	private FloatBuffer vertexes = NativeBufferFactory.floatBuffer(new float[] { 
			1, -1, 0,
			0, -1, 0,
			0, 0, 0,
			0, 0, 0,
			1, -1, 0,
			1, 0, 0
	});
	
	private ShortBuffer indexes = NativeBufferFactory.shortBuffer(new short[] {
			0,1,2,3,4,5
	});

	public void render(GL10 gl) {
	    gl.glColor4f(0f, 0.5f, 0f, 0.5f);
	 
	    gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexes);
	    gl.glDrawElements(GL10.GL_TRIANGLES, indexes.capacity(), GL10.GL_UNSIGNED_SHORT, indexes);
	}
}
