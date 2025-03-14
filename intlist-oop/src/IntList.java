import java.util.Arrays;

/**
 * Each instance of this class stores a sequence of int values.
 */
public class IntList {
	
	/**
	 * @invar | elements != null
	 * 
	 * @representationObject
	 */
	private int[] elements;
	
	/**
	 * @post | result != null
	 * @creates | result
	 */
	public int[] getElements() { return elements.clone(); }
	
	/**
	 * @throws IllegalArgumentException | elements == null
	 * @inspects | elements
	 * @post | Arrays.equals(getElements(), elements)
	 */
	public IntList(int[] elements) {
		if (elements == null)
			throw new IllegalArgumentException("`elements` is null");
		
		this.elements = elements.clone();
	}
	
	/**
	 * @mutates | this
	 * @post | getElements().length == old(getElements().length) + 1
	 * @post | Arrays.equals(getElements(), 0, getElements().length - 1, old(getElements()), 0, old(getElements().length))
	 * @post | getElements()[getElements().length - 1] == element
	 */
	public void add(int element) {
		this.elements = Arrays.copyOf(this.elements, this.elements.length + 1);
		this.elements[this.elements.length - 1] = element;
		
//		int[] newElements = new int[elements.length + 1];
//		for (int i = 0; i < elements.length; i++)
//			newElements[i] = elements[i];
//		newElements[elements.length] = element;
//		this.elements = newElements;
	}
	
	/**
	 * @throws IllegalStateException | getElements().length == 0
	 * @mutates | this
	 * @post | getElements().length == old(getElements().length) - 1
	 * @post | Arrays.equals(getElements(), 0, getElements().length, old(getElements()), 0, old(getElements().length) - 1)
	 */
	public void removeLast() {
		if (getElements().length == 0)
			throw new IllegalStateException("The sequence of elements is empty.");
		
		this.elements = Arrays.copyOf(this.elements, this.elements.length - 1);
	}

}
