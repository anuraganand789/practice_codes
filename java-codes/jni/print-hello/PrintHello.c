#include<stdio.h>
#include "PrintHello.h"

JNIEXPORT void JNICALL 
Java_PrintHello_sayMyName (JNIEnv * env, jclass javaThisObj, jstring javaString) {
    const char * name = (*env)->GetStringUTFChars(env, javaString, 0);
    
    printf("My Name is %s.\n", name);

    (*env)->ReleaseStringUTFChars(env, javaString, name);
}
