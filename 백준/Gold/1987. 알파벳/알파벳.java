import java.util.*;
import java.io.*;

public class Main {
	static int R, C, ans, board[][];
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };
	static boolean[] alpa;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new int[R][C];
		alpa = new boolean[26];
		for (int i = 0; i < R; i++) {
			char[] chs = br.readLine().trim().toCharArray();
			for (int j = 0; j < C; j++) {
				board[i][j] = chs[j] - 'A';
			}

		}
		alpa[board[0][0]] = true;
		dfs(0, 0, 1);

		System.out.println(ans);

	}

	private static void dfs(int i, int j, int cnt) {
		ans = Math.max(ans, cnt);
		for (int d = 0; d < 4; d++) {
			int nx = j + dx[d], ny = i + dy[d];
			if (nx < 0 || nx >= C || ny < 0 || ny >= R || alpa[board[ny][nx]]) {
				continue;
			}
			alpa[board[ny][nx]] = true;
			dfs(ny, nx, cnt + 1);
			if (ans >= 26) {
				return;
			}
			alpa[board[ny][nx]] = false;
		}

	}

}