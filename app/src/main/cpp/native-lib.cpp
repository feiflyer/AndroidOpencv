#include <jni.h>
#include <string>

#include <string>
#include <vector>

#include <android/log.h>
#include <opencv2/imgproc.hpp>

#include "opencv2/opencv.hpp"
#include "opencv2/objdetect.hpp"
#include "opencv2/core.hpp"
#include "opencv2/imgproc.hpp"

#define LOG_TAG "FaceDetection/DetectionBasedTracker"
#define LOGD(...) ((void)__android_log_print(ANDROID_LOG_DEBUG, LOG_TAG, __VA_ARGS__))

using namespace cv;
using namespace std;


CascadeClassifier face_detector;

extern "C"
JNIEXPORT void JNICALL
Java_com_fast_flyer_opencv_FaceDetectActivity_initLoad(JNIEnv *env, jobject instance,
                                                       jstring haarFilePath_) {

    const char *haarFilePath = env->GetStringUTFChars(haarFilePath_, 0);

    face_detector.load(haarFilePath);
    env->ReleaseStringUTFChars(haarFilePath_, haarFilePath);
    LOGD( "Method Description: %s", "loaded haar files..." );

    env->ReleaseStringUTFChars(haarFilePath_, haarFilePath);
}

extern "C"
JNIEXPORT void JNICALL
Java_com_fast_flyer_opencv_FaceDetectActivity_faceDetection(JNIEnv *env, jobject instance,
                                                            jlong frameAddress) {

    int flag = 1000;
    Mat& mRgb = *(Mat*)frameAddress;
    Mat gray;
    cvtColor(mRgb, gray, COLOR_BGR2GRAY);

    vector<Rect> faces;
    //LOGD( "This is a number from JNI: %d", flag*2);
    face_detector.detectMultiScale(gray, faces, 1.1, 1, 0, Size(50, 50), Size(300, 300));
    //LOGD( "This is a number from JNI: %d", flag*3);
    if(faces.empty()) return;
    for (int i = 0; i < faces.size(); i++) {
        rectangle(mRgb, faces[i], Scalar(255, 0, 0), 2, 8, 0);
        LOGD( "Face Detection : %s", "Found Face");
    }


}