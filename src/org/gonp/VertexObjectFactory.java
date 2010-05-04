package org.gonp;

import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class VertexObjectFactory {
	
	public static VertexObject createSquare() {
		FloatBuffer vertexes = NativeBufferFactory.floatBuffer(new float[] { 
				1, -1, 0,
				0, -1, 0,
				0, 0, 0,
				1, 0, 0
		});
		
		ShortBuffer indexes = NativeBufferFactory.shortBuffer(new short[] {
				0,1,2,2,0,3
		});
		
		return new VertexObject(vertexes, indexes);
	}

	public static VertexObject createCircle() {
		int segments = 40;
		short[] indexesValues = new short[segments * 3];
		float[] vertexesValues = new float[(segments+1)*3];
		double segAngle = (2*Math.PI)/segments;
		for (short i = 0; i < segments;  i++) {
			double angle = segAngle*i;
			vertexesValues[i*3] = (float) Math.cos(angle);
			vertexesValues[i*3 + 1] = (float) Math.sin(angle);
			vertexesValues[i*3 + 2] = 0;
		
			indexesValues[i*3] = i;
			indexesValues[i*3 + 1] = (short) ((i + 1) % segments);
			indexesValues[i*3 + 2] = (short) segments;
		}

		vertexesValues[segments * 3] = 0;
		vertexesValues[segments * 3 + 1] = 0;
		vertexesValues[segments * 3 + 2] = 0;
		
		ShortBuffer indexes = NativeBufferFactory.shortBuffer(indexesValues);	
		FloatBuffer vertexes = NativeBufferFactory.floatBuffer(vertexesValues);
		
		return new VertexObject(vertexes, indexes);
	}
}
