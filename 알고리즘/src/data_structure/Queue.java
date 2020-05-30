package data_structure;

public interface Queue {

	boolean isEmpty();

	boolean isFull();

	void enQueue(Object item);

	Object peek();

	Object deQueue();

}