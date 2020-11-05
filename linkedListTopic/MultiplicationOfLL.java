package linkedListTopic;

import java.util.*;
public class MultiplicationOfLL {
	
	public static Node reverseLL(Node head)
	{
		if(head==null || head.next==null)
		{
			return head;
		}
		
		Node prev = null;
		Node curr = head;
		
		while(curr!=null)
		{
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		return prev;
	}
	
    public static Node addTwoNumbers(Node n1, Node n2) {
       // write your code here.
    	
    	Node rev1 = reverseLL(n1);
    	Node rev2 = reverseLL(n2);
    	
    	Node newHead = null;
    	Node newTail = null;
    	
    	int carry = 0;
    	
    	while(rev1!=null || rev2!=null)
    	{
    		int data1 = 0;
    		if(rev1!=null)
    		data1 = rev1.data;
    		int data2 = 0;
    		if(rev2!=null)
    		data2 = rev2.data;
    		
    		int data = data1+data2+carry;
    		
    		carry = data/10;
    		data = data%10;
    		
    		Node newNode = new Node(data);
    		
    		if(newHead==null)
    		{
    			newHead = newNode;
    			newTail = newNode;
    		}
    		else
    		{
    			newNode.next = newHead;
    			newHead = newNode;
    		}
    		
    		if(rev1!=null)
    		rev1 = rev1.next;
    		if(rev2!=null)
    		rev2 = rev2.next;
    	}
    	
    	if(carry!=0)
    	{
    		Node newNode = new Node(carry);
    		
    		if(newHead==null)
    		{
    			newHead = newNode;
    			newTail = newNode;
    		}
    		else
    		{
    			newNode.next = newHead;
    			newHead = newNode;
    		}
    	}
    	
    	
    	return newHead;

    }

    public static long multiplyTwoLists(Node one, Node two) {
    	
    	Node twoRev = reverseLL(two);
    	Node oneRev = reverseLL(one);
    	
    	
    	int addZeroes = 0;
    	
    	Node head = new Node(0);
    	
    	for(Node temp=twoRev ; temp!=null ; temp=temp.next)
    	{
    		Node tempHead = null;
    		Node tempTail = null;
    		int twoData = temp.data;
    		int carry = 0;
    		Node oneTemp = oneRev;
    		
    		while(oneTemp!=null)
    		{
    			int oneData = oneTemp.data;
    			int newData = (oneData*twoData)+carry;
    			carry = newData/10;
    			newData = newData%10;
    			Node newNode = new Node(newData);
    			if(tempHead==null)
    			{
    				tempHead = newNode;
    				tempTail = newNode;
    			}
    			else
    			{
    				tempTail.next = newNode;
    				tempTail = newNode;
    			}
    			oneTemp = oneTemp.next;
    		}
    		
    		if(carry!=0)
    		{
    			Node newNode = new Node(carry);
    			if(tempHead==null)
    			{
    				tempHead = newNode;
    				tempTail = newNode;
    			}
    			else
    			{
    				tempTail.next = newNode;
    				tempTail = newNode;
    			}
    		}
    		
    		for(int i=0 ; i<addZeroes ; i++)
    		{
    			Node newNode = new Node(0);
    			newNode.next = tempHead;
    			tempHead = newNode;
    		}
    		
    		addZeroes++;
    		
    		head = addTwoNumbers(head,reverseLL(tempHead));
    	}
    	
    	long Ans = 0L;
    	
    	int mod = (int) Math.pow(10,9)+7;
    	for(Node temp=head ; temp!=null ; temp=temp.next)
    	{
    		long small = (long)temp.data%mod;
    		Ans = (long)((Ans*10)+small)%mod;
    	}
    	return Ans;
    }

    static Node head1;

    static Node head2;

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

        int n2 = sc.nextInt();
        int a2 = sc.nextInt();

        head2 = tail = insert(null, a2);

        for (int i = 1; i < n2; i++) {
            int a = sc.nextInt();
            tail = insert(tail, a);
        }

        System.out.println(multiplyTwoLists(head1, head2));

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
