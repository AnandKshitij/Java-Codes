package linkedListTopic;

import java.util.*;

public class DeleteDuplicateNodesInSortedLL {

    public static Node removeDuplicates(Node head) {
    	if(head==null || head.next==null){
    		return head;
    	}
    	
    	Node prev = null;
    	Node curr = head;
    	
    	while(curr!=null)
    	{
    		if(prev!=null){
    			if(prev.data==curr.data){
    				prev.next = curr.next;
    				curr = curr.next;
    			}
    			else{
    				prev = curr;
    				curr = curr.next;
    			}
    		}
    		else{
    			prev = curr;
    			curr = curr.next;
    		}
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

        head1 = removeDuplicates(head1);
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
    
    static Node insert(Node tail, int data) {

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
