package linkedListTopic;

import java.util.*;

public class Add1ToLL {
	
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

    public static Node plusOne(Node n) {
        // write your code here.
    	
    	Node rev = reverseLL(n);
    	
    	for(Node m=n ; m!=null ; m=m.next)
    	{
    		System.out.print(m.data+"   ");
    	}
    	System.out.println();
    	
    	Node newHead = null;
    	Node newTail = null;
    	int curr = 0;
    	Node temp = rev;
    	
    	while(temp!=null)
    	{
    		int value = curr+temp.data;
    		
    		if(temp==rev)
    		{
    			value++;
    		}
    		
    		curr = value/10;
    		value = value%10;
    		
    		Node newNode = new Node(value);
    		
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
    		
    		temp = temp.next;
    	}
    	if(curr!=0)
    	{
    		Node newNode = new Node(curr);
    		
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

        head1 = plusOne(head1);
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

    public static Node insert(Node tail, int data) {

        if (tail == null) {
            return new Node(data);
        }

        Node nn = new Node(data);
        tail.next = nn;
        return nn;
    }
    
    public static void display(Node head) {
        for (Node node = head; node != null; node = node.next) {
            System.out.print(node.data + " ");
        }
    }

}