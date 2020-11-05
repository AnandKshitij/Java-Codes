package linkedListTopic;

/*
1. The task is to implement methods of an LRU cache. 
2. The class has two methods get() and set() which are defined as follows.
get(x) : Gets the value of the key x if the key exists in the cache otherwise returns -1.
set(x,y) : Inserts the value if the key x is not already present. 
If the cache reaches its capacity it should invalidate the least recently used item before 
inserting the new item.
3. In the constructor of the class the size of the cache should be initialized.


Input Format
First line contains an integer N denoting the capacity of the cache
Second line contains an integer Q denoting the number of queries.
Third line contains Q queries. 
A Query can be of two types
1. SET x y : sets the value of the key x with value y
2. GET x : gets value corresponding to key x if present else returns -1.
 */


/*
We will solve this problem using hash maps and doubly linked list
For questions involving the use of least recently or most recently used element where we have to
delete as well as add elements we always use doubly LL and has maps

Here the hash map will be key vs node
So the value will be the address of the node corresponding to that key

The head will always be on the most recently added element
So head will give us the most recently used element and tail(head.prev) will give us least 
recently used
We are using doublyLL because we want both add and delete functions on head and tail to be O(1) 

When get function is called the element becomes the most recently used element
So we have to delete the element from its current position and make it the new head

In set if the element is already present then we just need to change its value and make it 
most recently added

If the element was not present
Then we first need to check whether the cache has reached its capacity or not
If yes then we need to delete the least frequently used element

Then we need to add our element
*/

import java.util.Scanner;
import java.util.HashMap;

class DoublyLL
{
	int data;
	int key;
	DoublyLL prev;
	DoublyLL next;
	
	public DoublyLL(int key, int data)
	{
		this.key = key;
		this.data = data;
		this.prev = null;
		this.next = null;
	}
}
class Cache
{
	int capacity;
	int currSize;
	DoublyLL head;
	DoublyLL tail;
	HashMap<Integer, DoublyLL> H;
	
	public Cache(int capacity)
	{
		this.capacity = capacity;
		this.currSize = 0;
		this.head = null;
		this.tail = null;
		this.H = new HashMap<>();
	}
	
	public void insertFront(int key, int data)
	{
		DoublyLL newNode = new DoublyLL(key,data);
		if(head==null)
		{
			head = newNode; 
			tail = newNode;
			currSize++;
			H.put(key,newNode);
			return ;
		}
		
		newNode.next = head;
		head.prev = newNode;
		head = newNode;
		currSize++;
		H.put(key,newNode);
	}
	
	public void deleteTail()
	{
		if(tail==null)
		{
			return ;
		}
		if(head==tail)
		{
			int key = tail.key;
			H.remove(key);
			tail = null;
			head = null;
			currSize--;
			return ;
		}
		
		int key = tail.key;
		H.remove(key);
		tail = tail.prev;
		tail.next = null;
		currSize--;
	}
	
	public void delete(int key)
	{	
		if(!H.containsKey(key))
		{
			return ;
		}
		DoublyLL deleteNode = H.get(key);
		
		if(deleteNode==tail)
		{
			deleteTail();
			return ;
		}
		
		int deleteKey = deleteNode.key;
		H.remove(deleteKey);
		
		
		if(deleteNode.prev!=null)
		deleteNode.prev.next = deleteNode.next;
		
		if(deleteNode.next!=null)
		deleteNode.next.prev = deleteNode.prev;
		
		currSize--;
	}
	
	public void set(int key, int value)
	{
		if(H.containsKey(key))
		{
			delete(key);
			insertFront(key,value);
			return ;
		}
		
		if(currSize<capacity)
		{
			insertFront(key,value);
		}
		else
		{
			deleteTail();
			insertFront(key,value);
		}
	}
	
	public void display()
	{
		DoublyLL temp = head;
		
		System.out.println();
		while(temp!=null)
		{
			System.out.print(temp.data+"   ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public int get(int key)
	{
		if(!H.containsKey(key))
		{
			return -1;
		}
		DoublyLL keyNode = H.get(key);
		int ourKey = keyNode.key;
		int ourValue = keyNode.data;
		
		delete(ourKey);
		insertFront(ourKey,ourValue);
		
		return ourValue;
	}
}

public class LeastRecentlyUsedElement {
	
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		int N = s.nextInt();
		int Q = s.nextInt();
		
		Cache C = new Cache(N);
		
		for(int i=0 ; i<Q ; i++)
		{
			String input = s.next();
			
			if(input.equals("SET"))
			{
				int key = s.nextInt();
				int value = s.nextInt();
				
				C.set(key,value);
			}
			
			if(input.equals("GET"))
			{
				int key = s.nextInt();
				System.out.println(C.get(key));
			}
		}
	}
}
