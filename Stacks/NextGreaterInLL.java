package Stacks;

/*
1. Given a linked list with head as the first node. 
2. Return an integer array containing next greaater value corresponding every node's value .
3. If there is no greater value then put 0 corresponding to its position.

Sample Input
3
2 1 5
Sample Output
5 5 0
 */
import java.util.*;

class newPair
{
	int pos;
	int value;
	
	newPair()
	{
		value = 0;
	}
}

public class NextGreaterInLL {
	 /* Structure of ListNode
	 	 ListNode {
	 	       int val;
	 	       ListNode next;
	 	       ListNode(int x) { val = x; }
	 	   }
	 */
	  public static int[] nextLargerNodes(ListNode head) {
	 
		  int length = 0;
		  
		  for(ListNode temp=head ; temp!=null ; temp=temp.next)
		  {
			  length++;
		  }
		  
		  int result[] = new int [length];
		  
		  Stack<newPair> S = new Stack<>();
		  int pos = 0;
		  for(ListNode temp=head ; temp!=null ; temp=temp.next,pos++)
		  {
			  int currData = temp.val;
			  
			  if(S.empty())
			  {
				  newPair P = new newPair();
				  P.pos = pos;
				  P.value = currData;
				  S.push(P);
				  continue;
			  }
			  
			  while(!S.empty() && S.peek().value<currData)
			  {
				  int Ans = currData;
				  result[S.pop().pos] = Ans;
			  }
			  
			  newPair P = new newPair();
			  P.pos = pos;
			  P.value = currData;
			  S.push(P);
		  }
		  
		  return result;
	 }
	 
	 // Dont make changes here
	 public static void main(String[] args) {
	 	 // TODO Auto-generated method stub
	 	 Scanner sc = new Scanner(System.in);
	 	 int size=sc.nextInt();
	 	 int headval=sc.nextInt();
	 	 ListNode head=new ListNode(headval);
	 	 ListNode tail=head;
	 	 for(int i=1;i<size;i++){
	 	 	 ListNode curr=new ListNode(sc.nextInt());
	 	 	 tail.next=curr;
	 	 	 tail=curr;
	 	 }
	 	 int[] res=nextLargerNodes(head);
	 	 for(int i=0;i<size;i++)System.out.print(res[i]+" ");
	 }
	 static class ListNode {
	       int val;
	       ListNode next;
	       ListNode(int x) { val = x; }
	   }

}

