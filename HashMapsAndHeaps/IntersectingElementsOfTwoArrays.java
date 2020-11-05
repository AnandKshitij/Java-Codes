package HashMapsAndHeaps;

/*
1. You will be given twp Arrays and their length.
2. You need to find their intersection and return those elements in a new array.
4. Return empty array if no intersecting element.
5. Input and output is handled for you
6. It is a functional problem ,please do not modify main()

NOTE:
Each element in the resultant array should appear as many times as it intersects in both arrays
The result can be in any order.
 */


import java.util.*;

public class IntersectingElementsOfTwoArrays{

	 public static int[] intersect(int[] nums1, int[] nums2) {
	     
		 ArrayList<Integer> result = new ArrayList<>();
		 
		 HashMap<Integer,Integer> H = new HashMap<>();
		 
		 for(int i=0; i<nums1.length; i++)
		 {
			 int key = nums1[i];
			 
			 if(!H.containsKey(key))
			 {
				 H.put(key,1);
			 }
			 else
			 {
				 H.put(key,H.get(key)+1);
			 }
		 }
		 
		 for(int j=0; j<nums2.length; j++)
		 {
			 int key = nums2[j];
			 
			 if(H.containsKey(key))
			 {
				 result.add(key);
				 int freq = H.get(key);
				 freq--;
				 H.put(key,freq);
				 if(freq==0)
				 {
					 H.remove(key);
				 }
			 }
		 }
		 
		 int ans[] = new int [result.size()];
		 
		 for(int i=0; i<result.size(); i++)
		 {
			 ans[i] = result.get(i);
		 }
		 
		 return ans;
		 
	 }
	 
    public static void main(String[] args){
        Scanner scn= new Scanner(System.in);
        int n=scn.nextInt();
        int[] nums1= new int[n];
        for(int i=0;i<n;i++){
            nums1[i]=scn.nextInt();
        }
        int m= scn.nextInt();
        int[] nums2= new int[m];
        for(int i=0;i<m;i++){
            nums2[i]=scn.nextInt();
        }
        int[] res=intersect(nums1, nums2);
        for(int i=0;i<res.length;i++)
            System.out.print(res[i]+" ");
    }
}
