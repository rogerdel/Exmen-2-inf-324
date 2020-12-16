package com.example.arbolnavideo;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Arbol {
    float height = 1.5f;
    float width = 0.3f;
    private float vertices[] = new float[] {
            // Frente
            -width, -height, width,
            width, -height, width,
            width, height, width,
            -width, height, width,
            // Atrás
            -width, height, -width,
            width, height, -width,
            width, -height, -width,
            -width, -height, -width,
            // Izquierda
            -width, -height, -width,
            -width, -height, width,
            -width, height, width,
            -width, height, -width,
            // Derecha
            width, -height, width,
            width, -height, -width,
            width, height, -width,
            width, height, width,
            // Abajo
            -width, -height, -width,
            width, -height, -width,
            width, -height, width,
            -width, -height, width,
            // Arriba
            -width, height, width,
            width, height, width,
            width, height, -width,
            -width, height, -width
    };
    Piramide piramide;
    private short indices[] = new short [] {
            0, 1, 2, 0, 2, 3,
            4, 5, 6, 4, 6, 7,
            8, 9, 10, 8, 10, 11,
            12, 13, 14, 12, 14, 15,
            16, 17, 18, 16, 18, 19,
            20, 21, 22, 20, 22, 23
    };
    private FloatBuffer bufVertices;
    private ShortBuffer bufIndices;


    public Arbol() {
        ByteBuffer bufByte = ByteBuffer.allocateDirect(vertices.length * 4);
        bufByte.order(ByteOrder.nativeOrder());
        bufVertices = bufByte.asFloatBuffer();
        bufVertices.put(vertices);
        bufVertices.rewind();
        bufByte = ByteBuffer.allocateDirect(indices.length * 2);
        bufByte.order(ByteOrder.nativeOrder());
        bufIndices = bufByte.asShortBuffer();
        bufIndices.put(indices);
        bufIndices.rewind();
        piramide = new Piramide();
    }
    public void draw(GL10 gl) {
        gl.glPushMatrix();
        gl.glTranslatef(0,-3,0);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
        gl.glColor4f(97/255f,44/255f,0,0);
        gl.glDrawElements(GL10.GL_TRIANGLES, indices.length, GL10.GL_UNSIGNED_SHORT, bufIndices);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glPopMatrix();
        gl.glPushMatrix();
        gl.glTranslatef(0,4f,0);
        for(int i = 0; i < 4; i++){
            gl.glTranslatef(0,-1.3f,0);
            piramide.draw(gl,0, 168 , 6);
        }
        gl.glPopMatrix();

    }

}
