/*package com.example.brintaudientes;

import android.opengl.GLES20;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class VolTriangle {

    private FloatBuffer vertexBuffer;

    private final String vertexShaderCode = "attribute vec4 vPosition;" +
            "void main() { " + "gl_Position = vPosition;" + "}";
    private final String fragmentShaderCode =
            "precision mediump float;" +
                    "uniform vec4 vColor;" + "void main() {" + "}";
    private FloatBuffer getVertexBuffer;

    static final int CORDS_PER_VERTEX = 3;

    static float trianglesCoords[] = {
            0.0f, 0.622008459f, 0.0f,
            -0.5f, 0.311004243f, 0.0f,
            -0.5f, 0.311004243f, 0.0f
    };

    float color[] = {0.63671875f, 0.76953125f, 0.22265625f, 1.0f};

    public VolTriangle() {
        ByteBuffer bb = ByteBuffer.allocateDirect(triangleCoords.length*4);
        bb.order(ByteOrder.nativeOrder());
        vertexBuffer = bb.asFloatBuffer();
        vertexBuffer.position(0);
    }

    public static int loadShaoder (int type, String shaderCode) {

        int shader = GLES20.glCreateShader(type);
         GLES20.glShaderSource(shader, shaderCode);
         GLES20.glCompileShader(shader);
         return shader;
    }

    public class VolTriangle() {


    }
}*/
