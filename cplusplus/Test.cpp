#include<iostream>

int main(){
    int const answer{ 42};
    int const appleCount { 15 };
    int const orangeCount { 5 } ;
    int const totalFruit { appleCount + orangeCount };

    std::cout << "This is cpp" << std::endl;

    std::cout << "The total count is " << totalFruit << std::endl;

    int const shoeCount = 2;
    int const shoesCount(2);

    int const bananaCount(7.5);
    int const coconutCount = 5.3;
    int const papayaCount{3};
    int nonInit;
    int const init{};
    int const initWithZeroExplicit{0};
    unsigned long age {1'00L};

    return 0;
}
