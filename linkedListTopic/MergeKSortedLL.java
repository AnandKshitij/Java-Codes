package linkedListTopic;

import java.util.*;

/*
1. You are given K sorted (increasing order) linked lists.
2. You have to write a function that merges them in such a way that the resulting list is in increasing order.
 */

public class MergeKSortedLL {
	
	public static boolean isEmpty(Node[] temp)
	{
		for(int i=0 ; i<temp.length ; i++)
		{
			if(temp[i]!=null)
			{
				return false;
			}
		}
		return true;
	}
	
	public static int findMin(Node[] temp)
	{
		int minValue = Integer.MAX_VALUE;
		int min = 0;
		
		for(int i=0 ; i<temp.length ; i++)
		{
			if(temp[i]!=null)
			{
				if(temp[i].data<minValue)
				{
					minValue = temp[i].data;
					min = i;
				}
			}
		}
		
		return min;
	}
	
   
    public static Node mergeKList(Node []arr, int k){
        // write your code here.
    	Node head = null;
    	Node tail = null;
    	
    	while(!isEmpty(arr))
    	{
    		int min = findMin(arr);
    		
    		Node ourTemp = arr[min];
    		Node next = ourTemp.next;
    		
    		Node newNode = new Node(ourTemp.data);
    		
    		if(tail==null)
    		{
    			tail = newNode;
    			head = newNode;
    		}
    		else
    		{
    			tail.next = newNode;
    			tail = newNode;
    		}
    		ourTemp = next;
    		arr[min] = ourTemp; 
    		tail.next = null;
    	}
    	
    	return head;
    }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        
        Node[] arr = new Node[k];
        
        Node start = null;
        Node curr = null;
        
        for(int i=0; i < k; i++){
            int n = sc.nextInt();
            int a = sc.nextInt();
            start = new Node(a);
            arr[i] = start;
            
            curr = start;
            for(int j = 1; j < n; j++){
                Node ptr = new Node(sc.nextInt());
                curr.next = ptr;
                curr = ptr;
            }
            curr.next = null;
            start = null;
        }
        
        Node res = mergeKList(arr, k);
        display(res);
        
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }
    
    public static void display(Node head) {
        for (Node node = head; node != null; node = node.next) {
            System.out.print(node.data + " ");
        }
    }

}
