#include<iostream>

using std::cout;
using std::endl;

int  main(){
    int const height {12};

    cout << "The height variable occupies " 
              << sizeof height 
              << " bytes." 
              << endl;

    cout << "Type \"long long\" occupies " << sizeof(long long)
              << " bytes." << endl;

    cout << "The result of the expression height * height/2 "
               << "occupies " << sizeof(height * height/2) 
               << " bytes." 
               << endl;
      
    return 0;
}
