import java.util.Arrays;

/**
 * Each instance of this class stores a sequence of int values.
 */
public class IntList {
	
	/**
	 * @post | result != null
	 * @creates | result
	 */
	public int[] getElements() { throw new RuntimeException("Not yet implemented"); }
	
	/**
	 * @throws IllegalArgumentException | elements == null
	 * @inspects | elements
	 * @post | Arrays.equals(getElements(), elements)
	 */
	public IntList(int[] elements) {
		if (elements == null)
			throw new IllegalArgumentException("`elements` is null");
		
		throw new RuntimeException("Not yet implemented");
	}
	
	/**
	 * @mutates | this
	 * @post | getElements().length == old(getElements().length) + 1
	 * @post | Arrays.equals(getElements(), 0, getElements().length - 1, old(getElements()), 0, old(getElements().length))
	 * @post | getElements()[getElements().length - 1] == element
	 */
	public void add(int element) { throw new RuntimeException("Not yet implemented"); }
	
	/**
	 * @throws IllegalStateException | getElements().length == 0
	 * @mutates | this
	 * @post | getElements().length == old(getElements().length) - 1
	 * @post | Arrays.equals(getElements(), 0, getElements().length, old(getElements()), 0, old(getElements().length) - 1)
	 */
	public void removeLast() {
		if (getElements().length == 0)
			throw new IllegalStateException("The sequence of elements is empty.");
		
		throw new RuntimeException("Not yet implemented");
	}

}
