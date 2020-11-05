package linkedListTopic;

/*
1. You are given a linked list with N nodes.
2. You are also given a number K.
3. You have to write a function that removes every Kth node from the list.
*/

import java.util.*;

public class DeleteKthNode {

    public static Node delete(Node n, int k) {
        
    	if(k==1){
    		return null;
    	}
    	
    	Node prev = null;
    	
    	int i=1;
    	for(Node temp=n ; temp!=null ;)
    	{
    		if(i==k)
    		{
    			prev.next = temp.next;
    			temp = temp.next;
    			i=1;
    		}
    		else
    		{
    			prev = temp;
    			temp = temp.next;
    			i++;
    		}
    	}
    	
    	return n;

    }

    // -----------------------------------------------------

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

        int k = sc.nextInt();

        head1 = delete(head1, k);
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