#include<iostream>
struct Consumer{
    virtual void consume(int data)  = 0;
};

class IntConsumer : Consumer {
    
    void consume(int data) override { std::cout << data << std::endl; }
};

int main(){
    IntConsumer * intConsumer ();
}
