import java.util.*;
import java.io.*;

public class Solution {
	static int N, ans;
	static int[] dx = { 0, -1, 0, 1, 1, -1, 1, -1 };
	static int[] dy = { -1, 0, 1, 0, 1, 1, -1, -1 };
	static char board[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			board = new char[N][N];
			ans = 0;
			for (int i = 0; i < N; i++) {
				char[] chs = br.readLine().trim().toCharArray();
				for (int j = 0; j < N; j++) {
					board[i][j] = chs[j];
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] == '.') {
						writeCount(i, j);
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] == '0') {
						bfs(i, j);
						ans += 1;
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] == '1') {

						ans += 1;
					}
				}
			}

			sb.append("#").append(tc).append(" ").append(ans).append("\n");

		}
		System.out.println(sb);

	}

	private static void writeCount(int i, int j) {
		for (int d = 0; d < 8; d++) {
			int nx = j + dx[d], ny = i + dy[d];
			if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
				continue;
			}
			if (board[ny][nx] == '*') {
				board[i][j] = '1';
				return;
			}
		}
		board[i][j] = '0';

	}

	private static void bfs(int i, int j) {
		Deque<int[]> q = new ArrayDeque<>();

		q.add(new int[] { i, j });
		board[i][j] = '2';
		while (!q.isEmpty()) {
			int[] now = q.poll();

			int y = now[0], x = now[1];

			for (int d = 0; d < 8; d++) {
				int nx = x + dx[d], ny = y + dy[d];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || board[ny][nx] == '2') {
					continue;
				}
				if (board[ny][nx] == '0') {
					q.add(new int[] { ny, nx });
				}
				board[ny][nx] = '2';

			}

		}
	}

}