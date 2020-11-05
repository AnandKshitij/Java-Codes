package linkedListTopic;

/*
1. You are given a singly linked list N nodes.
2. You have to write a function that deletes the middle node of the linked list. 
3. Note: 
1: If there are even nodes, then there would be two middle nodes. 
You have to delete the second middle element.
2: If the input linked list has 1 node, then this node should be deleted and new 
head should be returned as null.
 */

import java.util.*;

public class DeleteMiddleNodeLL {

    public static Node Delete(Node head) 
    {
    	if(head==null || head.next==null){
    		return null;
    	}
    	
    	Node prev = null;
    	Node slow = head;
    	Node fast = head.next;
    	
    	boolean even = false;
    	
    	while(fast!=null)
    	{
    		fast = fast.next;
    		if(fast!=null){
    			prev = slow;
    			slow = slow.next;
    			fast = fast.next;
    		}
    		else{
    			even = true;
    			break;
    		}
    	}
    	
    	if(!even){
    		prev.next = slow.next;
    	}
    	else{
    		Node delete = slow.next;
    		slow.next = delete.next;
    	}
    	
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

        head1 = Delete(head1);
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
     * Input Parameters: tail: tail of the linked list in which a new node is to
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
        System.out.println();
    }

}
