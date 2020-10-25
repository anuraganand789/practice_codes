#include<iostream>
#include<cctype>

int main(){
    char c;
    long noOfChars = 0;
    long noOfConvertedChars = 0;

    while(std::cin >> c){
        ++noOfChars;
	if(islower(c)) { 
	    ++noOfConvertedChars;
	    c = toupper(c);
	}
	std::cout << c << " ";
    }

    std::cout << "No of Chars " << noOfChars << std::endl;
    std::cout << "No of converted chars " << noOfConvertedChars << std::endl;

    return 0;
}
