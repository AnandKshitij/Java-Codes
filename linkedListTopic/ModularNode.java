package linkedListTopic;

/*
1. You are given a linked list with N nodes.
2. You are also given a number K.
3. You have to write a function that that returns the data of the modular node of the linked list.
4. A modular node is the last node of the linked list whose index(1-based indexing) is 
divisible by the number K, i.e. i % K == 0.
 */

import java.util.*;

public class ModularNode {
	
    public static int moduarNode(Node head, int k) 
    {
    	int pos = 1;
    	
    	if(head==null)
    	{
    		return -1;
    	}
    	
    	Node curr = null;
    	
    	Node temp = head;
    	
    	while(temp!=null)
    	{
    		if((pos)%k==0)
    		{
    			curr = temp;
    		}
    		pos++;
    		temp = temp.next;
    	}
    	
    	if(curr==null)
    	{
    		return -1;
    	}
    	
    	return curr.data;
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

        int k = sc.nextInt();

        System.out.println(moduarNode(head1, k));

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
