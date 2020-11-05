package DynamicProgramming;

/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
*/

import java.util.*;

public class WordBreak {
	
	public static void disp(boolean[][] dp) {
		for(int i=0;  i<dp.length; i++) {
			for(int j=0; j<dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static boolean wordBreak(String str, List<String> wordDict) {
		int n = str.length();
		
		boolean dp[][] = new boolean [n][n];
		
		HashSet<String> H = new HashSet<>();
		
		for(int i=0; i<wordDict.size(); i++) {
			H.add(wordDict.get(i));
		}
		
		for(int i=0; i<n; i++) {
			String check = str.charAt(i)+"";
			if(H.contains(check)) {
				dp[i][i] = true;
			}
		}
		
		for(int i=1; i<n; i++) {
			int row = 0;
			int col = i;
			
			while(row<n && col<n) {
				String toCheck = str.substring(row,col+1);
				if(H.contains(toCheck)) {
					dp[row][col] = true;
					row++;
					col++;
					continue;
				}
				
				int currCol = row;
				int currRow = row+1;
				
				while(currCol<col) {
					if(dp[row][currCol] && dp[currRow][col]) {
						dp[row][col] = true;
						break;
					}
					currCol++;
					currRow++;
				}
				row++;
				col++;
			}
			
		}
		
		disp(dp);
		
		return dp[0][n-1];
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String S = s.next();
		int n = s.nextInt();
		List<String> arr = new ArrayList<>();
		for(int i=0; i<n; i++) {
			arr.add(s.next());
		}
		System.out.println(wordBreak(S,arr));
		s.close();
	}

}
