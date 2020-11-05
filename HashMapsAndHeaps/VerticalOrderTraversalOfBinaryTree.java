package HashMapsAndHeaps;

/*
1. You are given a binary tree.
2. You have to write a function that returns the vertical order traversal of its nodes' values. 
(From top to bottom, column-by-column from left to right).
For example:
Input: 
[3,9,8,4,0,1,7,-1,-1,-1,2,5] (0's right child is 2 and 1's left child is 5), (-1 denotes no child)

We will give each node a value

We will first give the root node value zero
Then left child will have value root-1 and right child will have value root+1

Corresponding to these values we will store an array list

 */

import java.util.*;

public class VerticalOrderTraversalOfBinaryTree {
	
	static class Pair
	{
		int level;
		Node root;
	}
   
    public static List<List<Integer>> verticalOrder(Node root) 
    {
    	ArrayList<Integer> keys = new ArrayList<>();
    	Queue<Pair> Q = new LinkedList<>();
    	HashMap<Integer,ArrayList<Integer>> H = new HashMap<>();
    	Pair P = new Pair();
    	P.level=0;
    	P.root = root;
    	Q.add(P);
    	
    	while(!Q.isEmpty())
    	{
    		Pair removed = Q.remove();
    		int level = removed.level;
    		Node temp = removed.root;
    		
    		if(!H.containsKey(level))
    		{
    			ArrayList<Integer> arr = new ArrayList<>();
    			arr.add(temp.data);
    			H.put(level,arr);
    			keys.add(level);
    		}
    		else
    		{
    			ArrayList<Integer> arr = H.get(level);
    			arr.add(temp.data);
    			H.put(level,arr);
    		}
    		
    		if(temp.left!=null)
    		{
    			Pair P1 = new Pair();
    			P1.root = temp.left;
    			P1.level = level-1;
    			Q.add(P1);
    		}
    		
    		if(temp.right!=null)
    		{
    			Pair P1 = new Pair();
    			P1.root = temp.right;
    			P1.level = level+1;
    			Q.add(P1);
    		}
    	}
    	
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	
    	Collections.sort(keys);
    	
    	for(int i=0 ; i<keys.size() ; i++)
    	{
    		int level = keys.get(i);
    		List<Integer> arr = H.get(level);
    		result.add(arr);
    	}
    	
    	return result;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // Taking array input for binary tree.
        int N = scn.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        // Creating binary tree using level order.
        Node root = levelOrder(arr);

        // display(root);

        List<List<Integer>> result = verticalOrder(root);

        // printing the resulting list of lists of integers.
        printList(result);

    }

    // Function for creating a binary tree from an array using level order
    // (seeing it like a heap)
    // The array elements should be non-negative integers, except
    // -1 which denotes that there is no node
    // It returns the root of the tree.
    public static Node levelOrder(int[] arr) {

        Node[] nodes = new Node[arr.length];

        for (int i = 0; i < nodes.length; i++) {
            if (arr[i] != -1) {
                nodes[i] = new Node(arr[i], null, null);

                if (i > 0) {
                    int pi = (i - 1) / 2;

                    if (i == 2 * pi + 1) {
                        nodes[pi].left = nodes[i];
                    } else {
                        nodes[pi].right = nodes[i];
                    }
                }
            }
        }

        Node root = nodes[0];
        return root;
    }

    // Class representing a node of a binary tree.
    private static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    // Function to print a binary tree.
    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";

        str += node.left == null ? "." : node.left.data;
        str += " <= " + node.data + " => ";
        str += node.right == null ? "." : node.right.data;

        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    // Function to print a list of lists of integers.
    public static void printList(List<List<Integer>> list) {
        for (int i = 0; i < list.size(); i++) {

            List<Integer> lst = list.get(i);

            for (int j = 0; j < lst.size(); j++) {
                System.out.print(lst.get(j) + " ");
            }

            System.out.println();
        }
    }

}
