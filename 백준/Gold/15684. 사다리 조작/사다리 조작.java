import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 두 가로선이 연속하거나 서로 접하면 안 된다. 또, 가로선은 점선 위에 있어야 한다.
// ans : 추가해야 하는 가로선 개수의 최솟값
// 정답이 3보다 큰 값이면 -1을 출력, 또, 불가능한 경우에도 -1을 출력
public class Main {

	static int N, M, H;
	static boolean[][] board;

	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		ans = 4;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		board = new boolean[H][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			board[a][b] = true;
		}

		add(0, 0, 0);
		System.out.println(ans >= 4 ? -1 : ans);

	}

	public static int result(int r, int c) {
		if (r == H) {

			return c;
		}

		if (board[r][c]) {
			return result(r + 1, c + 1);
		} else if (c - 1 >= 0 && board[r][c - 1]) {
			return result(r + 1, c - 1);
		}
		return result(r + 1, c);

	}

	public static boolean test() {

		for (int i = 0; i < N; i++) {
			int res = result(0, i);
			if (res != i)
				return false;
		}

		return true;
	}

	public static void add(int cnt, int sr, int sc) {
		if (cnt > 3 || cnt >= ans) {
			return;
		}
		if (test()) {
			ans = Math.min(cnt, ans);
			return;
		}
		for (int i = sr; i < H; i++) {
			for (int j = 0; j < N - 1; j++) {
				if (board[i][j] || (j - 1 >= 0 && board[i][j - 1]) || (j + 1 < N-1  && board[i][j + 1]))
					continue;

				board[i][j] = true;
				if (j  == N - 2) {
					add(cnt + 1, i + 1, 0);
				} else {
					add(cnt + 1, i, j + 1);
				}

				board[i][j] = false;
			}
		}
	}

}