#include <jni.h>
#include "jvm_crash_TestClass.h"
#include <stdio.h>

JNIEXPORT void JNICALL
Java_com_kylin_jvm_lab_TestClass_printHello(JNIEnv *env, jobject obj)
{

  int test = 0;
  test = 1/test;

  printf("Hello JNI World\n");
  return;
}
