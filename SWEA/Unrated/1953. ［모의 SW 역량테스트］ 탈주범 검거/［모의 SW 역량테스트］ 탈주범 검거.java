import java.util.*;
import java.io.*;

public class Solution {
	static int N, M, R, C, L, ans;
	static int[][] tunnels = { { 1, 1, 1, 1 }, { 1, 0, 1, 0 }, { 0, 1, 0, 1 }, { 1, 0, 0, 1 }, { 0, 0, 1, 1 },
			{ 0, 1, 1, 0 }, { 1, 1, 0, 0 } };
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int visited[][], board[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			board = new int[N][M];
			visited = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < M; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			bfs();
			sb.append("#").append(tc).append(" ").append(ans).append("\n");

		}
		System.out.println(sb);

	}

	private static void bfs() {
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { R, C, 1 });
		visited[R][C] = 1;
		ans = 1;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int y = now[0], x = now[1], l = now[2];
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d], ny = y + dy[d];
				if (l + 1 > L || nx < 0 || nx >= M || ny < 0 || ny >= N || visited[ny][nx] == 1) {
					continue;
				}
				if (board[ny][nx] == 0 || tunnels[board[y][x] - 1][d] == 0 || tunnels[board[ny][nx] - 1][(d+2)%4] == 0) {
					continue;
				}
				visited[ny][nx] = 1;
				ans += 1;
				q.add(new int[] { ny, nx, l + 1 });

			}
		}
	}

}