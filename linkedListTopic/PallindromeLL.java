package linkedListTopic;

import java.util.*;

public class PallindromeLL {

    static Node left;

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
    
    public static Node midPoint(Node head)
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
    public static boolean isPalindrome(Node head) {
        
    	Node mid = midPoint(head);
    	
    	Node midReverse = reverseLL(mid);
    	
    	Node temp1 = head;
    	Node temp2 = midReverse;
    	
    	while(temp1!=null && temp2!=null)
    	{
    		if(temp1.data!=temp2.data)
    		{
    			return false;
    		}
    		temp1 = temp1.next;
    		temp2 = temp2.next;
    	}
    	
    	return true;
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

        if (isPalindrome(head1)) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }

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
