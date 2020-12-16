package com.example.arbolnavideo;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;
import android.opengl.GLSurfaceView.Renderer;
import android.view.MotionEvent;
public class Renderiza extends GLSurfaceView implements Renderer {


    private int alto;
    private int ancho;
    private float rotX;
    Arbol arbol;
    private float antX;
    Context contexto;

    public Renderiza(Context contexto) {
        super(contexto);
        this.contexto = contexto;
        this.setRenderer(this);
        this.requestFocus();
        this.setFocusableInTouchMode(true);
        this.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
    }
    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig arg1) {
        arbol = new Arbol();
        gl.glEnable(GL10.GL_DEPTH_TEST);
        gl.glClearColor(27/255f, 45/255f, 92/255f, 1);
    }
    @Override
    public void onDrawFrame(GL10 gl) {

        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();

        GLU.gluLookAt(gl, 0, 0, 1, 0, 0, 0, 0, 1, 0);
        gl.glTranslatef(0, 1, -8);
        gl.glRotatef(rotX, 0.0f, 1.0f, 0.0f);


        arbol.draw(gl);
        gl.glFlush();
    }
    @Override
    public void onSurfaceChanged(GL10 gl, int w, int h) {
        ancho = w;
        alto = h;
        gl.glViewport(0, 0, w, h);
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();
        GLU.gluPerspective(gl, 60, ancho / (float)alto, 1f, 100f);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        float x = e.getX();
        switch (e.getAction()) {
            case MotionEvent.ACTION_MOVE:
                float dx = x - antX;
                rotX = rotX + dx * 0.5625f;
                requestRender();
        }
        antX = x;
        return true;
    }
}
