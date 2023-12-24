import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] board;

	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine().trim());
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int n = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 1) {
					setN(i, j, n);
					n++;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] >= 2 && isEdge(i, j)) {
					dist(i, j, board[i][j]);

				}
			}
		}
		System.out.println(ans);

	}

	private static boolean isEdge(int i, int j) {

		for (int d = 0; d < 4; d++) {
			int ny = i + dy[d];
			int nx = j + dx[d];
			if (ny < 0 || ny >= N || nx < 0 || nx >= N)
				continue;
			if (board[ny][nx] == 0)
				return true;
		}
		return false;
	}

	private static void setN(int i, int j, int n) {
		boolean visited[][] = new boolean[N][N];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { i, j });
		visited[i][j] = true;
		board[i][j] = n;
		while (!q.isEmpty()) {
			int now[] = q.poll();
			int y = now[0];
			int x = now[1];

			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if (ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx] || board[ny][nx] == 0)
					continue;

				board[ny][nx] = n;
				q.add(new int[] { ny, nx });
				visited[ny][nx] = true;

			}
		}

	}

	private static void dist(int i, int j, int n) {
		boolean visited[][] = new boolean[N][N];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { i, j, 0 });
		visited[i][j] = true;

		while (!q.isEmpty()) {
			int now[] = q.poll();
			int y = now[0];
			int x = now[1];
			int dis = now[2];
			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if (ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx] || board[ny][nx] == n)
					continue;
				if (board[ny][nx] != 0) {
					ans = Math.min(ans, dis);

					continue;
				}

				q.add(new int[] { ny, nx, dis + 1 });

				visited[ny][nx] = true;

			}
		}

	}

}