#include <jni.h>
#include <string>

extern "C" jstring
Java_com_yaman_secure_1app_NativeLib_baseUrl(
        JNIEnv* env,
        jobject /* this */) {
    std::string value = "http:///videocrypt/test.class";
    return env->NewStringUTF(value.c_str());
}


extern "C" jstring
Java_com_yaman_secure_1app_NativeLib_databaseKey(
        JNIEnv* env,
        jobject /* this */) {
    std::string value = "asdkjlasdlksakldjsakljdksajdksadkasjdkjsadkj";
    return env->NewStringUTF(value.c_str());
}

