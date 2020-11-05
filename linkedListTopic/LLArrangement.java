package linkedListTopic;

/*
1.You are given a singly linked list L0 -> L1 -> . . . -> Ln-1 -> Ln.
2. You have to write a function that rearranges the nodes in the list so 
that the new formed list is : L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 and so on.
 */

import java.util.*;

public class LLArrangement {

	public static Node LLMid(Node head)
	{
		if(head==null || head.next==null)
		{
			return head;
		}
		
		Node slow = head;
		Node fast = head.next;
		
		while(fast!=null)
		{
			fast = fast.next;
			
			if(fast!=null)
			{
				slow = slow.next;
				fast = fast.next;
			}
		}
		
		Node mid = slow.next;
		
		slow.next = null;
		
		return mid;
	}
	
	public static Node reverseLL(Node head)
	{
		if(head==null || head.next==null)
		{
			return head;
		}
		Node prev = null;
		Node curr = head;
		
		while(curr!=null)
		{

			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
    public static Node rearrange(Node head) 
    {
    	Node mid = LLMid(head);
    	Node midReverse = reverseLL(mid);

    	
    	Node temp1 = head;
    	Node temp2 = midReverse;
    	
    	Node newHead = null;
    	Node newTail = null;
 
    	while(temp1!=null && temp2!=null)
    	{
    		if(newTail==null){
    			newHead = temp1;
    		}
    		else{
    			newTail.next = temp1;
    		}
    		newTail = temp1;
    		temp1 = temp1.next;
			newTail.next = temp2;
    		newTail = temp2;
			temp2 = temp2.next;
    		newTail.next = null;
    	}
    	
    	if(temp1!=null)
    	{
    		newTail.next = temp1;
    		newTail = temp1;
    		temp1 = temp1.next;
    		newTail.next = null;
    	}
    	return newHead;
    }


    static Node head1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int a1 = sc.nextInt();

        Node tail;
        head1 = tail = insert(null, a1);

        for (int i = 1; i < n1; i++) {
            int a = sc.nextInt();
            tail = insert(tail, a);
        }

        head1 = rearrange(head1);
        display(head1);

    }

    // Class declaration for a Node of the Linked List
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    /*
     * Input Parameters: tail: head of the linked list in which a new node is to
     * be inserted. data: the data value of the node which is to be inserted.
     * 
     * Return Value: tail of the linked list/the node that is inserted
     */
    public static Node insert(Node tail, int data) {

        if (tail == null) {
            return new Node(data);
        }

        Node nn = new Node(data);
        tail.next = nn;
        return nn;
    }

    /*
     * Input Parameters: head: head of the linked list in which is to be
     * displayed.
     * 
     * Return Value: null
     */
    public static void display(Node head) {
        for (Node node = head; node != null; node = node.next) {
            System.out.print(node.data + " ");
        }
    }

}