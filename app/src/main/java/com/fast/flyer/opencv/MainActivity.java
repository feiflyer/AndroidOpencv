package com.fast.flyer.opencv;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mHhandleImage, mFaceDetect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHhandleImage = findViewById(R.id.handle_image);
        mFaceDetect = findViewById(R.id.face_detect);

        mHhandleImage.setOnClickListener(this);
        mFaceDetect.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == mHhandleImage) {
            startActivity(new Intent(this, HandleImageActivity.class));
        }else if(view == mFaceDetect){
            startActivity(new Intent(this, FaceDetectActivity.class));
        }
    }
}
