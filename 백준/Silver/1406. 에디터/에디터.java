import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		char[] str = br.readLine().trim().toCharArray();
		int N = str.length;
		Stack<Character>  left = new Stack<>();
		Deque<Character>  right = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			left.add(str[i]);
		}
		
		int M = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			char comm = st.nextToken().charAt(0);
			if (comm == 'P') {
				char c = st.nextToken().charAt(0);

				left.push(c);
			

			} else if (comm == 'L') {
				if(!left.isEmpty())
				right.addFirst(left.pop());
			} else if (comm == 'D') {
				if(!right.isEmpty())
				left.push(right.pollFirst());
			} else {
				if(!left.isEmpty())
				left.pop();
				
			}
			

		}
	
		Iterator iter = left.iterator();
		while(iter.hasNext()) {
			sb.append(iter.next());
		}
		while(!right.isEmpty()) {
			sb.append(right.pollFirst());
		}
		System.out.println(sb);

	}

}