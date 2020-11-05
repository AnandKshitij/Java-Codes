package Stacks;

/*
1. Given n processes, each process has a unique PID (process id) and its PPID (parent process id).
2. Each process only has one parent process, but may have one or more children processes. This is just 
like a tree structure. Only one process has PPID that is 0, which means this process has no parent process. 
All the PIDs will be distinct positive integers.
3. We use two list of integers to represent a list of processes, where the first list contains PID for 
each process and the second list contains the corresponding PPID.
4. Now given the two lists, and a PID representing a process you want to kill, return a list of PIDs 
of processes that will be killed in the end. You should assume that when a process is killed, all its 
children processes will be killed. No order is required for the final answer.

Input Format
First line contains two integers 'N' (total processes) and id of process to be killed.
Second line contains N space separated integers(process ids)
Third line contains N space separated integers(parent process ids)

output Format
Return a list of process ids that will be killed.
*/

/*
In this question if we need to delete a process
Then we have to delete all its children too 
Also we have to delete its children's children & so on

So we want to know children of the ids as quickly as possible

For doing this we can make a hash map of parentId to ArrayList of children
We are taking arrayList because a parent can have more than one child

Step 1: We will add all the processes present in the hash map first
(As it is asked in the question to make such a list)

Step 2: We will add 0 to this list
(as this will give us the info of root node)

Step 3: Traverse pId and ppId 
Use ppId as key 
As pId in the arrayList

Return the arrayList of the deleted elements
 */

import java.util.*;

public class ProcessAndParentId {

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int kill = s.nextInt();
		
		int process[] = new int [N];
		int parentProcess[] = new int [N];
		
		HashMap<Integer,ArrayList<Integer>> H = new HashMap<>();
		
		for(int i=0 ; i<N ; i++)
		{
			process[i] = s.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			H.put(process[i],arr);
		}
		
		H.put(0,new ArrayList<Integer>());
		
		for(int i=0 ; i<N ; i++)
		{
			parentProcess[i] = s.nextInt();
		}
		
		for(int i=0 ; i<N ; i++)
		{
			int parent = parentProcess[i];
			int id = process[i];
			
			ArrayList<Integer> arr = H.get(parent);
			arr.add(id);
		}
		
		ArrayList<Integer> killedProcesses = new ArrayList<>();
		
		Queue<Integer> Q = new LinkedList<>();
		
		Q.add(kill);
		
		while(!Q.isEmpty())
		{
			int killed = Q.remove();
			killedProcesses.add(killed);
			
			ArrayList<Integer> arr = H.get(killed);
			H.remove(killed);
			
			for(int i=0 ; i<arr.size() ; i++)
			{
				Q.add(arr.get(i));
			}
		}
		
		
		Collections.sort(killedProcesses);
		
		System.out.println(killedProcesses);		
	}
}
