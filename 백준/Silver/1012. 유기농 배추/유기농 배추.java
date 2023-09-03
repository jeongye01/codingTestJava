

import java.util.*;
import java.io.*;

public class Main {
	static int M, N, K;
	static int board[][];
	static int dx[] = { 0, -1, 0, 1 };
	static int dy[] = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			board = new int[N][M];
			int ans = 0;
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine().trim());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				board[y][x] = 1;
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (board[i][j] == 1) {
						ans++;
						bfs(i, j);
					}

				}
			}
			sb.append(ans).append("\n");

		}

		System.out.println(sb);
	}

	public static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		board[i][j] = -1;
		q.add(new int[] { i, j });
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int y = now[0], x = now[1];
			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d], nx = x + dx[d];
				if (ny < 0 || ny >= N || nx < 0 || nx >= M || board[ny][nx] != 1) {
					continue;
				}
				board[ny][nx] = -1;
				q.add(new int[] { ny, nx });
			}
		}

	}

}
