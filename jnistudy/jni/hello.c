#include <stdlib.h>
#include <stdio.h>
#include <jni.h>

//jstring
//Java_com_example_hellojni_HelloJni_stringFromJNI( JNIEnv* env,
//                                                  jobject thiz )
//JNIEnv* env 是结构体JNINativeInterface 的二级指针
// JNIEnv 是结构体JNINativeInterface 的一级指针
// JNINativeInterface结构体中定义了大量的函数指针 这些函数指针在jni开发中很常用
// (*env)->
//jobject  调用本地函数的java对象 在这个例子中 就是MainActivity的实例
//c本地函数命名规则  Java_包名_类名_本地方法名
//jstring     (*NewStringUTF)(JNIEnv*, const char*);
jstring Java_cn_yjjc_com_jnistudy_MainActivity_helloFromJNI(JNIEnv* env,jobject thiz){
	char* cstr = "hello from c!";
	return (*env)->NewStringUTF(env,cstr);
}
