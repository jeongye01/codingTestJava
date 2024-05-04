import java.io.*;
import java.util.*;

public class Main {
	static char[][] board;
	static int N;
	static int ans;

	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		board = new char[N][N];
		for (int i = 0; i < N; i++) {
			char[] chs = br.readLine().trim().toCharArray();
			for (int j = 0; j < N; j++) {
				board[i][j] = chs[j];
			}
		}
		for (int i = 0; i < N; i++) {

			for (int j = 0; j < N; j++) {

				solve(i, j, false, 1, board[i][j], 0);
				solve(i, j, false, 1, board[i][j], 1);
				solve(i, j, false, 1, board[i][j], 2);
				solve(i, j, false, 1, board[i][j], 3);

			}
		}

		System.out.println(ans);
	}

	private static void solve(int i, int j, boolean isChanged, int cnt, char candy, int dire) {

		if (cnt > ans) {
			ans = cnt;
		}
		for (int d = 0; d < 4; d++) {
			if (d == dire) {
				int ny = i + dy[d];
				int nx = j + dx[d];

				if (ny < 0 || ny >= N || nx < 0 || nx >= N)
					continue;
			
				if (board[ny][nx] == candy)
					solve(ny, nx, isChanged, cnt + 1, candy, dire);
				else if (!isChanged) {
					if (d == 0 || d == 2) { // y축 움직이는 중
						if ((j + 1 < N && board[ny][j + 1] == candy) || (j - 1 >= 0 && board[ny][j - 1] == candy)) {
							solve(ny, nx, !isChanged, cnt + 1, candy, dire);
						}
					} else { // x축 움직이는 중
						if ((i + 1 < N && board[i + 1][nx] == candy) || (i - 1 >= 0 && board[i - 1][nx] == candy)) {
							solve(ny, nx, !isChanged, cnt + 1, candy, dire);
						}
					}
					if (ny + dy[d] < N && ny + dy[d] >= 0 && nx + dx[d] < N &&  nx + dx[d] >=0  && board[ny + dy[d]][nx + dx[d]] == candy) {
						if (cnt + 1 > ans) {
							ans = cnt + 1;
						}
					}
				}

			}
		}

	}

}