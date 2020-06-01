package data_structure;

// 선형큐의 deQueue시 원소 이동의 오버헤드를 줄임.
public class CircularQueue implements Queue {
	private Object[] queue;
	private int front, rear;	// front: 직전에 dequeue된 원소 위치, rear: 직전에 enqueue된 원소 위치
	private final int MAX_SIZE;
	
	public CircularQueue(int maxSize) {
		this.MAX_SIZE = maxSize;
		queue = new Object[MAX_SIZE];
		front = rear = 0;
	}
	
	public boolean isEmpty() {
		return front == rear;
	}
	
	public boolean isFull() {
		return ((rear + 1) % MAX_SIZE) == front;
	}
	
	public void enQueue(Object item) {
		if(isFull()) throw new RuntimeException("큐가 포화상태입니다.");
		rear = (rear + 1) % MAX_SIZE;
		queue[rear] = item;
	}
	
	public Object peek() {
		if(isEmpty()) throw new RuntimeException("큐가 공백상태입니다.");
		
		return queue[(front + 1) % MAX_SIZE];
	}
	
	public Object deQueue() {
		Object item = peek();
		front = (front + 1) % MAX_SIZE;
		queue[front] = null;
		
		return item;
	}
}
