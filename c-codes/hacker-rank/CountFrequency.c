#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main(int argc, char* argv[]) {
     //char* num = "1v88886l256338ar0ekk";
     //char* num = "a11472o5t6";
     char* num = argv[1];
     int numLen = strlen(num);
     int freq[] = {0,0,0,0,0,0,0,0,0,0};

    {
        int i = 0;
	char c;
	while(i < numLen){
	    c = num[i];
	    if(c >= '0' && c <= '9') { 
	        ++freq[c - '0'];
	        printf("Found %c ", c);
	     }
	    ++i;
	}
        printf("\n");
    }

    for(int i = 0; i < 10; ++i) printf("%d ", freq[i]);
    return 0;
}

