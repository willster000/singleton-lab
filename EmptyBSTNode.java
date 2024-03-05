
public enum EmptyBSTNode implements BSTNode {
	UNIQUE_INSTANCE;
	/*
	 * You can specify any form of handling errors: logging,
	 * throwing a specific exception (rather than just a null pointer), etc. 
	 */

	@Override
	/*
	 * Returns 0 since there is no string associated with an empty node
	 */
	public int getCount(String s) {
		return 0;
	}

	@Override
	public int getCount() {
		return 0;
	}

	@Override
	public String getWord() {
		System.out.println("ERROR: accessing empty node");
		return null; // no word to return
	}

	@Override
	public BSTNode getLeft() {
		throw new UnsupportedOperationException("An empty node doesn't have a left");
	}

	@Override
	public BSTNode getRight() {
		throw new UnsupportedOperationException("An empty node doesn't have a right");
	}

	@Override
	public void addWordLeft(String word) {
		throw new UnsupportedOperationException("Can't addWordLeft on empty node");
	}

	@Override
	public void addWordRight(String word) {
		throw new UnsupportedOperationException("Can't addWordRight on empty node");
	}

	@Override
	public void incrementCount() {
		throw new UnsupportedOperationException("Unimplemented method 'incrementCount'");
	}

	// Add other missing methods 

}
