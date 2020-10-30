#include<cstdio>
struct Node{
    int data;
    int next;

    Node(int const data, struct Node * next){
        this->data = data;
	this->next = next;
    }

    void print(){
        printf("%d", this->data);
    }
};

struct Node * head = nullptr;

void add(int data){
    struct Node * newNode = new Node(data, nullptr);
    if(!head) {
        head = newNode;
	head->next = head;
	return ;
    }
    struct Node * tail = head->next;
    head->next = newNode;
    newNode->next = tail;
}
 
void traverse() const {
    if(head){
        struct Node * currHead = head;
        do{
	    currHead->print();
	}while(currHead->next != head);
    }
}

void sortedAdd(int const data){
    struct Node * newNode = new Node(data, nullptr);
    if(!head) {
        head = newNode; head->next = head; 
	return;
    }
    struct Node * currHead = head;
    struct Node * iterator = currHead;
    struct Node * prev = currHead;

    while(iterator->next != currHead && iterator->data < data){
	prev = iterator; iterator = iterator->next;
    }
    
    newNode->next = prev->next;
    prev->next = newNode;
}

