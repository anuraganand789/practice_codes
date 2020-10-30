#include<iostream>
#include<cstdio>
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
      
      public: bool remove(int value){
          struct Node * curr = head;
	  struct Node * prev = nullptr;

	  while(curr && curr->data != value){
	      prev = curr; curr = curr->next;
	  }

	  if(curr){
	      //if prev is nullptr that means , the value is at the head of the list
	      if(!prev) {
	          head = head->next;
	      }else {
	          prev->next = curr->next;
	      }
              curr->next = nullptr;
	      delete curr;
	      --totalNode;
	      ++mod;
              return true;
	  }

	  //if we are here that means data is not there in the linked list
	  return false;
      }

      public: bool removeAt(int const index){
	  if(index < size()) {
              struct Node * curr = head;
	      struct Node * prev = nullptr;
              int nodeCount = 0; 

	      while(nodeCount < index){
	          ++nodeCount;
	          prev = curr;
	          curr = curr->next;
	      }
         
	      if(!prev){ head = head->next; }
	      else { prev->next = curr->next; }

	      curr->next = nullptr;

	      delete curr;

	      --totalNode;
	      ++mod;

	      return true;
	     }

	  //index does not exist
	  return false;
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

    if(linkedList->removeAt(0)) printf("Value at index zero removed\n");
    if(linkedList->removeAt(2)) printf("Value at index two removed \n");
    if(linkedList->removeAt(3)) printf("Value at index three removed \n");

    std::cout << "Linked List Size " << linkedList->size() << std::endl;
    linkedList->forEach([](int const data) { std::cout << data << std::endl;});

}

