import java.util.*;
import java.io.*;

public class Main {
	static int N, ans1, ans2;
	static char board[][];
	static boolean visited[][];
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		ans1 = 0;
		ans2 = 0;
		N = Integer.parseInt(br.readLine().trim());
		board = new char[N][N];

		for (int i = 0; i < N; i++) {
			char[] chs = br.readLine().trim().toCharArray();
			for (int j = 0; j < N; j++) {
				board[i][j] = chs[j];
			}
		}
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				if (!visited[i][j]) {
					ans1++;
					bfs(i, j);
				}

			}
		}
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					ans2++;
					bfs2(i, j);
				}

			}
		}

		sb.append(ans1).append(" ").append(ans2);
		System.out.println(sb);

	}

	private static void bfs(int i, int j) {
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { i, j });
		visited[i][j] = true;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int y = now[0], x = now[1];
			// System.out.println(x + " " + y);
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d], ny = y + dy[d];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[ny][nx] || board[ny][nx] != board[y][x]) {
					continue;
				}
				visited[ny][nx] = true;
				q.add(new int[] { ny, nx });
			}
		}
	}

	private static void bfs2(int i, int j) {
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { i, j });
		visited[i][j] = true;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int y = now[0], x = now[1];
			// System.out.println(x + " " + y);
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d], ny = y + dy[d];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[ny][nx]) {
					continue;
				}
				if ((board[y][x] == 'B' || board[ny][nx] == 'B') && board[i][j] != board[ny][nx]) {
					continue;

				}
				visited[ny][nx] = true;
				q.add(new int[] { ny, nx });
			}
		}
	}

}