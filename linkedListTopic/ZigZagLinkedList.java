package linkedListTopic;

import java.util.Scanner;


public class ZigZagLinkedList {
	
    public static void fashion(Node head){
        
    	boolean flag = true;
    	
    	if(head==null){
    		return ;
    	}
    	if(head.next==null)
    	{
    		return ;
    	}
    	
    	Node prev = head;
    	Node curr = head.next;
    	
    	while(curr!=null)
    	{
    		if(flag)
    		{
    			if(curr.data<prev.data)
    			{
    				int temp = curr.data;
    				curr.data = prev.data;
    				prev.data = temp;
    			}
    		}
    		else
    		{
    			if(curr.data>prev.data)
    			{
    				int temp = curr.data;
    				curr.data = prev.data;
    				prev.data = temp;
    			}
    		}
    		
    		prev = curr;
    		curr = curr.next;
    		flag = !flag;
    	}
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a1 = sc.nextInt();
        insert(a1);

        for (int i = 1; i < n; i++) {
            int a = sc.nextInt();
            insert(a);
        }
        fashion(head);
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
        if (head == null) 
        {
            head = nn;
            tail = nn;
        } 
        else 
        {
            tail.next = nn;
            tail = nn;
        }
        size++;
    }

    public static void display() {
        for (Node node = head; node != null; node = node.next) {
            System.out.print(node.data + " ");
        }
    }

}
