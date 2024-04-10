import java.io.*;
import java.util.*;

public class Main {
	static class Number implements Comparable<Number> {
		int value;

		public Number(int value) {
			this.value = value;

		}

		@Override
		public int compareTo(Number o) {
			return  o.value - this.value ;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine().trim());
		PriorityQueue<Number> q = new PriorityQueue<>();
		for(int i=0;i<N;i++) {
			int n = Integer.parseInt(br.readLine().trim());
			if(n==0) {
				if(q.isEmpty()) {
					sb.append(0).append('\n');
				}else{
					sb.append(q.poll().value).append('\n');
				}
			}else {
				q.offer(new Number(n));
			}
			
		}
		System.out.println(sb);
	}

}
