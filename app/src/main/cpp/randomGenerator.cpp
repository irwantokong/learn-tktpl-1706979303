//
// Created by ASUS on 12/6/2020.
//

#include <jni.h>
#include <stdlib.h>
#include <time.h>

extern "C" JNIEXPORT jint JNICALL
Java_id_ac_ui_cs_mobileprogramming_irwanto_randomgenerator_RandomGeneratorActivity_generateFromRange(
        JNIEnv *env, jobject thiz, jint min, jint max) {
    srand((unsigned int) time(0));
    int randomNumber = (rand() % (max - min)) + min;
    return randomNumber;
}
