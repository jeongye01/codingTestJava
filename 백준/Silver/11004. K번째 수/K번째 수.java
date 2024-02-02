import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		PriorityQueue<Integer> q = new PriorityQueue<>(); 
		List<Integer> list = new ArrayList<>();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken())*-1);
		}
		for(int i=0;i<K;i++) {
			q.add(list.get(i));
		}
		for(int i=K;i<N;i++) {
			int n=list.get(i);
			if(n>q.peek()) {

				q.poll();
				q.add(n);
			}
		}
		
      
		System.out.println(q.poll()*-1);
	}

}
