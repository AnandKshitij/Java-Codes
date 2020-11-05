package binaryTree;

/*
1. You are given a binary tree and a number K. 
2. You have to find sum of the nodes of the tree at level K. 
3. The Binary Tree is given in string form: (node-value(left-subtree)(right-subtree)).
4. For example, 
Input:
2 
(0(5(6()())(4()(9()())))(7(1()())(3()())))

Output: 
14

Explaination:
The Tree from the above String will be formed as:
Level 0: 0
/ 
/ 
Level 1: 5 7
/ / 
/ / 
Level 2: 6 4 1 3

Level 3: 9 

Notes:
1. Every node has value between 0 and 100.
2. You have to take input in the given format and print the output in the required format.

*/

import java.util.*;

public class SumOfNodesAtLevelK {
	
	public static int getLevelKSum(int k, String tree) {
		int level = -1;
		int sum = 0;
		
		int i=0;
		while(i<tree.length()) {
			char ch = tree.charAt(i);
			
			if(ch=='(') {
				level++;
				i++;
				continue;
			}
			if(ch==')') {
				level--;
				i++;
				continue;
			}
			
			if(level==k) {
				String str = "";
				str += ch;
				i++;
			
				while(i<tree.length() && tree.charAt(i)>='0' && tree.charAt(i)<='9') {
					str += tree.charAt(i);
					i++;
				}
			
				sum += Integer.parseInt(str);
			}
			
			else {
				i++;
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int k = s.nextInt();
		String tree = s.next();
		System.out.println(getLevelKSum(k,tree));
		s.close();
	}
}
