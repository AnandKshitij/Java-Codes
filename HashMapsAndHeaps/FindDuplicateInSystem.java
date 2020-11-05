package HashMapsAndHeaps;

/*
1.Given a list of directory info including directory path, and all the files with contents in this directory, 
you need to find out all the groups of duplicate files in the file system in terms of their paths.
A group of duplicate files consists of at least two files that have exactly the same content.

2.A single directory info string in the input list has the following format:
"root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)"
It means there are n files (f1.txt, f2.txt ... fn.txt with content f1_content, f2_content ... fn_content, 
respectively) in directory root/d1/d2/.../dm. Note that n >= 1 and m >= 0. If m = 0, it means the directory 
is just the root directory.
3.The output is a list of group of duplicate file paths. For each group, it contains all the file paths of 
the files that have the same content. A file path is a string that has the following format:
"directory_path/file_name.txt".
4. Use Tree map instead of Hash map.
4. Return your answer as ArrayList of ArrayList of string.
5. Input and output is handled for you.
6. It is a functional problem ,please do not modify main().
 */

/*
Sample Input
4
root/a 1.txt(abcd) 2.txt(efgh)
root/c 3.txt(abcd)
root/c/d 4.txt(efgh)
root 4.txt(efgh)
Sample Output
[root/a/2.txt, root/c/d/4.txt, root/4.txt]
[root/a/1.txt, root/c/3.txt]

We will need stack and hash map for its implementation

Hash map will be 
String, ArrayList<String>

To get the string like abcd, efgh we will need stack

The string within the brackets will be our key and the remaining string will be value

Dry run for
root/a 1.txt(abcd) 2.txt(efgh)

We will read elements one by one 
Stack will move smoothly till space
Stack - root/a

When we get space
We check is space variable 
Which is initially false
Now we make it true
And we add it to stack
Stack - root/a' '

Now we get 1.txt
We add it to the stack
Stack - root/a' '1.txt

Now we get (
Stack - root/a' '1.txt(

Now we get abcd
Stack - root/a' '1.txt(abcd

Now we get )
We pop all elements till )
And this becomes our key
Key - abcd
Stack - root/a' '1.txt

Now the value left in the stack is our value
We will add it to the arrayList
We will read ' ' as /

Now we get another space
isSpace is true
So we pop all elements till previous space
Then we push our current space 
And proceed as earlier


 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FindDuplicateInSystem {
	
	 public static ArrayList<ArrayList<String>> findDuplicate(String[] paths) {
		 
		 HashMap<String,Integer> H = new HashMap<>();
		 ArrayList<ArrayList<String>> result = new ArrayList<>();
		 
		 int index = 0;
		 
		 for(int k=0 ; k<paths.length ; k++)
		 {
			 String path = paths[k];
			 
			 Stack<Character> S = new Stack<>();
			 boolean isSpace = false;
			 
			 for(int i=0 ; i<path.length() ; i++)
			 {
				 char ch = path.charAt(i);
				 
				 if(ch==' ')
				 {
					if(!isSpace)
					{
						S.push(ch);
						isSpace = true;
					}
					else
					{
						while(!S.empty() && S.peek()!=' ')
						{
							S.pop();
						}
						if(!S.empty())
						{
							S.pop();
						}
						S.push(ch);
					}
				 }
				 else if(ch==')')
				 {
					 String key = "";
					 
					 while(!S.empty() && S.peek()!='(')
					 {
						 char temp = S.pop();
						 key = temp+key;
					 }
					 S.pop();
					
					 String value = "";
					 
					 Stack<Character> S2 = new Stack<>();
					 
					 while(!S.empty())
					 {
						 char temp = S.pop();
						 
						 if(temp==' ')
						 {
							 value = '/' + value;
						 }
						 else
						 {
							 value = temp + value;
						 }
						 
						 S2.push(temp);
					 }
					 
					 while(!S2.empty())
					 {
						 S.push(S2.pop());
					 }
					 
					 if(!H.containsKey(key))
					 {
						 ArrayList<String> arr = new ArrayList<>();
						 arr.add(value);
						 H.put(key,index);
						 result.add(index,arr);
						 index++;
					 }
					 else
					 {
						 int ourIndex = H.get(key);
						 ArrayList<String> arr = result.get(ourIndex);
						 arr.add(value);
						 result.set(ourIndex,arr);
					 }
				 }
				 else
				 {
					 S.push(ch);
				 }
			 }
		 }
		 
		 //now we have our answer in result
		 //but we want the result in lexicographical order
		 //we have to store the keys in lexicographical order
		 //the array corresponding to the keys have already been sorted in main
		 //for doing this we take finalResult 
		 
		 ArrayList<String> arr = new ArrayList<String>();
		 
		 for(String str : H.keySet())
		 {
			 arr.add(str);
		 }
		 
		 Collections.sort(arr);
		 
		 ArrayList<ArrayList<String>> finalResult = new ArrayList<>();
		 
		 for(int i=0 ; i<arr.size() ; i++)
		 {
			 String key = arr.get(i);
			 int temp = H.get(key);
			 ArrayList<String> toAdd = result.get(temp);
			 finalResult.add(i,toAdd);
		 }
		 
		 return finalResult;
	 }

	 public static void main(String[] args) throws NumberFormatException, IOException
	 {
	 	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 	 int n = Integer.parseInt(br.readLine());
	 	 String[] paths = new String[n];

	 	 for (int i = 0; i < n; i++) {
	 	 	 paths[i] = br.readLine();
	 	 }
	 	 ArrayList<ArrayList<String>> ans = findDuplicate(paths);
	 	 for (ArrayList<String> val : ans) {
	 	 	 Collections.sort(val);
	 	 }

	 	 for (ArrayList<String> val : ans) {
	 	 	 System.out.println(val);
	 	 }
	 }
}