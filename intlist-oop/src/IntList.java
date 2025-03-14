import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Each instance of this class stores a sequence of int values.
 */
public class IntList {
	
	private class Node {
		int element;
		Node next;
		
		Node(int element, Node next) {
			this.element = element;
			this.next = next;
		}
	}
	
	private Node getNodeAt(int index) {
		Node result = head;
		while (index > 0) {
			index--;
			result = result.next;
		}
		return result;
	}
	
	/**
	 * @invar | 0 <= size
	 * @invar | IntStream.range(0, size).allMatch(i -> getNodeAt(i) != null)
	 * @invar | getNodeAt(size) == null
	 * 
	 * @representationObjects | IntStream.range(0, size).mapToObj(i -> getNodeAt(i)).toArray()
	 */
	private Node head;
	private int size;
	
	/**
	 * @post | result != null
	 * @creates | result
	 */
	public int[] getElements() {
		int[] result = new int[size];
		Node n = head;
		for (int i = 0; i < size; i++) {
			result[i] = n.element;
			n = n.next;
		}
		return result;
	}
	
	/**
	 * @throws IllegalArgumentException | elements == null
	 * @inspects | elements
	 * @post | Arrays.equals(getElements(), elements)
	 */
	public IntList(int[] elements) {
		if (elements == null)
			throw new IllegalArgumentException("`elements` is null");
		
		size = elements.length;
		Node n = null;
		for (int i = size - 1; 0 <= i; i--)
			n = new Node(elements[i], n);
		head = n;
	}
	
	/**
	 * @mutates | this
	 * @post | getElements().length == old(getElements().length) + 1
	 * @post | Arrays.equals(getElements(), 0, getElements().length - 1, old(getElements()), 0, old(getElements().length))
	 * @post | getElements()[getElements().length - 1] == element
	 */
	public void add(int element) {
		if (size == 0)
			head = new Node(element, null);
		else
			getNodeAt(size - 1).next = new Node(element, null);
		size++;
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
		
		if (size == 1)
			head = null;
		else
			getNodeAt(size - 2).next = null;
		size--;
	}

}
