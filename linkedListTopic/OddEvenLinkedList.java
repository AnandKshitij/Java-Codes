package linkedListTopic;


import java.util.*;

/*
You are given a singly linked list N nodes.
You have to write a function that groups nodes in the list such that all odd nodes appear 
at the beginning of the list. After that all even nodes appear.

Sample 

Sample Input
7
2 1 3 5 6 4 7
position(this is just for showing odd and even positions)(not part of input)
1 2 3 4 5 6 7
Sample Output
2 3 6 7 1 5 4
 */

public class OddEvenLinkedList {
    public static Node oddEvenList(Node head) {
    	if(head==null){
    		return null;
    	}
    	
    	Node oddHead = null;
    	Node evenHead = null;
    	Node oddTail = null;
    	Node evenTail = null;
    	
    	boolean check = false;
    	//false means odd
    	//true means even
    	
    	for(Node temp=head ; temp!=null ; temp=temp.next)
    	{
    		if(!check)
    		{
    			if(oddTail==null)
    			{
    				oddHead = temp;
    				oddTail = temp;
    			}
    			else
    			{
    				oddTail.next = temp;
    				oddTail = temp;
    			}
    			
    		}
    		else
    		{
    			if(evenTail==null)
    			{
    				evenTail = temp;
    				evenHead = temp;
    			}
    			else
    			{
    				evenTail.next = temp;
    				evenTail = temp;
    			}
    		}
    		
    		check = !check;
    	}
    	
    	if(evenTail!=null)
    	{
    		evenTail.next = null;
    	}
    	oddTail.next = evenHead;
    	return oddHead;
      
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int a1 = sc.nextInt();
        head1 = insert(head1, a1);

        for (int i = 1; i < n1; i++) {
            int a = sc.nextInt();
            head1 = insert(head1, a);
        }

        head1 = oddEvenList(head1);
        display(head1);

    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    static Node head1;

    static Node head2;

    static Node head3;
    
    public static Node insert(Node head, int data) {

        if (head == null) {
            return new Node(data);
        }

        head.next = insert(head.next, data);
        return head;
    }

    public static void display(Node head) {
        for (Node node = head; node != null; node = node.next) {
            System.out.print(node.data + " ");
        }
    }

}