package org.gonp;

import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Ball {
	private FloatBuffer vertexes;
	
	private ShortBuffer indexes;
	
	private int segNumber = 40;
	
	public Ball() {
		short[] indexesValues = new short[segNumber * 3];
		float[] vertexesValues = new float[(segNumber+1)*3];
		double segAngle = (2*Math.PI)/segNumber;
		for (short i = 0; i < segNumber;  i++) {
			double angle = segAngle*i;
			vertexesValues[i*3] = (float) Math.cos(angle);
			vertexesValues[i*3 + 1] = (float) Math.sin(angle);
			vertexesValues[i*3 + 2] = 0;
		
			indexesValues[i*3] = i;
			indexesValues[i*3 + 1] = (short) ((i + 1) % segNumber);
			indexesValues[i*3 + 2] = (short) segNumber;
		}

		vertexesValues[segNumber * 3] = 0;
		vertexesValues[segNumber * 3 + 1] = 0;
		vertexesValues[segNumber * 3 + 2] = 0;
		
		indexes = NativeBufferFactory.shortBuffer(indexesValues);	
		vertexes = NativeBufferFactory.floatBuffer(vertexesValues);
	}
	
	public void render(GL10 gl) {
		gl.glLoadIdentity();
	    gl.glScalef(.1f, .1f, .1f);
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexes);
	    gl.glDrawElements(GL10.GL_TRIANGLES, indexes.capacity(), GL10.GL_UNSIGNED_SHORT, indexes);
	}
}
