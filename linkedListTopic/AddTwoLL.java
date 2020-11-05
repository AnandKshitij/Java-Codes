package linkedListTopic;

import java.util.*;

import linkedListTopic.Add1ToLL.Node;

public class AddTwoLL {
	
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
	
    public static Node addTwoNumbers(Node n1, Node n2) {
       // write your code here.
    	
    	Node rev1 = reverseLL(n1);
    	Node rev2 = reverseLL(n2);
    	
    	Node newHead = null;
    	Node newTail = null;
    	
    	int carry = 0;
    	
    	while(rev1!=null || rev2!=null)
    	{
    		int data1 = 0;
    		if(rev1!=null)
    		data1 = rev1.data;
    		int data2 = 0;
    		if(rev2!=null)
    		data2 = rev2.data;
    		
    		int data = data1+data2+carry;
    		
    		carry = data/10;
    		data = data%10;
    		
    		Node newNode = new Node(data,null);
    		
    		if(newHead==null)
    		{
    			newHead = newNode;
    			newTail = newNode;
    		}
    		else
    		{
    			newNode.next = newHead;
    			newHead = newNode;
    		}
    		
    		if(rev1!=null)
    		rev1 = rev1.next;
    		if(rev2!=null)
    		rev2 = rev2.next;
    	}
    	
    	if(carry!=0)
    	{
    		Node newNode = new Node(carry,null);
    		
    		if(newHead==null)
    		{
    			newHead = newNode;
    			newTail = newNode;
    		}
    		else
    		{
    			newNode.next = newHead;
    			newHead = newNode;
    		}
    	}
    	
    	
    	return newHead;

    }

    
    // -----------------------------------------------------

    static Node head1;

    static Node head2;

    static Node head3;

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

        int n2 = sc.nextInt();
        int a2 = sc.nextInt();

        head2 = tail = insert(null, a2);

        for (int i = 1; i < n2; i++) {
            int a = sc.nextInt();
            tail = insert(tail, a);
        }

        head3 = addTwoNumbers(head1, head2);
        display(head3);

    }

    // Class declaration for a Node of the Linked List
    private static class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
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
            return new Node(data, null);
        }

        Node nn = new Node(data, null);
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
        System.out.println();
    }

}