package data_structure;

public class LinearQueue implements Queue {
	private Object[] queue;
	private int front, rear;	// front: 직전에 dequeue된 원소 위치, rear: 직전에 enqueue된 원소 위치
	private final int MAX_SIZE;
	
	public LinearQueue(int maxSize) {
		this.MAX_SIZE = maxSize;
		queue = new Object[MAX_SIZE];
		front = rear = -1;
	}
	
	@Override
	public boolean isEmpty() {
		return front == rear;
	}
	
	@Override
	public boolean isFull() {
		return rear == MAX_SIZE - 1;
	}
	
	@Override
	public void enQueue(Object item) {
		if(isFull()) throw new RuntimeException("큐가 포화상태입니다.");
		queue[++rear] = item;
	}
	
	@Override
	public Object peek() {
		if(isEmpty()) throw new RuntimeException("큐가 공백상태입니다.");
		
		return queue[front + 1];
	}
	
	@Override
	public Object deQueue() {
		Object item = peek();
		queue[++front] = null;
		
		return item;
	}
}
