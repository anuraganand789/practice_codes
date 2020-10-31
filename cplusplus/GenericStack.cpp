#include<algorithm>
#include<cstdio>
#include<cassert>
#include<cstdlib>

namespace GenericStack{
template<typename T>
class Stack{
    private: T * data; 
    private: int capacity;
    private: int currentIndex = -1;
    private: int lastIndex;

    public: ~Stack() { delete[] data; }

    public: Stack(int const capacity){
	assert(capacity > 0);
	this->data = new T[capacity]; 
        this->capacity = capacity;
	this->lastIndex = capacity - 1;
    }
    
    public: bool isFull(){ return this->currentIndex == this->lastIndex; }
    private: bool hasSpace() { return this-> currentIndex < this->lastIndex; }

    public: bool push(int const data){
        if(hasSpace()){
	    this->data[ ++currentIndex ] = data; 
	    return true;
	}

	return false;
    }

    public: bool isEmpty() { return this->currentIndex < 0; }

    public: T pop(){
        if(!isEmpty()){
	    return this->data[currentIndex--];
	}

	return (T) NULL;
    }

    public: int size() { return this->currentIndex + 1; }
    public: void forEach(void (* consume)(const char)) const {
        int startIndex = 0;
	const int endIndex   = lastIndex + 1;
	while(startIndex < endIndex){
	    consume(this->data[startIndex++]);
	}
    }

};
}
int main(int argc, char ** argv){

    std::string str("Anurag Anand");
    GenericStack::Stack<char> stack(str.length());
    for_each(str.begin(), str.end(), [&](const char ch) { stack.push(ch); });
    stack.forEach([](const char ch) { printf("%c ", ch); });

}
