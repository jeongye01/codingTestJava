
import java.io.*;
import java.util.*;

public class Main {
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	    StringBuilder sb = new StringBuilder();
	    Queue<Integer> q = new LinkedList<>();
		int N = Integer.parseInt(br.readLine().trim());
		int last=0;
		for(int i=0;i<N;i++) {
			
			st = new StringTokenizer(br.readLine().trim());
			String comm=st.nextToken();
			if(comm.equals("push")) {
				int e =Integer.parseInt(st.nextToken());
				q.add(e);
				last = e;
			}else if(comm.equals("pop")) {
				
					sb.append(q.isEmpty()?-1:q.poll()).append('\n');
			
				
			}else if(comm.equals("size")) {
				sb.append(q.size()).append('\n');
			}else if(comm.equals("empty")) {
				sb.append(q.isEmpty()?1:0).append('\n');
			}else if(comm.equals("front")) {
				sb.append(q.isEmpty()?-1:q.peek()).append('\n');
			}else {
				sb.append(q.isEmpty()?-1:last).append('\n');
			}
		}
		System.out.println(sb);

	}

}