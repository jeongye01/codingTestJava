import java.util.*;
import java.io.*;

public class Solution {
	static int N = 16, sr, sc, ans;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int board[][] = new int[N][N];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			br.readLine();
			for (int i = 0; i < N; i++) {
				char[] chs = br.readLine().trim().toCharArray();
				for (int j = 0; j < N; j++) {
					int input = chs[j] - '0';
					board[i][j] = input;
					if (input == 2) {// 시작지점
						sr = i;
						sc = j;
					} 
				}
			}

			ans = bfs(sr, sc);

			sb.append("#").append(tc).append(" ").append(ans).append("\n");

		}
		System.out.println(sb);

	}

	private static int bfs(int i, int j) {
		Deque<int[]> q = new ArrayDeque<>();

		q.add(new int[] { i, j });
		board[i][j] = -1;
		while (!q.isEmpty()) {
			int[] now = q.poll();

			int y = now[0], x = now[1];
		

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d], ny = y + dy[d];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || board[ny][nx] == 1 || board[ny][nx] == -1) {
					continue;
				}
				if (board[ny][nx]==3) {
					return 1; // 가능
				}

				q.add(new int[] { ny, nx });

				board[ny][nx] = -1;

			}

		}
		return 0; // 불가능
	}

}