package linkedListTopic;

import java.util.*;

public class ReverseLLFromMToN {

    public static Node reverseBetween(Node head, int m, int n) {
        // write your code here
    	
    	Node prev = null;
    	Node curr = head;
    	Node nextNode = null;
    	
    	Node head1 = null;
    	Node head2 = null;
    	Node prev1 = null;
    	
    	if(m>n)
    	{
    		int temp = m;
    		m = n;
    		n = temp;
    	}
    	
    	for(int i=0 ; i<n && curr!=null ; i++)
    	{
    		nextNode = curr.next;
    		if(i<m-1)
    		{
    			prev = curr;
    			curr = nextNode;
    		}
    		else
    		{
    			if(i==m-1)
    			{
    				prev1 = prev;
        			head1 = curr;
    			}
    			else if(i==n-1)
    			{
    				head2 = curr;
    			}
    			curr.next = prev;
    			prev = curr;
    			curr = nextNode;
    		}
    	}
    	
    	if(prev1!=null)
    	{
        	prev1.next = head2;
        	head1.next = nextNode;
    	}
    	else
    	{
    		head1.next = nextNode;
    		return head2;
    	}
    	
    	
    	return head;
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

        int m = sc.nextInt();
        int n = sc.nextInt();
        head1 = reverseBetween(head1, m, n);
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

    static Node head1;

    static Node head2;

    static Node head3;

    /*
     * Input Parameters: head: head of the linked list in which a new node is to
     * be inserted. data: the data value of the node which is to be inserted.
     * 
     * Return Value: head of the linked list in which the node is inserted
     */
    public static Node insert(Node head, int data) {

        if (head == null) {
            return new Node(data);
        }

        head.next = insert(head.next, data);
        return head;
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
