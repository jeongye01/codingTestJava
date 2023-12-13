import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// ans : 토네이도가 소멸되었을 때, 격자의 밖으로 나간 모래의 양
public class Main {

	static int N;
	static int[][] board;
	static int ans;
	public static int[][][] shape = {
			{ { 0, 0, 2, 0, 0 }, { 0, 10, 7, 1, 0 }, { 5, -1, 0, 0, 0 }, { 0, 10, 7, 1, 0 }, { 0, 0, 2, 0, 0 } },
			{ { 0, 0, 0, 0, 0 }, { 0, 1, 0, 1, 0 }, { 2, 7, 0, 7, 2 }, { 0, 10, -1, 10, 0 }, { 0, 0, 5, 0, 0 } },
			{ { 0, 0, 2, 0, 0 }, { 0, 1, 7, 10, 0 }, { 0, 0, 0, -1, 5 }, { 0, 1, 7, 10, 0 }, { 0, 0, 2, 0, 0 } },
			{ { 0, 0, 5, 0, 0 }, { 0, 10, -1, 10, 0 }, { 2, 7, 0, 7, 2 }, { 0, 1, 0, 1, 0 }, { 0, 0, 0, 0, 0 } } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}

		}
		solve();
		System.out.println(ans);

	}

	public static void solve() {
		int y = N / 2, x = N / 2;
		int m = 1;
		int d = 0;
		int dx[] = { -1, 0, 1, 0 };
		int dy[] = { 0, 1, 0, -1 };

		// TODO: 이동 시키기
		while (true) {

			for (int i = 0; i < m; i++) {
				x += dx[d];
				y += dy[d];
				if (x < 0 || y < 0)
					return;
				// 모래 이동시키기
				if (board[y][x] != 0) {
					move(y, x, d, board[y][x]);
				}

			}
			d = (d + 1) % 4;
			if (d == 2 || d == 0)
				m += 1;

		}

	}

	public static void move(int y, int x, int d, int sand) {
		board[y][x] = 0;
		int a = sand;
		int ax = -1;
		int ay = -1;
		for (int i = -2; i <= 2; i++) {
			for (int j = -2; j <= 2; j++) {
				int ny = y + i;
				int nx = x + j;
				int amount = (int) (sand * shape[d][i + 2][j + 2] * 0.01);
				if (ny < 0 || ny >= N || nx < 0 || nx >= N) {
					ans += amount;
					a -= amount;
				} else if (shape[d][i + 2][j + 2] > 0) {
					board[ny][nx] += amount;
					a -= amount;
				} else if (shape[d][i + 2][j + 2] == -1) {
					ax = nx;
					ay = ny;
				}

			}

		}
		if (ax < 0) {
			ans += a;
		} else {
			board[ay][ax] += a;
		}

	}

}