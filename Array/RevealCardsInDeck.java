package Array;

/*
1.In a deck of cards, every card has a unique integer. You can order the deck in any order you want.
You will be give an array of n size which contains the cards ,you have to return the rearranged deck

2. Initially, all the cards start face down (unrevealed) in one deck.

3. Now, you do the following steps repeatedly, until all cards are revealed:

a. Take the top card of the deck, reveal it, and take it out of the deck.
b. If there are still cards in the deck, put the next top card of the deck at the bottom of the deck.
c. If there are still unrevealed cards, go back to step 1. Otherwise, stop.

[17,13,11,2,3,5,7]

4. Return an ordering of the deck that would reveal the cards in increasing order.

5. The first entry in the answer is considered to be the top of the deck.
*/


import java.util.*;

public class RevealCardsInDeck {

	 public static void deckRevealedIncreasing(int[] deck) {
		 
		 Arrays.sort(deck);
		 
		 Queue<Integer> Q = new LinkedList<>();
		 
		 for(int i=0; i<deck.length; i++){
			 Q.add(i);
		 }
		 
		 int index[] = new int [deck.length];
		 int j=0;
		 
		 while(Q.size()>1){
			 
			 index[j++] = Q.remove();
			 Q.add(Q.remove());
		 }
		 
		 index[j] = Q.remove();
		 
		 int result [] = new int [deck.length];
		 
		 for(int i=0; i<result.length; i++)
		 {
			 int valToPut = deck[i];
			 int indexToPut = index[i];
			 result[indexToPut] = valToPut;
		 }
		 
		 for(int i=0; i<result.length; i++){
			 System.out.print(result[i] + " ");
		 }
	 }

	 public static void main(String[] args) {
	 	 Scanner sc = new Scanner(System.in);

	 	 int n = sc.nextInt();
	 	 int[] arr = new int[n];
	 	 for (int i = 0; i < n; i++) {
	 	 	 arr[i] = sc.nextInt();
	 	 }

	 	 deckRevealedIncreasing(arr);
	 	 
	 	 }
	 }
