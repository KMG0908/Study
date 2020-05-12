package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_1228_암호문1 {
	private static class Node {
		Object data;
		Node link;
		
		public Node(Object data) {
			this.data = data;
		}
		
		public Node(Object data, Node link) {
			this(data);
			this.link = link;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}
	}
	
	private static Node head;
	
	public static void addLastNode(Object data) {
		Node newNode = new Node(data);
		
		if(head == null) {	// 공백 리스트
			head = newNode;
		}
		else {
			Node lastNode = getLastNode();
			lastNode.link = newNode;
		}
	}
	
	private static Node getLastNode() {
		Node current = head;
		
		if(current != null) {
			while(current.link != null) {
				current = current.link;
			}
		}
		
		return current;
	}
	
	public static void addNode(Object data, int location) {
		Node newNode = new Node(data);
		Node current = head;
		
		if(location < 0) {	// 공백 리스트
			newNode = new Node(data, head);
			head = newNode;
		}
		else {
			while(location > 0) {
				current = current.link;
				location--;
			}
			
			newNode.link = current.link;
			current.link = newNode;
		}
	}
	
	public static String print() {
		int count = 10;
		
		StringBuilder sb = new StringBuilder();
		
		Node current = head;
		
		while(count > 0) {
			sb.append(current.data + " ");
			current = current.link;
			count--;
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			head = null;
			
			int cryptogramL = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<cryptogramL; i++) {
				addLastNode(Integer.parseInt(st.nextToken()));
			}
			
			int commandL = Integer.parseInt(br.readLine());
			String[] command = new String[commandL];
			
			st = new StringTokenizer(br.readLine(), " ");
			
			int idx = -1;
			
			StringBuilder sb = new StringBuilder();
			
			while(st.hasMoreTokens()) {
				String str = st.nextToken();
				
				if(str.equals("I")) {
					if(idx != -1) {
						command[idx] = sb.toString();
					}
					sb = new StringBuilder();
					idx++;
				}
				else sb.append(str + " ");
			}
			
			command[idx] = sb.toString();
			
			for(int i=0; i<commandL; i++) {
				String[] com = command[i].split(" ");
				int location = Integer.parseInt(com[0]) - 1;
				int num = Integer.parseInt(com[1]);
				int index = 2;
				
				for(int j=0; j<num; j++) {
					addNode(com[index++], location++);
				}
			}
			
			System.out.println("#" + t + " " + print());
		}
	}
}
