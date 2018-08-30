#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring

JNICALL
Java_com_mcc_galleryapp_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_mcc_galleryapp_activity_BaseActivity_getApiBaseUrl(JNIEnv *env, jobject instance) {

    return env->NewStringUTF("http://nationalappsbangladesh.com/mobsvc/");
}
