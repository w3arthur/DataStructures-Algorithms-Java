package b3_heap;

import java.util.Arrays;

public class Heap {
	private int[] items;
	private int size;
	
	public Heap() {
		items = new int[10];
		size = 0;
	}
	
	private boolean isFull() { return size == items.length; }
	public boolean isEmpty() { return size == 0; }
	private int parent(int index) { return (index - 1) / 2; }
	private void swap(int first, int second) {
		var temp = items[first];
		items[first] = items[second];
		items[second] = temp;
	}
	
	public void insert(int value) {
		if(isFull()) throw new IllegalStateException();
		items[size] = value;
		size ++;
		bubbleUp();
	}
	private void bubbleUp() {
		var index = size - 1; //0 <= 1
		while(index > 0 && items[index] > items[parent(index)]) {
			swap(index, parent(index));
			index = parent(index);	//decrees index
		}
	}
	
	public int remove() {
		if(isEmpty()) throw new IllegalStateException();
		int tmp = items[0];
		items[0] = items[size - 1];
		size --;
		bubbleDown();
		return tmp;
	}
	private void bubbleDown() {
		var index = 0;
		while(index <= size && !isValidParant(index) ) {
			var largerChildIndex = largerChildIndex(index);
			swap(index, largerChildIndex);
			index = largerChildIndex;
		}
	}
	
	private boolean hasLeftChild(int index) { return leftChildIndex(index) <= size; }
	private boolean hasRightChild(int index) { return rightChildIndex(index) <= size; }
	private int largerChildIndex(int index){
        if (hasLeftChild(index) && hasRightChild(index))
        {
            if (leftChild(index) > rightChild(index)) return leftChildIndex(index);
            else return rightChildIndex(index);
        }
        else if (hasLeftChild(index) && !hasRightChild(index)) return leftChildIndex(index);
        else return index;
	}
	private boolean isValidParant(int index) { 
        var isValidLeft = items[index] >= leftChild(index);
        var isValidRight = items[index] >= rightChild(index);
        if (hasLeftChild(index) && hasRightChild(index)) return isValidLeft && isValidRight;
        if (hasLeftChild(index) && !hasRightChild(index)) return isValidLeft;
        /*if (!HasLeftChild(index))*/ return true;
	}
	
	private int leftChildIndex(int index) { return index * 2 + 1; }
	private int rightChildIndex(int index) { return index * 2 + 2; }
	private int leftChild(int index) { return items[leftChildIndex(index)]; }
	private int rightChild(int index) { return items[rightChildIndex(index)]; }

	public int max() {
		if(isEmpty())  throw new IllegalStateException();
		return items[0];
	}
	
	@Override
	public String toString() { return Arrays.toString(Arrays.copyOfRange(items, 0, size)); }
}
