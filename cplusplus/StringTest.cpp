#include<iostream>
#include<string>

using namespace std;

int main(){
    string prompt = "What is you name ", name, line(40, '-'), hello="Hello ";
    cout << prompt;
    getline(cin, name);
    hello += name;
    cout << line << endl
         << hello << endl;
    cout << " Your name is " << name.length() << " characters long " << endl;
    cout << line << endl;
    return 0;
}
