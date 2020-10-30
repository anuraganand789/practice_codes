#include<iostream>
#include<cstdio>
#include<cassert>

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

	void print() const {
	    printf("%d ", this->data);
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
          struct Node * lastNode = tail;

	  struct Node * newNode = new Node(lastNode, data, NULL);
	  tail = newNode;
	  if(!lastNode) {
	     head = newNode;
	  } else{
	      lastNode->next = newNode;
	  }

	  ++totalNode;
	  ++mod;
      }

      public: void forEach(void (* consume)(int)){
          struct Node * _head = head;
	  while(_head){
	      consume(_head->data);
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

      public: void print(){
          struct Node * curr = head;
	  while(curr){
	      printf("%d", curr->data); printf(" -> "); 
	      curr = curr->next;
	  }
	  printf("NULL.\n");
      }

      public: void reverse(){
          struct Node * curr = head;
	  struct Node * prev = nullptr;
	  struct Node * next = nullptr;
          
	  while(curr){
	      next = curr->next;
	      //link to node behind you
	      curr->next = prev;
	      prev = curr;
	      //move the next node
	      curr = next;
	      mod++;
	  }

	  //reset the tail
	  tail = head;
	  //reset the head
	  head = prev;
      }

      public: void rotate(const int rotation){
	  assert(rotation > -1);
          struct Node * firstNode = head;	  
	  struct Node * lastNode  = tail;
          struct Node * isolatedNode = nullptr;
	  int noOfRotation = rotation;

	  while(noOfRotation-- > 0){
	     isolatedNode = firstNode; 
	     firstNode    = firstNode->next;
             isolatedNode->next = nullptr;
	     lastNode->next = isolatedNode; 
	     lastNode = isolatedNode;
	  }
          
	  head = firstNode;
	  tail = lastNode;
      }
  
  };

int main(){
    LinkedList * linkedList = new LinkedList();

    linkedList->add(12);
    linkedList->add(13);
    linkedList->add(14);
    linkedList->add(15);

    std::cout << "Linked List Size " << linkedList->size() << std::endl;
    auto sizeOfList = linkedList->size();
    linkedList->print();
//    linkedList->forEach([](int const data) { std::cout << data << std::endl;});
    linkedList->reverse();
    assert( sizeOfList == linkedList->size());
    //printf("------------------------------------\n");
    linkedList->print();
    linkedList->rotate(1);
    linkedList->print();
 //   linkedList->forEach([](int const data) { std::cout << data << std::endl;});

    //if(linkedList->removeAt(0)) printf("Value at index zero removed\n");
    //if(linkedList->removeAt(2)) printf("Value at index two removed \n");
    //if(linkedList->removeAt(3)) printf("Value at index three removed \n");

    //std::cout << "Linked List Size " << linkedList->size() << std::endl;
    //linkedList->forEach([](int const data) { std::cout << data << std::endl;});

}

