package Test2;

import java.util.Scanner;

class Node
{
	int data;
	Node next;
}


public class AlternatinglyMerge {
	
	static Node head1 = null;
	static Node head2 = null;
	static Node tail1 = null;
	static Node tail2 = null;

	
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		int N = s.nextInt();
		
		for(int i=0 ; i<N ; i++)
		{
			int data = s.nextInt();
			Node newNode = new Node();
			newNode.data = data;
			if(tail1==null)
			{
				head1 = newNode;
				tail1 = newNode;
			}
			else
			{
				tail1.next = newNode;
				tail1 = newNode;
			}
		}
		
		int M = s.nextInt();
		
		for(int i=0 ; i<M ; i++)
		{
			int data = s.nextInt();
			Node newNode = new Node();
			newNode.data = data;
			if(tail2==null)
			{
				head2 = newNode;
				tail2 = newNode;
			}
			else
			{
				tail2.next = newNode;
				tail2 = newNode;
			}
		}
		
		Node temp1 = head1;
		Node temp2 = head2;
		Node next1 = null;
		Node next2 = null;
		
		while(temp1!=null && temp2!=null)
		{
			next1 = temp1.next;
			next2 = temp2.next;
			
			temp1.next = temp2;
			temp2.next = next1;
			
			temp1 = next1;
			temp2 = next2;
			head2 = next2;
		}
		
		
		for(Node temp3=head1 ; temp3!=null ; temp3=temp3.next)
		{
			System.out.print(temp3.data+" ");
		}
		System.out.println();
		
		for(Node temp3=head2 ; temp3!=null ; temp3=temp3.next)
		{
			System.out.print(temp3.data+" ");
		}
		System.out.println();
		
		
		
	}

}
