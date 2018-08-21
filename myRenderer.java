package com.example.kuba.application3;

import android.opengl.GLES10;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;


public class myRenderer implements GLSurfaceView.Renderer  {

    private FloatBuffer triangleVB, kolorVB, uklVB, kolorUklVB, JVB,
            kolorJVB, KVB, kolorKVB;

    private void initShapes()
    {
        float uklWsp[]=
                {
                        0.0f, 0.0f, 0.0f,
                        15.0f, 0.0f, 0.0f,

                        0.0f, 0.0f, 0.0f,
                        0.0f, 15.0f, 0.0f,

                        0.0f, 0.0f, 0.0f,
                        0.0f, 0.0f, 15.0f

                };
        float kolorUklWsp[]=
                {
                        1.0f, 0.0f, 0.0f, 1.0f,
                        1.0f, 0.0f, 0.0f, 1.0f,

                        0.0f, 1.0f, 0.0f, 1.0f,
                        0.0f, 1.0f, 0.0f, 1.0f,

                        0.0f, 0.0f, 1.0f, 1.0f,
                        0.0f, 0.0f, 1.0f, 1.0f
                };
        float wspWierz[]=
                {
                        2.0f, 0.0f, 0.0f,
                        0.0f, 2.0f, 0.0f,
                        0.0f, 0.0f, 2.0f
                };
        float kolorWierz[]=
                {
                        1.0f, 0.0f, 0.0f,1.0f,
                        0.0f, 1.0f, 0.0f,1.0f,
                        0.0f, 0.0f, 1.0f,1.0f
                };

        float wspWierzJ[]=
                {
                        8.0f, 1.0f, 0.0f,
                        8.0f, 6.0f, 0.0f,

                        8.0f, 6.0f, 0.0f,
                        11.0f, 6.0f, 0.0f,

                        11.0f, 6.0f, 0.0f,
                        11.0f, 4.0f, 0.0f,

                        11.0f, 4.0f, 0.0f,
                        10.0f, 4.0f, 0.0f,

                        10.0f, 4.0f, 0.0f,
                        10.0f, 5.0f, 0.0f,

                        10.0f, 5.0f, 0.0f,
                        9.0f, 5.0f, 0.0f,

                        9.0f, 5.0f, 0.0f,
                        9.0f, 1.0f, 0.0f,

                        9.0f, 1.0f, 0.0f,
                        8.0f, 1.0f, 0.0f

                };
        float kolorWierzJ[]=
                {
                        1.0f, 0.0f, 0.0f, 1.0f,
                        1.0f, 1.0f, 0.0f, 1.0f,

                        1.0f, 1.0f, 0.0f, 1.0f,
                        0.0f, 1.0f, 0.0f, 1.0f,

                        0.0f, 1.0f, 0.0f, 1.0f,
                        0.0f, 1.0f, 1.0f, 1.0f,

                        0.0f, 1.0f, 1.0f, 1.0f,
                        0.0f, 0.0f, 1.0f, 1.0f,

                        0.0f, 0.0f, 1.0f, 1.0f,
                        0.0f, 1.0f, 1.0f, 1.0f,

                        0.0f, 1.0f, 1.0f, 1.0f,
                        0.0f, 1.0f, 0.0f, 1.0f,

                        0.0f, 1.0f, 0.0f, 1.0f,
                        1.0f, 1.0f, 0.0f, 1.0f,

                        1.0f, 1.0f, 0.0f, 1.0f,
                        1.0f, 0.0f, 0.0f, 1.0f

                };

        float wspWierzK[]=
                {
                        6.0f, 1.0f, 0.0f,
                        6.0f, 6.0f, 0.0f,

                        6.0f, 6.0f, 0.0f,
                        5.0f, 6.0f, 0.0f,

                        5.0f, 6.0f, 0.0f,
                        5.0f, 4.0f, 0.0f,

                        5.0f, 4.0f, 0.0f,
                        3.0f, 6.0f, 0.0f,

                        3.0f, 6.0f, 0.0f,
                        2.0f, 6.0f, 0.0f,

                        2.0f, 6.0f, 0.0f,
                        4.5f, 3.5f, 0.0f,

                        4.5f, 3.5f, 0.0f,
                        2.0f, 1.0f, 0.0f,

                        2.0f, 1.0f, 0.0f,
                        3.0f, 1.0f, 0.0f,

                        3.0f, 1.0f, 0.0f,
                        5.0f, 3.0f, 0.0f,

                        5.0f, 3.0f, 0.0f,
                        5.0f, 1.0f, 0.0f,

                        5.0f, 1.0f, 0.0f,
                        6.0f, 1.0f, 0.0f



                };
        float kolorWierzK[]=
                {
                        1.0f, 0.0f, 0.0f, 1.0f,
                        1.0f, 1.0f, 0.0f, 1.0f,

                        1.0f, 1.0f, 0.0f, 1.0f,
                        0.0f, 1.0f, 0.0f, 1.0f,

                        0.0f, 1.0f, 0.0f, 1.0f,
                        0.0f, 1.0f, 1.0f, 1.0f,

                        0.0f, 1.0f, 1.0f, 1.0f,
                        0.0f, 0.0f, 1.0f, 1.0f,

                        0.0f, 0.0f, 1.0f, 1.0f,
                        0.0f, 1.0f, 1.0f, 1.0f,

                        0.0f, 1.0f, 1.0f, 1.0f,
                        0.0f, 1.0f, 0.0f, 1.0f,

                        0.0f, 1.0f, 0.0f, 1.0f,
                        1.0f, 1.0f, 0.0f, 1.0f,

                        1.0f, 1.0f, 0.0f, 1.0f,
                        1.0f, 0.0f, 0.0f, 1.0f,

                        1.0f, 0.0f, 0.0f, 1.0f,
                        1.0f, 1.0f, 0.0f, 1.0f,

                        1.0f, 1.0f, 0.0f, 1.0f,
                        0.0f, 1.0f, 0.0f, 1.0f,

                        0.0f, 1.0f, 0.0f, 1.0f,
                        0.0f, 1.0f, 1.0f, 1.0f
                };

        ByteBuffer vbb = ByteBuffer.allocateDirect(wspWierz.length*4);
        vbb.order(ByteOrder.nativeOrder());
        triangleVB = vbb.asFloatBuffer();
        triangleVB.put(wspWierz);
        triangleVB.position(0);

        ByteBuffer vbb2 = ByteBuffer.allocateDirect(kolorWierz.length*4);
        vbb2.order(ByteOrder.nativeOrder());
        kolorVB = vbb2.asFloatBuffer();
        kolorVB.put(kolorWierz);
        kolorVB.position(0);

        ByteBuffer vbb3 = ByteBuffer.allocateDirect(uklWsp.length*4);
        vbb3.order(ByteOrder.nativeOrder());
        uklVB = vbb3.asFloatBuffer();
        uklVB.put(uklWsp);
        uklVB.position(0);

        ByteBuffer vbb4 = ByteBuffer.allocateDirect(kolorUklWsp.length*4);
        vbb4.order(ByteOrder.nativeOrder());
        kolorUklVB = vbb4.asFloatBuffer();
        kolorUklVB.put(kolorUklWsp);
        kolorUklVB.position(0);

        ByteBuffer vbb5 = ByteBuffer.allocateDirect(wspWierzJ.length*4);
        vbb5.order(ByteOrder.nativeOrder());
        JVB = vbb5.asFloatBuffer();
        JVB.put(wspWierzJ);
        JVB.position(0);

        ByteBuffer vbb6 = ByteBuffer.allocateDirect(kolorWierzJ.length*4);
        vbb6.order(ByteOrder.nativeOrder());
        kolorJVB = vbb6.asFloatBuffer();
        kolorJVB.put(kolorWierzJ);
        kolorJVB.position(0);

        ByteBuffer vbb7 = ByteBuffer.allocateDirect(wspWierzK.length*4);
        vbb7.order(ByteOrder.nativeOrder());
        KVB = vbb7.asFloatBuffer();
        KVB.put(wspWierzK);
        KVB.position(0);

        ByteBuffer vbb8 = ByteBuffer.allocateDirect(kolorWierzK.length*4);
        vbb8.order(ByteOrder.nativeOrder());
        kolorKVB = vbb8.asFloatBuffer();
        kolorKVB.put(kolorWierzK);
        kolorKVB.position(0);
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {

        GLES10.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        initShapes();

    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        GLES10.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();
        float asp = (float)width/(float)height;
        GLU.gluPerspective(gl, 35.0f, asp, 1.0f, 1000.0f);

        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();
        GLU.gluLookAt(
                gl,
                25.0f, 25.0f, 25.0f,
                0.0f, 0.0f, 0.0f,
                0.0f, 0.0f, 1.0f

        );
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        GLES10.glClear(GLES10.GL_COLOR_BUFFER_BIT | GLES10.GL_DEPTH_BUFFER_BIT);

        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, uklVB);
        gl.glColorPointer(4, GL10.GL_FLOAT, 0, kolorUklVB);
        gl.glDrawArrays(GL10.GL_LINES, 0, 6);

        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, triangleVB);
        gl.glColorPointer(4, GL10.GL_FLOAT, 0, kolorVB);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 3);

        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, JVB);
        gl.glColorPointer(4, GL10.GL_FLOAT, 0,kolorJVB);
        gl.glDrawArrays(GL10.GL_LINES, 0, 16);

        gl.glVertexPointer(3, GL10.GL_FLOAT, 0,KVB);
        gl.glColorPointer(4, GL10.GL_FLOAT, 0,kolorKVB);
        gl.glDrawArrays(GL10.GL_LINES, 0, 22);
    }
}
