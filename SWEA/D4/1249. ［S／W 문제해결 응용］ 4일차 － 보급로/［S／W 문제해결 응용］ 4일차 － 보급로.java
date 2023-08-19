import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int graph[][], dist[][];
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			graph = new int[N][N];
			dist = new int[N][N];
			for (int i = 0; i < N; i++) {
				char[] chs = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					dist[i][j] = Integer.MAX_VALUE;
					graph[i][j] = chs[j] - '0';
				}

			}
			dijkstra();
			
			sb.append("#").append(tc).append(" ").append(dist[N - 1][N - 1]).append("\n");

		}
		System.out.println(sb);

	}

	public static class Edge implements Comparable<Edge> {
		int x;
		int y;
		int w;

		public Edge(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}

		public int compareTo(Edge o) {
			return w - o.w;
		}
	}

	public static void dijkstra() {
		PriorityQueue<Edge> q = new PriorityQueue<>();
		q.offer(new Edge(0, 0, 0));

		while (!q.isEmpty()) {
			Edge now = q.poll();
			int x = now.x;
			int y = now.y;
			int w = now.w;
			if (dist[y][x] < w) {
				continue;
			}
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d], ny = y + dy[d];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}
				int cost = w + graph[ny][nx];

				if (cost < dist[ny][nx]) {
					dist[ny][nx] = cost;
					q.offer(new Edge(nx, ny, cost));
				}
			}
		}
	}
}