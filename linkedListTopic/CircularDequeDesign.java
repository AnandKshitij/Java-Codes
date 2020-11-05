package linkedListTopic;

/*
Design your implementation of the circular double-ended queue (deque).

Your implementation should support following operations:

MyCircularDeque(k): Constructor, set the size of the deque to be k.
insertFront(x): Adds an item at the front of Deque. Return true if the operation is successful.
insertLast(x): Adds an item at the rear of Deque. Return true if the operation is successful.
deleteFront(): Deletes an item from the front of Deque. Return true if the operation is successful.
deleteLast(): Deletes an item from the rear of Deque. Return true if the operation is successful.
getFront(): Gets the front item from the Deque. If the deque is empty, return -1.
getRear(): Gets the last item from Deque. If the deque is empty, return -1.
isEmpty(): Checks whether Deque is empty or not. 
isFull(): Checks whether Deque is full or not.

First line contains 'S' size of the dequeue.
Second line contains N(number of queries)
Third line contains queries in the following manner:
insertFront(x): 1 x
insertLast(x): 0 x
deleteFront(): 2
deleteLast():-2
getFront():3
getRear():-3	
isEmpty():4
isFull():5
*/


import java.util.*;

class DoublyLL
{
	int data;
	DoublyLL next;
	DoublyLL prev;
}

public class CircularDequeDesign {

    static class CircularDeque {

        DoublyLL head;
        DoublyLL tail;
        int size;
        int currSize;

        public CircularDeque(int k) {
        	this.size = k;
        	this.head = null;
        	this.tail = null;
        	this.currSize = 0;
        }

        public boolean insertFront(int value) {
        	
        	//queue is full
        	if(currSize==size){
        		return false;
        	}
        	
        	DoublyLL newNode = new DoublyLL();
        	newNode.data = value;
        	
        	//queue is empty
        	if(head==null){
        		head = newNode;
        		head.next = head;
        		head.prev = head;
        		tail = head;
        	}
        	else{
        		newNode.next = head;
        		newNode.prev = tail;
        		head.prev = newNode;
        		tail.next = newNode;
        		head = newNode;
        	}
        	currSize++;
        	
        	return true;
        }

        public boolean insertLast(int value) {
        	//queue is full
        	if(currSize==size){
        		return false;
        	}
        	
        	DoublyLL newNode = new DoublyLL();
        	newNode.data = value;
        	
        	//queue is empty
        	if(head==null){
        		head = newNode;
        		head.next = head;
        		head.prev = head;
        		tail = head;
        	}
        	else{
        		newNode.next = head;
        		newNode.prev = tail;
        		head.prev = newNode;
        		tail.next = newNode;
        		tail = newNode;
        	}
        	currSize++;
        	return true;
        }

        public boolean deleteFront() {
        	//queue is empty
        	if(currSize==0){
        		return false;
        	}
        	
        	//queue has only one element
        	if(head.next==head){
        		head = null;
        		tail = null;
        	}
        	else{
        		head.next.prev = head.prev;
        		tail.next = head.next;
        		head = head.next;
        	}
        	currSize--;
        	return true;
        }
        
        public boolean deleteLast() {
        	
        	//queue is empty
        	if(currSize==0)
        	{
        		return false;
        	}
        	
        	//queue has only one element
        	if(head.next==head)
        	{
        		head = null;
        		tail = null;
        	}
        	else
        	{
        		tail.prev.next = tail.next;
        		head.prev = tail.prev;
        		tail = tail.prev;
        	}
        	
        	currSize--;
        	
        	return true;
        	
        }

        public int getFront() {
        	if(currSize==0){
        		return -1;
        	}
        	return head.data;
        }

        public int getRear() {
        	if(currSize==0){
        		return -1;
        	}
        	return tail.data;
        }
        
        public boolean isEmpty() {	
        	if(currSize==0){
        		return true;
        	}
        	return false;
        }

        public boolean isFull() {
        	
        	if(currSize==size)
        	{
        		return true;
        	}
        	
        	return false;
        }

    }
    
    // Dont make changes here
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularDeque cd = new CircularDeque(sc.nextInt());
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int q = sc.nextInt();
            String s = "";
            if (q == 1) {
                s = "" + cd.insertFront(sc.nextInt());
            } else if (q == 0) {
                s = "" + cd.insertLast(sc.nextInt());
            } else if (q == 2) {
                s = "" + cd.deleteFront();
            } else if (q == -2) {
                s = "" + cd.deleteLast();
            } else if (q == 3) {
                s = "" + cd.getFront();
            } else if (q == -3) {
                s = "" + cd.getRear();
            } else if (q == 4) {
                s = "" + cd.isEmpty();
            } else if (q == 5) {
                s = "" + cd.isFull();
            }
            System.out.print(s + " ");
        }
    }
}