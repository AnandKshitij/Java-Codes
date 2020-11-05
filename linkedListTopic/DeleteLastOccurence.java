package linkedListTopic;

/*
1. You are given a singly linked list N nodes.
2. You are also given a key K.
3. You have to write a function that deletes the last occurrence of K in the linked list. 
 */

import java.util.*;

public class DeleteLastOccurence {

    public static Node func(Node head, int key) {
    	if(head==null){
    		return head;
    	}
    	
    	if(head.next==null && head.data==key){
    		return null;
    	}
    	
    	Node curr = null;
    	Node prev = null;
    	
    	boolean flag = false;
    	
    	if(head.data==key)
    	{
    		curr = head;
    		flag = true;
    	}
    	else{
    		prev = head;
            curr = head.next;
    	}
    	
    	Node temp = head.next;
    	
    	while(temp.next!=null)
    	{
    		int data = temp.next.data;
    		
    		if(data==key){
    			prev = temp;
    			curr = temp.next;
    			flag = true;
    		}
    		temp = temp.next;
    	}
    	
    	if(!flag){
    		return head;
    	}
    	
    	if(prev==null){
    		return head.next;
    	}
    	
    	prev.next = curr.next;
    	return head;
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
        head1 = func(head1, k);
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

        System.out.println();
    }

}
