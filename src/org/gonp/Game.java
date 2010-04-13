package org.gonp;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

public class Game extends Activity {
    private GLSurfaceView gl;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gl = new GLSurfaceView(this);
        gl.setRenderer(new GameRenderer());
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
}