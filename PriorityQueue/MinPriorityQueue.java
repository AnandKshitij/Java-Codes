package PriorityQueue;


//for making minimum priority queue we need minimum heap
//in minimum priority queue the parent node is always less than its children

import java.util.*;

class minHeap
{
	ArrayList<Integer> arr;
	
	public minHeap()
	{
		arr = new ArrayList<>();
	}
	
	public void swap(int index1, int index2)
	{
		int temp1 = arr.get(index1);
		int temp2 = arr.get(index2);
		arr.set(index1,temp2);
		arr.set(index2,temp1);
	}
	
	public void insert(int data)
	{
		if(arr.size()==0)
		{
			arr.add(data);
			return ;
		}
		
		arr.add(data);
		
		//actually we require position of element in the priority queue
		int pos = arr.size();
		
		//index of parent
		int parent = (pos/2)-1;
		
		while(parent>=0 && arr.get(parent)>arr.get(pos-1))
		{
			swap(parent,pos-1);
			pos = parent+1;
			parent = (pos/2)-1;
		}
	}
	
	public int delete()
	{
		if(arr.isEmpty())
		{
			return -1;
		}
		
		if(arr.size()==1)
		{
			int removed = arr.remove(0);
			return removed;
		}
		
		swap(0,arr.size()-1);
		int removed = arr.remove(arr.size()-1);
		
		int pos = 1;
		int element = arr.get(0);
		int leftChild = 2*pos;//this is the position
		int rightChild = 2*pos+1;//this is the position
		
		//to get the indexes
		leftChild -= 1;
		rightChild -= 1;
		
		int left = Integer.MAX_VALUE;
		int right = Integer.MAX_VALUE;
		
		if(leftChild<arr.size())
		{
			left = arr.get(leftChild);
		}
		if(rightChild<arr.size())
		{
			right = arr.get(rightChild);
		}
		
		if(left>element && right>element)
		{
			return removed;
		}
		
		while(left<element || right<element)
		{
			if(left<right)
			{
				swap(leftChild,pos-1);
				pos = leftChild+1;
			}
			if(right<left)
			{
				swap(rightChild,pos-1);
				pos = rightChild+1;
			}
			
			leftChild = 2*pos;//this is the position
			rightChild = 2*pos+1;//this is the position
			
			//to get the indexes
			leftChild -= 1;
			rightChild -= 1;
			
			left = Integer.MAX_VALUE;
			right = Integer.MAX_VALUE;
			
			if(leftChild<arr.size())
			{
				left = arr.get(leftChild);
			}
			if(rightChild<arr.size())
			{
				right = arr.get(rightChild);
			}
		}
		return removed;
	}
	
	public void display()
	{
		for(int i=0 ; i<arr.size() ; i++)
		{
			System.out.print(arr.get(i)+"  ");
		}
		System.out.println();
	}
}
public class MinPriorityQueue {
	
	public static void main(String[] args)
	{
		minHeap minH = new minHeap();
		minH.insert(5);
		minH.insert(2);
		minH.insert(7);
		minH.insert(10);
		minH.insert(1);
		minH.insert(8);
		minH.insert(3);
		minH.display();
		System.out.println(minH.delete());
		minH.display();
		System.out.println(minH.delete());
		minH.display();
		System.out.println(minH.delete());
		minH.display();
		System.out.println(minH.delete());
		minH.display();
		System.out.println(minH.delete());
		minH.display();
		System.out.println(minH.delete());
		minH.display();
		System.out.println(minH.delete());
		minH.display();
		System.out.println(minH.delete());
		minH.display();
		
	}

}
