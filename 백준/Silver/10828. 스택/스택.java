import java.io.*;
import java.util.*;

public class Main {
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	    StringBuilder sb = new StringBuilder();
	    Stack<Integer> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine().trim());
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine().trim());
			String comm=st.nextToken();
			if(comm.equals("push")) {
				stack.add(Integer.parseInt(st.nextToken()));
				
			}else if(comm.equals("pop")) {
				
					sb.append(stack.isEmpty()?-1:stack.pop()).append('\n');
			
				
			}else if(comm.equals("size")) {
				sb.append(stack.size()).append('\n');
			}else if(comm.equals("empty")) {
				sb.append(stack.isEmpty()?1:0).append('\n');
			}else {
				sb.append(stack.isEmpty()?-1:stack.peek()).append('\n');
			}
		}
		System.out.println(sb);

	}

}
