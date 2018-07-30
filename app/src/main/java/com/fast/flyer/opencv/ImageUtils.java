package com.fast.flyer.opencv;

import android.graphics.Bitmap;

import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

public class ImageUtils {

    public static Bitmap bitmapToGray(Bitmap src){
        Mat srcMat = new Mat();
        Mat destMat = new Mat();
        Utils.bitmapToMat(src,srcMat);
        Imgproc.cvtColor(srcMat,destMat, Imgproc.COLOR_BGR2GRAY);
        Utils.matToBitmap(destMat,src);
        srcMat.release();
        destMat.release();
        return src;
    }

    public static Bitmap gaussianBlur(Bitmap src){
        Mat srcMat = new Mat();
        Mat destMat = new Mat();
        Utils.bitmapToMat(src,srcMat);
        // 当Size不为0的适合，表示模糊的由Size计算获得
        Imgproc.GaussianBlur(srcMat,destMat,new Size(0,0),15);
        Utils.matToBitmap(destMat,src);
        srcMat.release();
        destMat.release();
        return src;
    }
}
