package data_structure;


// 완전이진트리
public class BinaryTree {
	private Object[] tree;
	private int lastIndex;
	private final int SIZE;
	private final int MAX_LEVEL;
	
	public BinaryTree(int size) {
		SIZE = size;
		tree = new Object[size+1];		// 0 인덱스 상ㅇ하지 않으므로
		MAX_LEVEL = (int)Math.ceil(Math.log(size+1)/Math.log(2)) - 1;	// 3: log4 ==> 2-1 ==> 1
	}
	
	public void add(Object e) {
		if(lastIndex == SIZE) throw new RuntimeException("포화상태입니다.");
		tree[++lastIndex] = e;
	}
	
	public void printTreeByPreOrder() {
		printTreeByPreOrder(1);
		System.out.println();
	}
	
	public void printTreeByPreOrder(int i) {
		if(i > lastIndex) return;
		
		// VLR
		System.out.print(tree[i] + " ");	// V
		printTreeByPreOrder(2 * i);			// L
		printTreeByPreOrder(2 * i + 1);		// R
	}
	
	public void printTreeByInOrder() {
		printTreeByInOrder(1);
		System.out.println();
	}
	
	public void printTreeByInOrder(int i) {
		if(i > lastIndex) return;
		
		// LVR
		printTreeByInOrder(2 * i);			// L
		System.out.print(tree[i] + " ");	// V
		printTreeByInOrder(2 * i + 1);		// R
	}
	
	public void printTreeByPostOrder() {
		printTreeByPostOrder(1);
		System.out.println();
	}
	
	public void printTreeByPostOrder(int i) {
		if(i > lastIndex) return;
		
		// LRV
		printTreeByPostOrder(2 * i);		// L
		printTreeByPostOrder(2 * i + 1);	// R
		System.out.print(tree[i] + " ");	// V
	}
	
	public void printTreeByLevelOrder() {
		for(int i=0; i<=MAX_LEVEL; i++) {
			int start = (int)Math.pow(2, i);
			int end = (int)Math.pow(2, i+1) - 1;
			for(int j=start; j<=lastIndex && j<=end; j++) {
				System.out.print(tree[j] + " ");
			}
			System.out.println();
		}
	}
}
