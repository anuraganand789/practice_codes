#include<iostream>

int main(){
    
    unsigned int 
    yards{},
    feet{},
    inches{};

    std::cout 
    << "Enter a distance as yards, feet and inches"
    << "with the three values separated by spaces:"
    << std::endl;

    std::cin >> yards >> feet >> inches;

    unsigned const feetPerYard   {3};
    unsigned const inchesPerFoot {12};

    unsigned totalInches {};
    totalInches = inches + inchesPerFoot * ( yards * feetPerYard + feet);
    std::cout << "The distances corresponds to " << totalInches << " Inches" << std::endl;

    return 0;
}
