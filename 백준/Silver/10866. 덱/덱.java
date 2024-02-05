
import java.io.*;
import java.util.*;

public class Main {
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	    StringBuilder sb = new StringBuilder();
	    Deque<Integer> q = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine().trim());
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine().trim());
			
			String comm=st.nextToken();
			if(comm.equals("push_front")) {
			
				q.addFirst(Integer.parseInt(st.nextToken()));
				
			}else if(comm.equals("push_back")) {
				q.addLast(Integer.parseInt(st.nextToken()));
			}
			else if(comm.equals("pop_front")) {
				
					sb.append(q.isEmpty()?-1:q.pollFirst()).append('\n');
			
				
			}else if(comm.equals("pop_back")) {
				sb.append(q.isEmpty()?-1:q.pollLast()).append('\n');
			}
			else if(comm.equals("size")) {
				sb.append(q.size()).append('\n');
			}else if(comm.equals("empty")) {
				sb.append(q.isEmpty()?1:0).append('\n');
			}else if(comm.equals("front")) {
				sb.append(q.isEmpty()?-1:q.peek()).append('\n');
			}else {
				sb.append(q.isEmpty()?-1:q.peekLast()).append('\n');
			}
		}
		System.out.println(sb);

	}

}