package HashMapsAndHeaps;

/*
1. You are given an array of Strings.
2. You have to write a function that groups all anagrams together.
3. For example:
Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
["ate","eat","tea"],
["nat","tan"],
["bat"]
]
4. If two words are anagrams but the case is different, they should not be grouped together. For example, "ABC" should not be grouped with "CbA".
5. The order of your output does not matter.
6. main takes input a String array from the users.
7. This is a functional problem. 
8. You have to complete the groupAnagrams function. It takes as input a String array. It return a list of list of strings of anagrams grouped together.
9. Don't change the code of main.
 */


import java.util.*;

public class AnagramGroup
{
    public static List<List<String>> groupAnagrams(String[] strs) {
        
    	HashMap<String,ArrayList<Integer>> H = new HashMap<>();
    	
    	for(int i=0; i<strs.length; i++){
    		 String str = strs[i];
    		 char[] temp = str.toCharArray();
    		 Arrays.sort(temp);
    		 String S = new String(temp);
    		 
    		 if(!H.containsKey(S)){
    			 ArrayList<Integer> arr = new ArrayList<>();
    			 arr.add(i);
    			 H.put(S,arr);
    		 }
    		 else{
    			 ArrayList<Integer> arr = H.get(S);
    			 arr.add(i);
    			 H.put(S,arr);
    		 }
    	}
    	
    	List<List<String>> result = new ArrayList<>();
    	
    	for(String S : H.keySet())
    	{
    		ArrayList<Integer> arr = H.get(S);
    		ArrayList<String> toAdd = new ArrayList<>();
    		
    		for(int i=0 ; i<arr.size(); i++)
    		{
    			int index = arr.get(i);
    			String T = strs[index];
    			toAdd.add(T);
    		}
    		
    		result.add(toAdd);
    	}
    	
    	return result;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Length of the array
        int N = sc.nextInt();

        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.next();
        }

        List<List<String>> anagramsGrouped = groupAnagrams(arr);

        for (List<String> lst : anagramsGrouped) {
            Collections.sort(lst);
        }

        anagramsGrouped.sort(new ListComparator());

        display(anagramsGrouped);

    }
    
    static class ListComparator implements Comparator<List<String>> {

        @Override
        public int compare(List<String> l1, List<String> l2) {

            if (l1.size() != l2.size()) {
                return l2.size() - l1.size();
            }

            for (int i = 0; i < l1.size(); i++) {
                String l1str = l1.get(i);
                String l2str = l2.get(i);

                return l1str.compareTo(l2str);

            }

            return 0;

        }
    }
    
    public static void display(List<List<String>> list) {

        for (int i = 0; i < list.size(); i++) {

            List<String> currList = list.get(i);

            for (int j = 0; j < currList.size(); j++) {
                System.out.print(currList.get(j) + " ");
            }

            System.out.println();
        }

    }

}