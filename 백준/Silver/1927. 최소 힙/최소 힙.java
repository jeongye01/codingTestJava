
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine().trim());
			if (n == 0) {
				if (!q.isEmpty()) {
					System.out.println(q.poll());
				} else {
					System.out.println(0);
				}

			} else {
				q.offer(n);
			}

		}
	}
}
