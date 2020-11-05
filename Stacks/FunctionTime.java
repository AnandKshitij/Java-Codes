package Stacks;

/*
1. On a single threaded CPU, we execute some functions. Each function has a unique id between 0 and N-1.
2. We store logs in timestamp order that describe when a function is entered or exited.
3. Each log is a string with this format: "{function_id}:{"start" | "end"}:{timestamp}". 
For example, "0:start:3" means the function with id 0 started at the beginning of timestamp 3.
 "1:end:2" means the function with id 1 ended at the end of timestamp 2.
4. A function's exclusive time is the number of units of time spent in this function. 
Note that this does not include any recursive calls to child functions.
5. The CPU is single threaded which means that only one function is being executed at a given time unit.
6. Return the exclusive time of each function, sorted by their function id.

Example
Input:
n = 2
logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
Output: [3, 4]
Explanation:
Function 0 starts at the beginning of time 0, then it executes 2 units of time and reaches the end of time 1.
Now function 1 starts at the beginning of time 2, executes 4 units of time and ends at time 5.
Function 0 is running again at the beginning of time 6, and also ends at the end of time 6, 
thus executing for 1 unit of time. 
So function 0 spends 2 + 1 = 3 units of total time executing, and function 1 spends 4 units of 
total time executing.
 */


/*
We will approach this problem using stack

Every element of the stack will have 3 properties
1)ID
2)Start time
3)NotMyTime

Not my time property will have the value in which other functions within that function were executing

Take test case

0s0,1s2,1e5,2s6,3s10,4s14,5s16,5e18,4e20,3e23,0e30
s-start
e-end

First is s so push to stack
Stack - 0(id)/0(start)/0(notMyTime)


s so push to stack
Stack - 1/2/0	0/0/0

e so pop
pop-1/2/0
Ans for 1 is 5-2+1-0=4 
We will also add 5-2+1 to notMyTime of 0
Stack - 0/0/4

s so push to stack
Stack - 2/6/0	0/0/4

s so push to stack
Stack - 3/10/0	1/2/0	0/0/4

s so push to stack
Stack - 4/14/0	3/10/0	1/2/0	0/0/4

s so push to stack
Stack - 5/16/0	4/14/0	3/10/0	1/2/0	0/0/4

e so pop
Ans for 5 is 18-16+1-0=3
We will also add 18-16+1=3 to notMyTime of 4
Stack - 4/14/3	3/10/0	1/2/0	0/0/4

e so pop
Ans for 4 is 20-14+1-3=4
We will also add 20-14+1=7 to notMyTime of 3
Stack - 3/10/7	1/2/0	0/0/4

e so pop
Ans for 3 is 23-10+1-7=7
We will also add 23-10+1=14 to notMyTime of 1
Stack - 1/2/14	0/0/4

e so pop
Ans for 5 is 18-16+1-0=3
We will also add 18-16+1=3 to notMyTime of 4
Stack - 4/14/3	3/10/0	1/2/0	0/0/4

and so on
 */


import java.util.*;

class Triplet
{
	int id;
	int startTime;
	int notMyTime;
	
	public Triplet(int id, int startTime)
	{
		this.id = id;
		this.startTime = startTime;
		this.notMyTime = 0;
	}
}

public class FunctionTime {

    public static int[] exclusiveTime(int n, ArrayList<String> logs) {
    
    	int result[] = new int [n];
    	Stack<Triplet> S = new Stack<>();
    	
    	for(String str: logs)
    	{
    		int id = str.charAt(0)-'0';
    		char startEnd = str.charAt(2);
    		
    		String starttime = "";
    		
    		for(int j=str.length()-1 ; j>=0 && str.charAt(j)!=':' ; j--)
    		{
    			starttime = str.charAt(j)+starttime;
    		}
    		
    		int startTime = Integer.parseInt(starttime);
    		
    		Triplet Node = new Triplet(id,startTime);
    		
    		if(S.empty() || startEnd=='s')
    		{
    			S.push(Node);
    			continue;
    		}
    		
    		Triplet topNode = S.pop();
    		result[id] = startTime-topNode.startTime+1-topNode.notMyTime;
    		
    		if(!S.empty())
    		{
    			Triplet newTop = S.peek();
    			newTop.notMyTime += startTime-topNode.startTime+1;
    		}
    		
    	}
    	
    	
    	return result;
    }
    
    public static void main(String[] args) 
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int l = s.nextInt();
        
        ArrayList<String> logs = new ArrayList<>();
        
        for(int i=0 ; i<l ; i++)
        {
        	String str = s.next();
        	logs.add(str);
        }
        
        int result[] = exclusiveTime(n,logs);
        
        for(int i=0 ; i<result.length ; i++)
        {
        	System.out.print(result[i]+" ");
        }
        System.out.println();
    }
}