package org.gonp;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.graphics.PointF;
import android.opengl.GLSurfaceView.Renderer;
import android.view.MotionEvent;

public class GameRenderer implements Renderer {
	private final VertexObject player1 = VertexObjectFactory.createSquare();
	private final VertexObject player2 = VertexObjectFactory.createSquare();
	private final VertexObject ball = VertexObjectFactory.createCircle();
	private int width;
		
	@Override
	public void onDrawFrame(GL10 gl) {
		update();
		render(gl);
	}

	private void render(GL10 gl) {
		gl.glLoadIdentity();
		gl.glTranslatef(-1f, -1f, 0);
		gl.glScalef(2, 2, 1);
		
		gl.glClearColor(1, 0, 0, 1);
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		player1.render(gl);
		player2.render(gl);
		ball.render(gl);
	}

	private void update() {
		
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		this.width = width;
		gl.glViewport(0, 0, width, height);
	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
	    gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
	    player1.setPosition(new PointF(.5f, 1));
	    player1.setScale(new PointF(.2f, .1f));
	    player2.setPosition(new PointF(.5f, .1f));
	    player2.setScale(new PointF(.2f, .1f));
	    ball.setPosition(new PointF(.5f, .5f));
	    ball.setScale(new PointF(.02f, .02f));
	}

	public void onTouchEvent(MotionEvent event) {
		player1.setPosition(new PointF(event.getX()/width, player1.getPosition().y));
	}
}
