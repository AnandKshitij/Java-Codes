package binaryTree;

import java.util.*;

public class NodesAtDistanceK {
	
	static class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int data) {
			this.data = data;
		}
	}
	
	static class BinaryTree{
		TreeNode root;
		
		public BinaryTree(TreeNode root) {
			this.root = root;
		}
		
		public void printBinaryTree() {
			System.out.println(root.data);
			helperPrint(root);
		}
		public void helperPrint(TreeNode n) {
			if(n==null) {
				return ;
			}
			System.out.println(n.data);
			helperPrint(n.left);
			helperPrint(n.right);
		}
		
		public TreeNode search(int data, TreeNode n){
			if(n==null) {
				return n;
			}
			if(n.data==data) {
				return n;
			}
			
			TreeNode n1 = search(data,n.left);
			if(n1!=null) {
				return n1;
			}
			
			TreeNode n2 = search(data,n.right);
			if(n2!=null) {
				return n2;
			}
			
			return null;
		}
		
		List<Integer> arr = new ArrayList<>();
		
		public void kDown(TreeNode root, int k, TreeNode block) {
			if(root==null || root==block || k<0) {
				return ;
			}
			if(k==0) {
				arr.add(root.data);
				return ;
			}
			
			kDown(root.left,k-1,block);
			kDown(root.right,k-1,block);
		}
		
		static int distance = 0;
		
		public boolean helperKDistance(TreeNode root, TreeNode target, int k) {
			if(root==null) {
				return false;
			}
			if(root==target) {
				kDown(root,k,null);
				distance++;
				return true;
			}
			
			if(helperKDistance(root.left,target,k)==true) {
				kDown(root,k-distance,root.left);
				distance++;
				return true;
			}
			
			if(helperKDistance(root.right,target,k)==true) {
				kDown(root,k-distance,root.right);
				distance++;
				return true;
			}
			return false;
		}
		
		public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
			helperKDistance(root,target,K);
			return arr;
	    }
		
		public void getNodesAtDistanceK(int data, int K) {
			TreeNode target = search(data,root);
			List<Integer> arr = distanceK(root,target,K);
			for(int i : arr) {
				System.out.println(i);
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		TreeNode T = new TreeNode(n);

		BinaryTree tree = new BinaryTree(T);
		Queue<TreeNode> Q = new LinkedList<>();
		Q.add(T);
		while(Q.size()>0) {
			TreeNode tmp  = Q.remove();
			int left = s.nextInt();
			int right = s.nextInt();
			if(left!=-1) {
				TreeNode leftNode = new TreeNode(left);
				tmp.left = leftNode;
				Q.add(leftNode);
			}
			if(right!=-1) {
				TreeNode rightNode = new TreeNode(right);
				tmp.right = rightNode;
				Q.add(rightNode);
			}
		}
		tree.printBinaryTree();
		
		int data = s.nextInt();
		int k = s.nextInt();
		tree.getNodesAtDistanceK(data, k);
	}
}
