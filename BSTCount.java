import java.util.function.BiPredicate;
import java.util.function.ToIntBiFunction;

public class BSTCount {
	private BSTNode root;
	
	/* 
	 * Creates an empty tree that consists just of a single empty node
	 * 
	 */
	public BSTCount() { 
		this.root = EmptyBSTNode.UNIQUE_INSTANCE;
	}
	
	/*
	 * The method takes a word and updates the tree accordingly:
	 * If the word already occurs in the tree, its count gets incremented.
	 * If it doesn't occur in the tree, it is added according to the 
	 * binary search order.
	 */
	public void add(String word) {
		// If the tree is still empty:
		if (root == EmptyBSTNode.UNIQUE_INSTANCE) {
			this.root = new NonEmptyBSTNode(word);
		} else {
			BSTNode current = root;
			// The loop finds the position for the word.
			// It stops when current points to the node containing the 
			// word. 
			// If the word is not found, it is added to the tree and 
			// the method returns

			// While the current word isn't equal to the word we're adding. 
			// Once the current word is equal then the loop is over and we increment count.
			while (!word.equals(current.getWord())){ 
				if (word.compareTo(current.getWord()) < 0) {
					if (current.getLeft() == EmptyBSTNode.UNIQUE_INSTANCE) {
						current.addWordLeft(word);
						return;
					} else {
						current = current.getLeft();
					}
				} else {
					if (current.getRight() == EmptyBSTNode.UNIQUE_INSTANCE) {
						current.addWordRight(word);
						return;
					} else {
						current = current.getRight();
					}
				}
			}
			current.incrementCount();
		}
	}
	
	/*
	 * The method starts recursion on the root of the tree to 
	 * get the count for a word. 
	 * If the word doesn't occur in the tree, 0 is returned.
	 */
	public int getCount(String word) {
		return root.getCount(word);
	}
	
	/*
	 * The method prints nodes whose word and count satisfy the 
	 * condition in the selector, i.e. for which selector.test(word, count)
	 * returns true. 
	 * The method starts the recursive process by calling the inOrderRec 
	 * and passing the root to it. 
	 */
	public void inOrder(BiPredicate<String,Integer> selector) {
		inOrderRec(root, selector);
	}
	
	/*
	 * A recursive in-order tree traversal that prints elements that satisfy
	 * the predicate in selector
	 */
	private void inOrderRec(BSTNode node, BiPredicate<String,Integer> selector) {
		// Fill in the code according to the description
		// Hint: use selector.test(...) to call the selector function. 
		// It returns a boolean (according to the BiPredicate interface) 
		// which determines whether the data in the node should be printed or not. 
		if(node != EmptyBSTNode.UNIQUE_INSTANCE){
			inOrderRec(node.getLeft(), selector);

				if(selector.test(node.getWord(), node.getCount()))
					System.out.println(node.getWord() + ": " + Integer.toString(node.getCount()));

			inOrderRec(node.getRight(), selector);
		}	
	}

	public int computeRec(BSTNode node, ToIntBiFunction<String,Integer> selector){
			int sum = 0;
		
		if(node != EmptyBSTNode.UNIQUE_INSTANCE){
			computeRec(node.getLeft(), selector);
				sum += selector.applyAsInt(node.getWord(), node.getCount());
			computeRec(node.getRight(), selector);
		}
		return sum;
	}

	public void compute(ToIntBiFunction<String,Integer> selector) {
		computeRec(root, selector);
	}
	
}
