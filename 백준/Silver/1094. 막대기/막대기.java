import java.io.*;
import java.util.*;
// 23분 
public class Main {
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int X = Integer.parseInt(br.readLine().trim());
		int ans=0;
		int len = 64;
		PriorityQueue<Integer> q = new PriorityQueue<>();
		q.add(64);
		while(len>X && !q.isEmpty()) {
			int shortest = q.poll();
            shortest/=2;
		
			if(len-shortest>=X) {
				len-=shortest;
				q.add(shortest);
			}else {
				q.add(shortest);
				q.add(shortest);
			}
			
			
		}
		
		System.out.println(q.size());
	

	}

}