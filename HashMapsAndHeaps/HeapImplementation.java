package HashMapsAndHeaps;

//we will be implementing min heap
//the value of the parent at each point should be greater than the value of the children

import java.util.*;

public class HeapImplementation {
	
	static class Heap{
		ArrayList<Integer> arr;
		
		public Heap() {
			arr = new ArrayList<>();
		}
		
		public void insert(int data) {
			arr.add(data);
			
			int childIndex = arr.size()-1;
			int parentIndex = (childIndex-1)/2;
			
			while(childIndex!=0 && arr.get(parentIndex)>arr.get(childIndex)) {
				int temp = arr.get(parentIndex);
				arr.set(parentIndex,arr.get(childIndex));
				arr.set(childIndex,temp);
				childIndex = parentIndex;
				parentIndex = (childIndex-1)/2;
			}
		}
		
		public void disp() {
			for(int i=0; i<arr.size(); i++) {
				System.out.print(arr.get(i) + " ");
			}
			System.out.println();
		}
		
		public int delete() {
			if(arr.size()==0) {
				return -1;
			}
			if(arr.size()==1) {
				return arr.remove(0);
			}
			
			int temp1 = arr.get(0);
			int temp2 = arr.get(arr.size()-1);
			
			arr.set(0,temp2);
			
			arr.remove(arr.size()-1);
			
			int parent = 0;
			
			while(parent<arr.size()) {
				
				int child1 = 2*parent+1;
				int child2 = 2*parent+2;
				
				int p = arr.get(parent);
				
				int c1 = Integer.MAX_VALUE;
				int c2 = Integer.MAX_VALUE;
				
				if(child1<arr.size()) {
					c1 = arr.get(child1);
				}
				if(child2<arr.size()) {
					c2 = arr.get(child2);
				}
				
				if(p<c1 && p<c2) {
					break;
				}
				else if(p<c1) {
					arr.set(child2,p);
					arr.set(parent,c2);
					parent = c2;
				}
				else if(p<c2) {
					arr.set(child1,p);
					arr.set(parent,c1);
					parent = c1;
				}
				else {
					if(c1<c2) {
						arr.set(child1,p);
						arr.set(parent,c1);
						parent = c1;
					}
					else {
						arr.set(child2,p);
						arr.set(parent,c2);
						parent = c2;
					}
				}
			}
			
			return temp1;
		}
		
		
	}
	
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Heap H = new Heap();
		H.insert(4);
		H.insert(5);
		H.insert(3);
		H.insert(7);
		H.insert(6);
		H.disp();
		System.out.println(H.delete());
		H.disp();
		H.insert(2);
		H.disp();
		System.out.println(H.delete());
		H.disp();
		s.close();
	}
}
