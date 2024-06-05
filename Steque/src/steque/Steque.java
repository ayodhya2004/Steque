package steque;


import java.util.NoSuchElementException;

	public class Steque<Item> {
	    private Item[] array;
	    private int size;
	    private int capacity;

	  
	    @SuppressWarnings("unchecked")
		public Steque() {
	        capacity = 10; // initial capacity
	        array = (Item[]) new Object[capacity];
	        size = 0;
	    }

	    
	    public boolean isEmpty() {
	        return size == 0;
	    }

	   
	    public int size() {
	        return size;
	    }

	    
	    private void resize(int newCapacity) {
	        @SuppressWarnings("unchecked")
	        Item[] newArray = (Item[]) new Object[newCapacity];
	        for (int i = 0; i < size; i++) {
	            newArray[i] = array[i];
	        }
	        array = newArray;
	        capacity = newCapacity;
	    }

	   
	    public void push(Item item) {
	        if (size == capacity) {
	            resize(2 * capacity); // double the capacity if needed
	        }
	        for (int i = size; i > 0; i--) {
	            array[i] = array[i - 1];
	        }
	        array[0] = item;
	        size++;
	    }

	    // Enqueue an item at the end of the steque (queue operation)
	    public void enqueue(Item item) {
	        if (size == capacity) {
	            resize(2 * capacity); // double the capacity if needed
	        }
	        array[size++] = item;
	    }

	    // Pop an item from the steque (stack operation)
	    public Item pop() {
	        if (isEmpty()) {
	            throw new NoSuchElementException("Steque underflow");
	        }
	        Item item = array[0];
	        for (int i = 0; i < size - 1; i++) {
	            array[i] = array[i + 1];
	        }
	        size--;
	        array[size] = null; // avoid loitering
	        if (size > 0 && size == capacity / 4) {
	            resize(capacity / 2); // shrink the array if necessary
	        }
	        return item;
	    }

	    public void printSteque() {
	        for (int i = 0; i < size; i++) {
	            System.out.print(array[i] + " ");
	        }
	        System.out.println();
	    }

	    
	    public static void main(String[] args) {
	        Steque<Integer> steque = new Steque<>();

	        steque.push(1);
	        steque.push(2);
	        steque.enqueue(3);
	        steque.enqueue(4);

	        System.out.println("Steque content:");
	        steque.printSteque(); 

	        System.out.println("Pop: " + steque.pop()); 
	        System.out.println("Pop: " + steque.pop()); 

	        steque.printSteque();  
	    }
	}