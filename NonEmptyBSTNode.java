
public class NonEmptyBSTNode implements BSTNode {
	private String word;
	private int count;
	private BSTNode left = EmptyBSTNode.UNIQUE_INSTANCE;
	private BSTNode right= EmptyBSTNode.UNIQUE_INSTANCE;
	
	public NonEmptyBSTNode(String word) {
		this.word = word;
		this.count = 1;
		// Fill in the constructor code. Note that the left and 
		// the right references are already set to empty nodes
	}
	
	@Override
	/*
	 * The method looks for a string in the BST at this node or below it
	 * and returns the associated count. 
	 * It uses compareTo to determine which side to search and makes
	 * a recursive call.  
	 * If the string is not found, 0 is returned. 
	 *
	 * Note: since an empty node is a BSTNode, there is no need to check
	 * for an empty node: it will automatically return a correct count. 
	 */
	public int getCount(String word) {
		if(this.count == 0 || this.word.equals(word)){
			return this.count;
		} else if (this.word.compareTo(word) < 0){ // compareTo returns negative if this.word < word
			return right.getCount(word);
		} else 
			return left.getCount(word); // this.word >= word, search left.
	}

	public String getWord() {
		return word;
	}
	
	public void incrementCount() {
		count++;
	}

	@Override
	public BSTNode getLeft() {
		return left;
	}

	@Override
	public BSTNode getRight() {
		return right;
	}

	@Override
	/*
	 * Creates a new non-empty node with the word in it and sets
	 * its left to point to that node
	 */
	public void addWordLeft(String word) {
		// fill in the code according to the description
		this.left = new NonEmptyBSTNode(word);
	}

	@Override
	/*
	 * Creates a new non-empty node with the word in it and sets
	 * its right to point to that node
	 */
	public void addWordRight(String word) {
		// fill in the code according to the description
		this.right = new NonEmptyBSTNode(word);
	}

	@Override
	public int getCount() {
		return count;
	}



}
