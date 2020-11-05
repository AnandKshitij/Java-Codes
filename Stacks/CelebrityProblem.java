package Stacks;

/*
1. You are in a party of N people, where there may exist a celebrity known to everyone. 
2. If such a person is present in the party, (s)he doesn't know anyone in the party. 
3. Your task is to find the stranger (celebrity) in party.
4. You will be given a square matrix M[][] where if an element of row i and column j is set to 1 it means ith person knows jth person. 
5. You need to complete the function getId() which finds the id of the celebrity if present else return -1.

Input Format
 First Line contains N(no. of persons in the party)
Second line contains N*N space separated values(0 or 1).
output Format
 Return an integer(id of the celebrity if present otherwise -1)
 
 Sample Input
3
0 1 0 
0 0 0 
0 1 0"
Sample Output
1
*/

/*
A person is a celebrity if everyone knows him and he does not know anyone.

For this problem we can have n*n complexity and easily solve it

But we want the complexity to be n. We can do this by the method of elimination. We know that only one 
person can be a celebrity.Because the conditions are both ways. He should not know anyone and everyone 
should know him. 

So we use a stack and initially put all people in it

Stack: 2 1 0

Now we pop 1st 2 elements from stack
val1 = 2
val2 = 1

if arr[val1][val2] == 1
then val1 knows val2 
So val1 is not a celebrity
So we push val2 and val1 is eliminated

if arr[val1][val2] == 0
then val1 does not know val2
So val2 is not a celebrity
So we push val1 and val2 is eliminated

In this way we eliminate 1 element each time until we are left with just one element

Now we have eliminated all other elements from the race
But we are not sure whether this element is celebrity or not

So we check the row and column of this element

In row all elements should be zero(except for element itself(we don't need to check that))
In column all elements should be one(except for element itself(we don't need to check that))
 */


import java.util.*;

public class CelebrityProblem {
	
	public static int celebrityProblem(int arr[][], int n)
	{
		Stack<Integer> S = new Stack<>();
		
		for(int i=0 ; i<n ; i++)
		{
			S.add(i);
		}
		
		while(S.size()>1)
		{
			int val1 = S.pop();
			int val2 = S.pop();
			
			//val1 knows val2
			//val1 is not a celebrity
			if(arr[val1][val2]==1)
			{
				S.push(val2);
			}
			//val2 is not a celebrity
			else
			{
				S.push(val1);
			}
		}
		
		int index = 0;
		
		if(!S.empty())
		index = S.pop();
		
		//first checking the row
		//every element should be 0
		for(int j=0 ; j<n ; j++)
		{
			if(j==index)
			{
				continue;
			}
			//the element knows someone other than himself
			if(arr[index][j]==1)
			{
				return -1;
			}
		}
		
		//now checking the row
		//every element should be 1
		for(int i=0 ; i<n ; i++)
		{
			if(i==index)
			{
				continue;
			}
			if(arr[i][index]==0)
			{
				return -1;
			}
		}
		
		return index;
	}
	
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		int N = s.nextInt();
		
		int arr[][] = new int [N][N];
		
		for(int i=0 ; i<N ; i++)
		{
			for(int j=0 ; j<N ; j++)
			{
				arr[i][j] = s.nextInt();
			}
		}
		
		int result = celebrityProblem(arr,N);
		System.out.println(result);
	}

}
