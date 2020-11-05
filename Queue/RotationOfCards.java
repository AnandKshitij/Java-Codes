package Queue;

/*
1. Given a sorted deck of cards numbered 1 to N.

2. Rotation of cards:
a) We pick up 1 card and put it on the back of the deck.
b) Now, we pick up another card , it turns out to be card numbered 1 , we put it outside the deck.
c) Now we pick up 2 cards and put it on the back of the deck.
d) Now, we pick up another card and it turns out to be card numbered 2 , we put it outside the deck. ...
e) Now we pick up 3 cards and put it on the back of the deck.
f) Now, we pick up another card and it turns out to be card numbered 3 , we put it outside the deck. ...
g)We perform this step till the deck becomes empty.

 */

import java.util.*;
import java.lang.*;
import java.io.*;

public class RotationOfCards{

    public static void cardRotation(int N) {

    	int result[] = new int [N];
    	
    	Queue<Integer> Q = new LinkedList<>();
    	
    	for(int i=1 ; i<=N ; i++)
    	{
    		Q.add(i);
    	}
    	
    	int rotations = 1;
    	
    	while(!(Q.size()==1))
    	{
    		boolean flag = true;
    		
    		if(rotations%Q.size()==0)
    		{
    			flag = false;
    		}
    		for(int i=0 ; i<rotations ; i++)
    		{
    			int front = Q.remove();
    			Q.add(front);
    		}
    		int card = Q.remove();
    		result[card-1] = rotations;
    		rotations++;
    	}
    	
    	int card = Q.remove();
    	result[card-1] = rotations;
    	
    	for(int i=0 ; i<result.length ; i++)
    	{
    		System.out.print(result[i]+" ");
    	}
    	System.out.println();
    	
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        cardRotation(N);
    }

}
