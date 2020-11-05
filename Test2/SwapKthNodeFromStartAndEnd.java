package Test2;

import java.util.*;

/*
class Node
{
	int data;
	Node next;
}
*/

public class SwapKthNodeFromStartAndEnd {

	static Node head = null;
	static Node tail = null;
	
	public static void insertEnd(int data)
	{
		Node newNode = new Node();
		newNode.data = data;
		
		if(head==null)
		{
			head = newNode;
			tail = newNode;
			return ;
		}
		
		tail.next = newNode;
		tail = newNode;
	}
	
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int K = s.nextInt();
		
		for(int i=0 ; i<N ; i++)
		{
			int data = s.nextInt();
			insertEnd(data);
		}
		
		
		int i=1;
		Node temp1 = null;
		Node temp2 = null;
		
		for(Node temp=head ; temp!=null ; temp=temp.next)
		{
			if(i==K)
			{
				temp1 = temp;
			}
			if(i==N-K+1)
			{
				temp2 = temp;
			}
			i++;
		}
		
		int temp = temp1.data;
		temp1.data = temp2.data;
		temp2.data = temp;
		
		for(Node temp3=head ; temp3!=null ; temp3=temp3.next)
		{
			System.out.print(temp3.data+" ");
		}
		System.out.println();
		
	}

}
