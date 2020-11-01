#include "PrintHello.h"
#include<string.h>

JNIEXPORT 
void JNICALL 
Java_PrintHello_f (JNIEnv * env, 
                   jclass jc, 
		   jint intValue, 
		   jstring strValue){
     //allocate jvm string
     const char *str = (*env)->GetStringUTFChars(env, strValue, 0);

     printf("String read from java %s.\n", str);
     printf("length of string is %ld.", strlen(str));

     //release jvm string
     (*env)->ReleaseStringUTFChars(env, strValue, str);
}
