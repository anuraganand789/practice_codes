#include<iostream>

using namespace std;

void print1();
void print100();
int main(){
    cout << " Hey there " << endl;
    print1();
    print100();

    cout << "functions called " << endl;
    return EXIT_SUCCESS;
}

void print1(){ cout << 1 << endl; } 
void print100(){ cout << 100 << endl; } 
