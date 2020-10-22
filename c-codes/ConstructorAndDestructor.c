#include<stdio.h>
__attribute__((constructor)) 
void constructor() 
{

    printf("Called Before main\n");
}

int main(int argc, void **argv){
    printf("Main called\n");
}

__attribute__((destructor))
void destructor() {
    printf("Called After Main\n");
}
