#include <jni.h>
#include <stdio.h>
#include "HelloJNI.h"
 
JNIEXPORT void JNICALL Java_com_kylin_jvm_jni_HelloJNI_sayHello(JNIEnv *env, jobject thisObj) {
   printf("Hello World JNI!\n");
   return;
}
