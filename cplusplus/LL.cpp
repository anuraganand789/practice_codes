#include<iostream>
namespace LL {
  class LinkedList{
      struct Node{
        int data;
  	struct Node * next;
  	struct Node * prev;
  
  	Node(struct Node * prev, int data, struct Node * next){ 
  	    this->next = prev;
  	    this->data = data;
  	    this->next = next;
  	}
      };

      int mod;
      int totalNode;
      struct Node * head;
      struct Node * tail;
     
      public: LinkedList(){}
      
      public: void add(int const data){
         addAsLastNode(data); 
      }

      public: int size() const { return totalNode; }

      void addAsLastNode(int const data){
          struct Node * _tail = tail;

	  struct Node * newNode = new Node(_tail, data, NULL);
	  tail = newNode;
	  if(!_tail) {
	     head = newNode;
	  } else{
	      _tail->next = newNode;
	  }

	  ++totalNode;
	  ++mod;
      }

      public: void forEach(void (* consumer)(int)){
          struct Node * _head = head;
	  while(_head){
	      consumer(_head->data);
	      _head = _head->next;
	  }
      }

  
  };
}

int main(){
    LL::LinkedList * linkedList = new LL::LinkedList();

    linkedList->add(12);
    linkedList->add(13);
    linkedList->add(14);
    linkedList->add(15);

    std::cout << "Linked List Size " << linkedList->size() << std::endl;
    linkedList->forEach([](int const data) { std::cout << data << std::endl;});
}

