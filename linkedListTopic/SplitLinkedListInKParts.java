package linkedListTopic;

import java.util.*;

public class SplitLinkedListInKParts {
	
    public static Node[] splitListToParts(Node head, int k) 
    {
    	int length = 0;
    	
    	if(head==null)
    	{
    		length = 0;
    	}
    	
    	for(Node temp=head ; temp!=null ; temp=temp.next)
    	{
    		length++;
    	}
    	
    	Node result[] = new Node [k];
    	
    	int index = 0;
    	
    	int minElements = length/k;
    	int maxElements = minElements+1;
    	
    	int mod = length%k;
    	
    	int numberLLMax = mod;
    	int numberLLMin = k-mod;
    	
    	Node prev = null;
    	Node temp = head;
    	
    	while(temp!=null)
    	{
    		result[index++] = temp;
    		
    		if(numberLLMax>0){
    			int j=0;
    			while(j<maxElements)
    			{
    				prev = temp;
    				temp = temp.next;
    				j++;
    			}
    			prev.next = null;
    			numberLLMax--;
    		}
    		else{
    			int j=0;
    			while(j<minElements)
    			{
    				prev = temp;
    				temp = temp.next;
    				j++;
    			}
    			prev.next = null;
    		}
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

        int k = sc.nextInt();

        Node[] arr = splitListToParts(head1, k);

        for (int i = 0; i < arr.length; i++) {
            display(arr[i]);
        }

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

    /*
     * Input Parameters: head: head of the linked list in which a new node is to
     * be inserted. data: the data value of the node which is to be inserted.
     * 
     * Return Value: head of the linked list in which the node is inserted
     */
    public static Node insert(Node head, int data) {

        if (head == null) {
            return new Node(data);
        }

        head.next = insert(head.next, data);
        return head;
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
