import java.util.*;
import java.io.*;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		PriorityQueue<Double> q = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			q.offer(Double.parseDouble(st.nextToken()));
		}
		double sum = 0;
		while (q.size() > 1) {

			sum += q.poll() / 2;

		}

		System.out.println(sum + q.poll());

	}

}