package com.camera.xidg.cameraapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.SurfaceView;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.io.File;

public class CameraACtivity extends AppCompatActivity {

    Button g_btnPicture;
    Button g_btnLookPicture;
    SurfaceView g_surfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_activity);

        File pictures = Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

        g_btnPicture = (Button)findViewById(R.id.btnTakePicture);
        g_btnLookPicture = (Button)findViewById(R.id.btnShowPicture);
        g_surfaceView = (SurfaceView)findViewById(R.id.surfaceView);

        g_btnLookPicture.setOnClickListener((View.OnClickListener) this);
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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_camera_activity, menu);
        return true;
    }
}
