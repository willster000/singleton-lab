import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.function.BiPredicate; 

public class TestBST {

	public static void main(String[] args) throws FileNotFoundException {
		BSTCount wordCounts = new BSTCount();
		
		/*
		 * Reading data from a file word-by-word by specifying spaces as a delimiter
		 */
		Scanner sc = new Scanner(
			new File("data.txt")).useDelimiter("\\s");
		while (sc.hasNext()) {
			String s = sc.next();
			// removing all non-letter characters by replacing them with ""
			s = s.replaceAll("[^a-zA-Z]", "");
			// if the resulting string is non-empty, add it to the BST
			// You may start by trying out just printing it
			if(!s.equals(""))
			wordCounts.add(s);
		}

		wordCounts.add("Hi");
		wordCounts.add("Hi");
		
		System.out.println("Winnie: " + wordCounts.getCount("Winnie"));
		System.out.println("Winnie-the-Pooh: " + wordCounts.getCount("Winnie-the-Pooh"));
		System.out.println("WinniethePooh: " + wordCounts.getCount("WinniethePooh"));
		System.out.println("Lenovo laptop: " + wordCounts.getCount("Lenovo laptop"));
		System.out.println("Hurricane-tortilla: " + wordCounts.getCount("Hurricane-tortilla"));
		
		
		wordCounts.inOrder((s,n)-> true); // print all words and counts
		wordCounts.inOrder((s,n)-> (n >= 5)); // print only nodes with counts >= 5
		// Add: print nodes with the words longer than 5 letters
		wordCounts.inOrder((s,n)-> s.length() > 5);
		// Add another call to inOrder using "and", "or", or "negate"
		BiPredicate<String, Integer> longPredicate = (s,n)-> {
			return s.length() > 5;
		};

		BiPredicate<String, Integer> frequentPredicate = (s,n)-> {
			return n >= 5;
		};

		BiPredicate<String,Integer> longAndFrequent = longPredicate.and(frequentPredicate);
		System.out.println("Four score and seven years ago...");
		wordCounts.inOrder(longAndFrequent);

		BiPredicate<String,Integer> longOrFrequent = longPredicate.or(frequentPredicate);
		System.out.println("Four score and seven years ago...");
		wordCounts.inOrder(longOrFrequent);

		BiPredicate<String,Integer> notLong = longPredicate.negate();
		System.out.println("I want to go to the hut.");
		wordCounts.inOrder(notLong);
		
		// Add a method "compute" to BSTCount. The method also performs an in-order traversal
		// recursively. 
		// It takes a lambda function that takes two parameters (a string and an integer)
		// and returns an int.
		// The function implements the following interface:
		// https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/util/function/ToIntBiFunction.html
		
		// After you implement the traversal function, use it to:
		// 1. Find the sum of all counts of words.
		wordCounts.compute((s,n)-> n);
		// 2. Find the sum of the lengths of all words.
		wordCounts.compute((s,n)-> s.length());
		// 3. Find the longest word
		wordCounts.compute((s,n)-> {
			if(s.length() > n)
				return s.length();
			else
				return n;
		});	
	}
}
