package com.camera.xidg.cameraapp;

import java.io.File;
import java.io.FileOutputStream;

import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.google.android.gms.common.api.GoogleApiClient;

public class CameraACtivity extends AppCompatActivity {

    File g_Photo;

    SurfaceView g_surfaceView;
    Camera g_camera;

    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_camera_activity);

        File pictures = Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        g_Photo = new File(pictures, "myphoto.jpg");
        g_surfaceView = (SurfaceView) findViewById(R.id.surfaceView);

        SurfaceHolder holder = g_surfaceView.getHolder();
        holder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                try {
                    g_camera.setPreviewDisplay(holder);
                    g_camera.startPreview();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format,
                                       int width, int height) {
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
            }
        });

    }


    public void onClickPicture(View view) {
        g_camera.takePicture(null, null, new PictureCallback() {
            @Override
            public void onPictureTaken(byte[] data, Camera camera) {
                try {
                    FileOutputStream fos = new FileOutputStream(g_Photo);
                    fos.write(data);
                    fos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
/*
    @Override
    protected void onResume() {
        super.onResume();
        g_camera = Camera.open();
    }



    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnShowPicture:
                Intent intent = new Intent(this, ShowPictureActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }*/
    }