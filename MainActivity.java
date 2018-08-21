package com.example.kuba.application3;

import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private GLSurfaceView myGLView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myGLView = new GLSurfaceView(this);
        myRenderer renderer = new myRenderer();
        myGLView.setRenderer(renderer);
        setContentView(myGLView);

    }
}
