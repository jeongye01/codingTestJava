import java.io.*;
import java.util.*;

public class Main {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
			return  o2-o1;
		});

		for (int i = 0; i < N; i++) {
			st =new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}
		}
		for(int i=0;i<N-1;i++) {
			queue.poll();
		}

		System.out.println(queue.poll());

	}

}