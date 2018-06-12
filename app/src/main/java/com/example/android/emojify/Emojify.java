package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.FaceDetector;

import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.face.Face;

/**
 * Created by asrma2 on 13/6/18.
 */

public class Emojify {

    private static final String LOG_TAG = Emojify.class.getSimpleName();

    public static void detectFaces(Context context, Bitmap bitmap) {

        FaceDetector faceDetector = new
                FaceDetector.Builder(context).setTrackingEnabled(false)
                .setClassificationType(FaceDetector.ALL_CLASSIFICATIONS)
                .build();
        /*if(!faceDetector.isOperational()){
            new AlertDialog.Builder(v.getContext()).setMessage("Could not set up the face detector!").show();
            return;
        }*/

        Frame frame = new Frame.Builder().setBitmap(bitmap).build();
        SparseArray<Face> faces = faceDetector.detect(frame);

        Log.d(LOG_TAG, "detectFaces: number of faces = " + faces.size());

        // If there are no faces detected, show a Toast message
        if(faces.size() == 0){
            Toast.makeText(context, R.string.no_faces_message, Toast.LENGTH_SHORT).show();
        }

        // Release the detector
        faceDetector.release();

    }

}
