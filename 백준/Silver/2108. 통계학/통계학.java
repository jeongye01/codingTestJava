import java.io.*;
import java.util.*;

public class Main {
	static class Num implements Comparable<Num> {
		int n;
		int cnt;

		public Num(int n, int cnt) {
			
			this.n = n;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Num o) {
			if (o.cnt == this.cnt) {
				return o.n-this.n;
			}
			 
			
			return this.cnt - o.cnt;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine().trim());
		int[] arr = new int[N];
		int sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine().trim());
			sum += arr[i];
		}

		Arrays.sort(arr);

		int avg = (int)Math.round((double) sum / N);
		int center = arr[N / 2];
		int many = 0;
		int range = arr[N - 1] - arr[0];
		PriorityQueue<Num> q = new PriorityQueue<>();
		int cnt = 0;
		for (int i = N-1; i >0 ; i--) {
			if (arr[i-1] != arr[i]) {
				q.add(new Num(arr[i], cnt+1));
				cnt=0;
				if (q.size() > 2) {
					
					q.poll();
				}
			} else {
				cnt++;
			}
		}
		q.add(new Num(arr[0], cnt==0?1:cnt+1));
		if (q.size() > 2) {
			q.poll();
		}
		Num tmp =q.poll();
		
		many=tmp.n;
		if(!q.isEmpty()) {
			if(q.peek().cnt>tmp.cnt) {
				
				many=q.poll().n;
			}
		}
	
	

		sb.append(avg).append('\n').append(center).append('\n').append(many).append('\n').append(range);
		System.out.println(sb);
		//System.out.println(-1/3);

	}

}