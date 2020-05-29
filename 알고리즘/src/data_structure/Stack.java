package data_structure;

public class Stack {
	private Object stack[];
	private int top = -1;
	private final int MAX_SIZE;
	
	public Stack(int size) {
		MAX_SIZE = size;
		stack = new Object[size];
	}
	
	public void push(Object e) throws Exception {
		if(isFull()) {
			throw new Exception("스택이 포화상태입니다.");
		}
		stack[++top] = e;
	}
	
	public Object peek() {
		if(isEmpty()) {
			throw new RuntimeException();
		}
		
		return stack[top];
	}
	
	public Object pop() {
		Object data = peek();
		stack[top--] = null;
		return data;
	}
	
	public int size() {
		return top;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	private boolean isFull() {
		return top == MAX_SIZE-1;
	}
}
