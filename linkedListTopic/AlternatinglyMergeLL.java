package linkedListTopic;

/*
You are given two singly linked list with N and M nodes respectively.
You have to write a function that which inserts the nodes of second list
into first list at alternate positions of first list. For example,

Input:
List1- 5->7->17->13->11
List2- 12->10->2->4->6
Output:
List1- 5->12->7->10->17->2->13->4->11->6
List2- (empty)

Note: The nodes of second list should only be inserted when there are
positions available.

Input:
List1- 1->2->3
List2- 4->5->6->7->8
Output:
List1- 1->4->2->5->3->6
List2- 7->8

Input
List1- 1->2->3->4->5
List2- 6->7->8
Output:
List1- 1->6->2->7->3->8->4->5
List2- (empty)
*/

import java.util.*;

public class AlternatinglyMergeLL {
	
	// It should return an array containing containing heads of resultant
    // first and second linked list at index 0 and 1 respectively.
    public static Node[] mergeAlt(Node head1, Node head2){
        
    	Node[] result = new Node[2];
    	
    	if(head1==null || head2==null)
    	{
    		result[0] = head1;
    		result[1] = head2;
    		return result;
    	}
    	
    	Node temp1 = head1;
    	Node temp2 = head2;
    	
    	Node storeTemp1=null;
    	Node storeTemp2=null;
    	
    	while(temp1!=null && temp2!=null)
    	{
    		storeTemp1 = temp1;
    		storeTemp2 = temp2;
    		
    		Node newTemp1 = temp1.next;
    		Node newTemp2 = temp2.next;
    		
    		temp1.next = temp2;
    		temp2.next = newTemp1;
    		
    		temp1 = newTemp1;
    		temp2 = newTemp2;
    	}
    	
    	if(temp1==null && temp2==null)
    	{
    		result[0] = head1;
    		result[1] = null;
    		return result;
    	}
    	
    	else if(temp1==null)
    	{
    		result[0] = head1;
    		result[1] = temp2;
    		return result;
    	}
    	
    	else if(temp2==null)
    	{
    		result[0] = head1;
    		result[1] = null;
    		return result;
    	}
    	
    	
    	return result;
        
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

        int n2 = sc.nextInt();
        int a2 = sc.nextInt();
        head2 = insert(head2, a2);

        for (int i = 1; i < n2; i++) {
            int a = sc.nextInt();
            head2 = insert(head2, a);
        }
        Node[] res = mergeAlt(head1, head2);
        display(res[0]);
        display(res[1]);
        //head3 = sublinkedList(head, head2);
        //display(head3);

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
        System.out.println();
    }

}