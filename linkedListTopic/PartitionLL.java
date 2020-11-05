package linkedListTopic;

/*
1. You are given a linked list with N nodes.
2. You are also given a number X.
3. You have to write a function that partitions the list such that all nodes less than x come 
before nodes greater than or equal to x.
Note: You should preserve the original relative order of the nodes in each of the two partitions.
 */
import java.util.*;

public class PartitionLL {

    public static Node partition(Node n, int x) {
    	if(n==null || n.next==null){
    		return n;
    	}
    	
    	Node smallHead = null;
    	Node smallTail =null;
        Node bigHead = null;
        Node bigTail = null;
        
        for(Node temp=n ; temp!=null ;)
        {
        	int tempData = temp.data;
        	Node newNode = new Node(tempData);
        	Node next = temp.next;
        	
        	if(tempData<x)
        	{
        		if(smallHead==null){
        			smallHead = newNode;
        			smallTail = newNode;
        		}
        		else{
        			smallTail.next = newNode;
        			smallTail = newNode;
        		}
        		smallTail.next = null;
        	}
        	else{
        		if(bigHead==null){
        			bigHead = newNode;
        			bigTail = newNode;
        		}
        		else{
        			bigTail.next = newNode;
        			bigTail = newNode;
        		}
        		bigTail.next = null;
        	}
        	temp = next;
        }
        
        if(smallTail==null){
        	return bigHead;
        }
        
        smallTail.next = bigHead;
        return smallHead;
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

        int x = sc.nextInt();

        head1 = partition(head1, x);
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
