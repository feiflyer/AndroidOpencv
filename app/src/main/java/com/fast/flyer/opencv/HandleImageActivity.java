package com.fast.flyer.opencv;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class HandleImageActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mGray, mGas;
    private Bitmap mSrcBitmap;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handle_image);

        mGray = findViewById(R.id.gray);
        mGas = findViewById(R.id.gas);


        mGray.setOnClickListener(this);
        mGas.setOnClickListener(this);

        mSrcBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.liuyan);

        mImageView = findViewById(R.id.image);

        mImageView.setImageBitmap(mSrcBitmap);
    }

    @Override
    public void onClick(View view) {
        if (view == mGas) {
            mImageView.setImageBitmap(ImageUtils.gaussianBlur(mSrcBitmap));
        } else if (view == mGray) {
            mImageView.setImageBitmap(ImageUtils.bitmapToGray(mSrcBitmap));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(null != mSrcBitmap){
            mSrcBitmap.recycle();
            mSrcBitmap = null;
        }
    }
}
