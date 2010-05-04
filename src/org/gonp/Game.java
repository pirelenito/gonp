package org.gonp;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.MotionEvent;

public class Game extends Activity {
    private GLSurfaceView gl;
	private GameRenderer gameRenderer;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gameRenderer = new GameRenderer();

        gl = new GLSurfaceView(this);
		gl.setRenderer(gameRenderer);
        setContentView(gl);
    }
    
    @Override
    protected void onResume() {
    	super.onResume();
    	gl.onResume();
    }
    
    @Override
    protected void onPause() {
    	super.onPause();
    	gl.onPause();
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
    	gameRenderer.onTouchEvent(event);
    	return true;
    }
}