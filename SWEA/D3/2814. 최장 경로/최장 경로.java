import java.io.*;
import java.util.*;

public class Solution {
	static int N, M, ans;
	static int graph[][], visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			ans = 1;
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			graph = new int[N][N];

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				graph[a][b] = graph[b][a] = 1;

			}
			visited = new int[N];
			for (int i = 0; i < N; i++) {

				visited[i] = 1;
				dfs(i, 1);
				visited[i] = 0;
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}

		System.out.println(sb);

	}

	public static void dfs(int node, int dis) {
		if (dis > ans) {
			ans = dis;
		}

		for (int i = 0; i < N; i++) {

			if (graph[node][i] == 1 && visited[i] == 0) {
				visited[i] = 1;
				dfs(i, dis + 1);
				visited[i] = 0;

			}

		}

	}
}