import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] board;
	static int[] dx = { -1, 0, 1 };
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int x = 0; x < M; x++) {
			solve(0, x, -1, board[0][x]);
		}
		System.out.println(ans);

	}

	public static void solve(int depth, int x, int pd, int fuel) {
		if (fuel >= ans)
			return;
		if (depth == N - 1) {
			ans = Math.min(ans, fuel);
			return;
		}
		for (int d = 0; d < 3; d++) {
			if (d == pd)
				continue;
			int nx = x + dx[d];
			if (nx < 0 || nx >= M)
				continue;
			solve(depth + 1, nx, d, fuel + board[depth + 1][nx]);
		}
	}

}
