import java.util.*;
import java.io.*;

public class Main {
	static int N, M, ans, edgeList[];
	static List<Integer> graph[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		ans = 0;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N + 1];
		edgeList = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			edgeList[b]++;
		}
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i < N + 1; i++) {
			if (edgeList[i] == 0) {
				q.offer(i);
			}
		}
		while (!q.isEmpty()) {
			int n = q.poll();
			sb.append(n).append(" ");
			for (Integer i : graph[n]) {

				edgeList[i]--;
				if (edgeList[i] == 0) {
					q.offer(i);
				}
			}
		}

		System.out.println(sb);

	}

}