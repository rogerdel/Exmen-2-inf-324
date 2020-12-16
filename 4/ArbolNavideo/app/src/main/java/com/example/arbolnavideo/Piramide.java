package com.example.arbolnavideo;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Piramide {
    /* Las coordenadas cartesianas (x, y, z) */
    private float vertices[] = new float[]{
            //frente
            -1, -1, 1,//0
            1, -1, 1,//1
            0, 1, 0,//2
            //Atras
            -1,-1,-1,//3
            1,-1,-1,//4
            0,1,0,//5
            //Izqierda
            -1,-1,1,//6
            -1,-1,-1,//7
            0,1,0,//8
            //derecha
            1,-1,1,//9
            1,-1,-1,//10
            0,1,0,//11
            //base
            -1,-1,1,//12
            1,-1,1,//13
            1,-1,-1,//14
            -1,-1,-1//15
    };

    Esfera esfera;



    private short indices[] = new short[]{
            0,1,2,
            3, 4, 5,
            6,7,8,
            9,10,11,
            12,13,14,
            12,14,15
    };
    private FloatBuffer bufVertices;
    private ShortBuffer bufIndices;

    public Piramide() {
        /* Lee los vértices */
        ByteBuffer bufByte = ByteBuffer.allocateDirect(vertices.length * 4);
        bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
        bufVertices = bufByte.asFloatBuffer(); // Convierte de byte a float
        bufVertices.put(vertices);
        bufVertices.rewind(); // puntero al principio del buffer

        /* Lee los indices */
        bufByte = ByteBuffer.allocateDirect(indices.length * 2);
        bufByte.order(ByteOrder.nativeOrder()); // Utiliza el orden de byte nativo
        bufIndices = bufByte.asShortBuffer(); // Convierte de byte a short
        bufIndices.put(indices);
        bufIndices.rewind(); // puntero al principio del buffer
        esfera = new Esfera(0.2f, 15, 15);
    }

    public void draw(GL10 gl, float r, float g, float b) {
        r += (int)(Math.random()*2);
        g +=  (int)(Math.random()*2);
        b += (int)(Math.random()*2);
        r /= 255; g /= 255; b /= 255;

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, bufVertices);
        gl.glColor4f(r,g,b,0);
        gl.glDrawElements(GL10.GL_TRIANGLES, indices.length,
                GL10.GL_UNSIGNED_SHORT, bufIndices);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glPushMatrix();

        r = (float)Math.random()*255;
        g = (float)Math.random()*255;
        b = (float)Math.random()*255;


        gl.glTranslatef(1,-1,1);
        esfera.draw(gl,r,g,b);

        r = (float)Math.random()*255;
        g = (float)Math.random()*255;
        b = (float)Math.random()*255;

        gl.glTranslatef(-2,0,0);
        esfera.draw(gl,r,g,b);
        r = (float)Math.random()*255;
        g = (float)Math.random()*255;
        b = (float)Math.random()*255;


        gl.glTranslatef(0,0,-2);
        esfera.draw(gl,r,g,b);
        r = (float)Math.random()*255;
        g = (float)Math.random()*255;
        b = (float)Math.random()*255;

        gl.glTranslatef(2,0,0);
        esfera.draw(gl,r,g,b);

        gl.glPopMatrix();
    }
}