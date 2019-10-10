package d1007_d1013_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_D4_3814_평등주의 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			Gap gap[] = new Gap[n];
			int num[] = new int[n];
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<n; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			PriorityQueue<Gap> queue = new PriorityQueue<>();
			
			for(int i=0; i<n; i++) {
				gap[i] = new Gap(i);
				if(i == 0) {
					gap[i].setAfter(num[i] - num[i + 1]);
				}
				else if(i == n - 1) {
					gap[i].setBefore(num[i] - num[i - 1]);
				}
				else {
					gap[i].setAfter(num[i] - num[i + 1]);
					gap[i].setBefore(num[i] - num[i - 1]);
				}
				queue.add(gap[i]);
			}
			
			//System.out.println(queue);
			for(int i=0; i<k; i++) {
				Gap tmp = queue.poll();
				
				int minus;
				if(tmp.max - queue.peek().max > k - i) {
					minus = k - i;
				}
				else {
					minus = tmp.max - queue.peek().max;
				}
				
				if(minus == 0) {
					minus = 1;
				}
				
				//System.out.println(minus);
				
				num[tmp.index] -= minus;
				
				if(tmp.index == 0) {
					gap[tmp.index].setAfter(gap[tmp.index].after - minus);
				}
				else if(tmp.index == n - 1) {
					gap[tmp.index].setBefore(gap[tmp.index].before - minus);
				}
				else {
					gap[tmp.index].setBefore(gap[tmp.index].before - minus);
					gap[tmp.index].setAfter(gap[tmp.index].after - minus);
					
					gap[tmp.index - 1].setAfter(num[tmp.index - 1] - num[tmp.index]);
					gap[tmp.index + 1].setBefore(num[tmp.index + 1] - num[tmp.index]);
				}
				
				i += minus - 1;
				
				queue.offer(gap[tmp.index]);
				
				/*System.out.println(queue);
				System.out.println(Arrays.toString(num));*/
			}
			
			System.out.println("#" + t + " " + gap[queue.peek().index].max);
		}
	}
	
	static class Gap implements Comparable<Gap> {
		private int index;
		private int before = Integer.MIN_VALUE;
		private int after = Integer.MIN_VALUE;
		private int max = Integer.MIN_VALUE;
		
		public Gap(int index) {
			this.index = index;
		}

		public int getBefore() {
			return before;
		}

		public void setBefore(int before) {
			this.before = before;
			this.max = Math.max(this.before, this.after);
		}

		public int getAfter() {
			return after;
		}

		public void setAfter(int after) {
			this.after = after;
			this.max = Math.max(this.before, this.after);
		}

		public int getMax() {
			return max;
		}

		public void setMax(int max) {
			this.max = max;
		}

		public int compareTo(Gap target) {
			return target.getMax() - this.getMax();
		}
		
		public String toString() {
			return "Gap [index=" + index + ", before=" + before + ", after=" + after + ", max=" + max + "]";
		}
	}
}
