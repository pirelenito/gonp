package org.gonp;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView.Renderer;

public class GameRenderer implements Renderer {
	Player player;
		
	@Override
	public void onDrawFrame(GL10 gl) {
		gl.glClearColor(1, 0, 0, 1);
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		player.render(gl);
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		 gl.glViewport(0, 0, width, height);
	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
	    gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		player = new Player(gl);
	}

}
