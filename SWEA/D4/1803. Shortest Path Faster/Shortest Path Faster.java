import java.io.*;
import java.util.*;

public class Solution {
	static int N, M, S, E;
	static List<List<Edge>> graph = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N + 1; i++) {
				graph.add(new ArrayList<>());
			}
			Long[] dist = new Long[N + 1];
			for (int i = 1; i <= N; i++) {
				dist[i] = Long.MAX_VALUE;
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				graph.get(a).add(new Edge(b, c));
				graph.get(b).add(new Edge(a, c));

			}

			PriorityQueue<Edge> q = new PriorityQueue<>();
			q.offer(new Edge(S,0));

			while (!q.isEmpty()) {
				Edge now = q.poll();
				if (dist[now.v] < now.w) {
					continue;
				}
				for (Edge i : graph.get(now.v)) {
					Long cost = now.w + i.w;

					if (cost < dist[i.v]) {
						dist[i.v] = cost;
						q.offer(new Edge(i.v,cost));
					}
				}
			}
			graph.clear();
			sb.append("#").append(tc).append(" ").append(dist[E]).append("\n");

		}
		System.out.println(sb);

	}
	public static class Edge implements Comparable<Edge>{
        int v;
        long w;
 
        public Edge(int v, long w){
            this.v = v;
            this.w = w;
        }
        @Override
        public int compareTo(Edge o) {    // 가중치를 비교함
            return Long.compare(w, o.w);
        }
    }
}