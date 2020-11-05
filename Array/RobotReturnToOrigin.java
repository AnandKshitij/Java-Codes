package Array;

/*
1.There is a robot starting at position (0, 0), the origin, on a 2D plane.
2.Given a sequence of its moves, judge if this robot ends up at (0, 0) after it completes its moves.
3.The move sequence is represented by a string, and the character moves[i] represents its ith move.
4.Valid moves are R (right), L (left), U (up), and D (down). If the robot returns to the origin after it finishes all of its moves, 
return true.
Otherwise, return false.
*/


import java.util.*;

public class RobotReturnToOrigin {

	 public static boolean judgeCircle(String s) {
		 
		 int row=0, col=0;
		 
		 for(int i=0; i<s.length(); i++) {
			 char ch = s.charAt(i);
			 
			 if(ch=='R') {
				 col++;
			 }
			 else if(ch=='L') {
				 col--;
			 }
			 else if(ch=='U') {
				 row--;
			 }
			 else if(ch=='D') {
				 row++;
			 }
		 }
		 
		 if(row==0 && col==0) {
			 return true;
		 }
		 
		 return false;
	 }

	 public static void main(String[] args) {

	 	 Scanner s = new Scanner(System.in);
	 	 String str = s.nextLine();
	 	 System.out.println(judgeCircle(str));

	 }
}