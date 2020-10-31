#include<cstdio>
#include<cassert>
#include<cstdlib>

class Stack{
    private: int * data; 
    private: int capacity;
    private: int currentIndex = -1;
    private: int lastIndex;

    public: ~Stack() { delete[] data; }

    public: Stack(int const capacity){
	assert(capacity > 0);
	this->data = new int[capacity]; 
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

    public: int pop(){
        if(!isEmpty()){
	    return this->data[currentIndex--];
	}

	return -1;
    }

    public: int size() { return this->currentIndex + 1; }

};

int main(int argc, char ** argv){
    Stack stack(10);

    int i = 11;
    while(stack.push(i++));

    while(!stack.isEmpty()) printf("DATA : %d. \n", stack.pop());
}
