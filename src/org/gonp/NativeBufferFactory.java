package org.gonp;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/**
 * Factory of {@link Buffer}s on {@link ByteOrder#nativeOrder()}.
 */
public class NativeBufferFactory {
	public static FloatBuffer floatBuffer(float[] array) {
		return (FloatBuffer) byteBuffer(array.length*Float.SIZE/8).asFloatBuffer()
			.put(array)
			.position(0);
	}
	
	public static ShortBuffer shortBuffer(short[] array) {
		return (ShortBuffer) byteBuffer(array.length*Short.SIZE/8).asShortBuffer()
			.put(array)
			.position(0);
	}

	private static ByteBuffer byteBuffer(int length) {
		ByteBuffer buffer = ByteBuffer.allocateDirect(length);
		buffer.order(ByteOrder.nativeOrder());
		return buffer;
	}
}
