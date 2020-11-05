package linkedListTopic;

import java.util.Scanner;

public class Vowels{

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
            
        int n = sc.nextInt();
        char h = sc.next().charAt(0);
        insert(h);

        for (int i = 1; i < n; i++) {
            char ch = sc.next().charAt(0);
            insert(ch);
        }
        
        head = arcv(head);
        display();
        
    }

    //---------------------------------------------------------------
    //This is a functional problem. Only this function has to be written.
    // This function should return the head of node after sorting.
    public static Node arcv(Node head) {
        
       Node head1 = null;
       Node tail1 = null;
       Node head2 = null;
       Node tail2 = null;
       
       Node temp = head;
       
       while(temp!=null)
       {
    	Node newNode = temp.next;
      		
       	if(temp.data=='a' || temp.data=='e' || temp.data=='i' || temp.data=='o' || temp.data=='u')
       	{
       		if(head1==null)
       		{
       			head1 = temp;
       			tail1 = temp;
       			tail1.next = null;
       		}
       		else
       		{
       			tail1.next = temp;
       			tail1 = temp;
       			tail1.next = null;
       		}
       	}
       	
       	else
       	{
       		if(head2==null)
       		{
       			head2 = temp;
       			tail2 = temp;
       			tail2.next = null;
       		}
       		else
       		{
       			tail2.next = temp;
       			tail2 = temp;
       			tail2.next = null;
       		}
       	}
       	
       	temp = newNode;
       	
       }
       
       if(tail1!=null)
       {
            tail1.next = head2;
            return head1;
       }
       else
       return head2;
      
        
    }
//------------------------------------------------------------------

    
    private static class Node {
        char data;
        Node next;

        public Node(char data, Node next) {
            this.data = data;
            this.next = next;
        }

    }

    static Node head;
    static Node tail;
    static int size;

    public static void insert(char data) {

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