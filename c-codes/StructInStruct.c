#include<stdlib.h>
#include<stdnoreturn.h>
#include<stdio.h>
struct AStruct;
struct AStruct { int clear; };
_Atomic const int age = 10;

noreturn void stopNow(int const exitCode){
    exit(exitCode);
}
int main(int argc, char ** argv){
    struct AStruct;
    struct AStruct { int clear; };

    struct AStruct a = { 10 };
    int * p = (int *) &a;
    printf("%d\n", *p);
    puts("going to call noreturn function");
    stopNow(1);
    puts("this line will never get called");
}
