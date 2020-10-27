#include<iostream>

namespace LL{
    struct LinkedList {
        int data;
        struct LinkedList *next;
        struct LinkedList *prev;
    };
}

namespace LL{
   class Box {
      public:
         int height;
	 int width;
	 int length;
      
      int getWidth();
      double getVolume(){
          return height * width * length;
      }

      void setHeight(int height);
      void setWidth(int width);
      void setLength(int length);
      ~Box();
      Box();
      Box(int);
   };

}

LL::Box::~Box(){ std::cout << " Destructors called " << std::endl; }
LL::Box::Box(){ std::cout << "Box object created " << std::endl;}
LL::Box::Box(int length) : length(length) { std::cout << " box object created with value of length variable set " << std::endl; }
int LL::Box::getWidth(){ return this->width; }

void LL::Box::setLength(const int length){ this->length = length; }
void LL::Box::setHeight(const int height) { this->height = height; }
void LL::Box::setWidth(const int width) { this->width = width; }

int main(){
    LL::Box * box = new LL::Box(12);
    box->setHeight(12);
    box->setWidth(box->length);
    delete box;
    return 0;
}
