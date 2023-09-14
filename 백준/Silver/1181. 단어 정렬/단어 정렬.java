import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, M, coins[], dp[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine().trim());
		PriorityQueue<Node> q=new PriorityQueue<>();
		for(int i=0;i<N;i++) {
			
			String s = br.readLine().trim();
			q.offer(new Node(s));
		}
		String before="";
		while(!q.isEmpty()) {
			String now = q.poll().value;
			if(!before.equals(now)) {
			   sb.append(now).append("\n");
			   before=now;
			}
		}
	    System.out.println(sb);
	}
	private static class Node implements Comparable<Node>{
		String value;
		public Node(String value) {
			this.value=value;
		}
		@Override
	    public int compareTo(Node n) {
			if(this.value.length()==n.value.length()) {
				return this.value.compareTo(n.value);
			}
			return this.value.length()- n.value.length();
			
		}
		
	}

}