import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IntListTest {
	
	int[] myInitArray = {10, 20, 30};
	IntList myIntList = new IntList(myInitArray);

	@Test
	void testConstructor() {
		assertEquals(new int[] {10, 20, 30}, myIntList.getElements());
	}
	
	@Test
	void testAdd() {
		myIntList.add(40);
		assertEquals(new int[] {10, 20, 30, 40}, myIntList.getElements());
	}
	
	@Test
	void testRemoveLast() {
		myIntList.removeLast();
		assertEquals(new int[] {10, 20}, myIntList.getElements());
	}

}
