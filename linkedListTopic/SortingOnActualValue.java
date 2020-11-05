package linkedListTopic;

import java.util.Scanner;

public class SortingOnActualValue {

    //You should return the head of node after sorting.
    public static Node sort(Node n) {
    	
    	Node prev = null;
    	Node curr = n;
    	
    	while(curr!=null)
    	{
    		if(curr.data>=0){
    			prev = curr;
    			curr = curr.next;
    		}
    		else
    		{
    			if(prev==null)
    			{
    				prev=curr;
    				curr = curr.next;
    			}
    			else
    			{
    				prev.next = curr.next;
    				curr.next = head;
    				head = curr;
    				curr = prev.next;
    			}
    		}
    	}
        return head;
    }
//------------------------------------------------------------------





    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);    
            
        int n = sc.nextInt();
        int a1 = sc.nextInt();

        insert(a1); // inserting first node

        for (int i = 1; i < n; i++) {
            int a = sc.nextInt();
            insert(a);
        }

        head = sort(head);
        display();

    }


    private static class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

    }

    static Node head;
    static Node tail;
    static int size;

    public static void insert(int data) {

        Node nn = new Node(data, null);
        if (head == null) {
            head = nn;
            tail = nn;
        } else {
            tail.next = nn;
            tail = nn;
        }
        size++;
    }

    public static void display() {
        for (Node node = head; node != null; node = node.next) {
            System.out.print(node.data+" ");
        }
    }

}