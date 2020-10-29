import java.util.Optional;
public class LinkedList{
    private class Node {
        private int data;
	private Node next;

	private Node(final int data, final Node next){
	    this.data = data;
	    this.next = next;
	}

	@Override
	public String toString(){ return "" + data; }
    }

    private Node head;

    private void insert(final int data){
        final Node newNode = new Node(data, head);
	head = newNode;
    }

    private void print(){
        Node temp = head;
	while(temp != null) {
	    System.out.println(temp.data);
	    temp = temp.next;
	}
	System.out.println("-----------------");
    }
    
    private void remove(int data){
	Node prev = null;
        Node temp = head;

	while(temp != null){
	    if(temp.data == data){
	        if(prev != null) 
		    prev.next = temp.next;
		else 
		    head = temp.next;

		temp.next = null;
	    }

	    prev = temp;
	    temp = prev.next;
	}

	//data is at the first node
	
    }

    private void deleteAt(final int index){
        if(index > -1 && head != null){
	    int pos = index;

	    Node curr = head;
	    Node prev = null;

	    while(--pos > -1){ prev = curr; curr = prev.next; }

	    if(prev == null) 
	        head      = curr.next;
	    else 
	        prev.next = curr.next;
	    
            curr.next = null;
	}
    }

    private int lengthIterative(){
	int count = 0;
        Node curr = head;
	while(curr != null) { curr = curr.next; ++count; }
	return count;
    }

    private int lengthRecur(Node head){
        return (head != null) ? 1 + lengthRecur(head.next) : 0;
    }

    private Node reverse(final Node head){
	if(head != null){
	    Node curr = head;
	    Node prev = null;
	    Node next = null;

	    while(curr != null){
	        next = curr.next;
		curr.next = prev;

		prev = curr;
		curr = next;
	    }

	    return prev;
	}

	return head;
    }

    private static LinkedList merge(final LinkedList llOne, final LinkedList llTwo){
	final Node headOne = llOne.head;
	final Node headTwo = llTwo.head;
	if(headOne == null && headTwo == null) return null;
	if(headOne != null && headTwo != null){
            Node iterHeadOne = headOne;
	    Node iterHeadTwo = headTwo;
	    Node iterMerged  = null;
	    Node mergedHead  = null;
	    if(iterHeadOne.data < iterHeadTwo.data) {
	        mergedHead = iterHeadOne;
		iterHeadOne = iterHeadOne.next;
	    } else {
	        mergedHead  = iterHeadTwo;
		iterHeadTwo = iterHeadTwo.next;
	    }

            mergedHead.next = null;
	    iterMerged = mergedHead;

	    while(iterHeadOne != null && iterHeadTwo != null){
	        if(iterHeadOne.data < iterHeadTwo.data){
		    iterMerged.next = iterHeadOne;
		    iterHeadOne = iterHeadOne.next;
		} else {
		    iterMerged.next = iterHeadTwo;
		    iterHeadTwo = iterHeadTwo.next;
		}

		iterMerged = iterMerged.next;
		//unlink from parent linked list
		iterMerged.next = null;
	    }

	    //if any of the linked list has nodes then attach them to the iterMerged node
	    iterMerged.next = Optional.of(iterHeadOne).orElse(iterHeadTwo);

            final LinkedList ll = new LinkedList();
	    ll.head = mergedHead;
	    return ll;
	}

        return Optional.of(llOne).orElse(llTwo);
    }

    public static void main(final String ... args){
        final LinkedList obj = new LinkedList();
	obj.insert(8);
	obj.insert(3);
	obj.insert(2);
	obj.insert(0);

	obj.print();

        final LinkedList obj_2 = new LinkedList();
	obj_2.insert(7);
	obj_2.insert(6);
	obj_2.insert(5);
	obj_2.insert(4);
	obj_2.insert(1);

	obj_2.print();

	LinkedList mergedLL = merge(obj, obj_2);
	mergedLL.print();

    }
}

