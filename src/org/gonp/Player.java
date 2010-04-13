package org.gonp;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Player {
	private FloatBuffer vertexBuffer;
	private ShortBuffer indexBuffer;
	private float angle = 0;

	public Player(GL10 gl) {
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(3*3*4);
		byteBuffer.order(ByteOrder.nativeOrder());
		vertexBuffer = byteBuffer.asFloatBuffer();
		vertexBuffer.put(new float[] { 
			-0.5f, -0.5f, 0f, // (x1, y1, z1)
			0.5f, -0.5f, 0f, // (x2, y2, z2)
			0f, 0.5f, 0f // (x3, y3, z3)
		});
		vertexBuffer.position(0);
		
		ByteBuffer booBuffer = ByteBuffer.allocateDirect(3*2);
		booBuffer.order(ByteOrder.nativeOrder());
		indexBuffer = booBuffer.asShortBuffer();
		indexBuffer.put(new short[] {0,1,2});
		indexBuffer.position(0);
	}

	public void render(GL10 gl) {
		gl.glRotatef(angle += 0.001, 0f, 1f, 0f);
		
	    // set the color of our element
	    gl.glColor4f(0f, 0.5f, 0f, 0.5f);
	 
	    // define the vertices we want to draw
	    gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
	 
	    // finally draw the vertices
	    gl.glDrawElements(GL10.GL_TRIANGLES, 3, GL10.GL_UNSIGNED_SHORT, indexBuffer);
	}
}
