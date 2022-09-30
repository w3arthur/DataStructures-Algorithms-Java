package a1_array;

public class Array {	//dynamic array
	private int[] items;
	private int count;
	private final int ALLOCATE_INCREMENT = 2;
	
	public Array(int length) {	//constructor
		items = new int[length];
		count = 0;
	}
	
	private int[] allocate() {	//increase array size
		int[] newItems = new int[items.length * ALLOCATE_INCREMENT];
		for(int i = 0; i < items.length; ++i) newItems[i] = items[i];
		return newItems;
	}

	

	public void print() {	//o(n)
		for(int i = 0; i < count; ++i) System.out.print(items[i] + " ");
		System.out.println("\ncounter = " + count +  " length = " + items.length);
	}
	public void insert(int value) {	//o(n)
		if(items.length == count) items = allocate();
		items[count] = value;
		count++;
	}
	
	
	private void allocateForRemove(int index) {	//move all array to deleted place
		for (int i = index; i < count; i++) items[i] = items[i + 1];
	}
	
	public void removeAt(int index) {	//o(n)
		if(index >= count || index < 0) throw new IllegalArgumentException();
		if(index != count - 1) allocateForRemove(index);
		count --;
	}
	public int indexOf(int item) {	//o(n)
		for(int i = 0;  i < count ; ++i) if(items[i] == item) return i;
		return -1;
	}

}
