
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, L;
	static int[][] board;

	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			if (setColRamp(i))
				ans++;
			if (setRowRamp(i))
				ans++;
		}
		System.out.println(ans);

	}

	public static boolean setRowRamp(int row) {
		boolean[] visited = new boolean[N];

		for (int i = 0; i < N - 1; i++) {
			if (board[row][i + 1] == board[row][i]) continue;
				int diff = board[row][i + 1] - board[row][i];
				if (Math.abs(diff) != 1)
					return false;
				if (diff == 1) {
					for (int j = 0; j < L; j++) {

						if (i - j < 0 || visited[i - j] || board[row][i - j] != board[row][i]) {

							return false;
						}
						visited[i - j] = true;
					}

				} else {
					for (int j = 0; j < L; j++) {

						if (i + 1 + j >= N || visited[i + 1 + j] || board[row][i + 1 + j] != board[row][i + 1]) {
							return false;
						}
						visited[i + 1 + j] = true;
					}

				}

			}
		
		return true;

	}

	public static boolean setColRamp(int col) {
		boolean[] visited = new boolean[N];

		for (int i = 0; i < N - 1; i++) {
			if(board[i + 1][col] == board[i][col])continue;
			int diff = board[i + 1][col] - board[i][col];
			if (Math.abs(diff) != 1)
				return false;
			if (diff == 1) {

				for (int j = 0; j < L; j++) {

					if (i - j < 0 || visited[i - j] || board[i - j][col] != board[i][col]) {
						return false;
					}
					visited[i - j] = true;
				}

			} else {

				for (int j = 0; j < L; j++) {

					if (i + 1 + j >= N || visited[i + 1 + j] || board[i + 1 + j][col] != board[i + 1][col]) {
						return false;
					}
					visited[i + 1 + j] = true;
				}

			}

		}
		return true;

	}

}
