import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

	static int board[][];
	static int ans; // 최대 5번 이동해서 만들 수 있는 가장 큰 블록의 값
	// 한 번의 이동에서이미 합쳐진 블록은 또 합쳐질 수 없다

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());

		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = 0;
		play(0);
		System.out.println(ans);
	}

	public static void play(int cnt) {
		if (cnt == 5) {
			int point = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					if (point < board[i][j]) {
						point = board[i][j];
					}
				}
			}

			if (ans < point) {

				ans = point;
			}
			return;
		}
		int[][] boardCopy = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				boardCopy[i][j] = board[i][j];

			}
		}

		// 상
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] > 0) {
					for (int k = i + 1; k < N; k++) {
						if (board[k][j] > 0 && board[i][j] != board[k][j]) {
							break;
						}
						if (board[i][j] == board[k][j]) {
							board[i][j] *= 2;
							board[k][j] = 0;
							break;
						}
					}
				}

			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 0) {
					for (int k = i + 1; k < N; k++) {
						if (board[k][j] > 0) {
							board[i][j] = board[k][j];
							board[k][j] = 0;
							break;
						}
					}
				}

			}
		}

		play(cnt + 1);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = boardCopy[i][j];

			}
		}

		// 하
		for (int i = N - 1; i >= 0; i--) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] > 0) {
					for (int k = i - 1; k >= 0; k--) {
						if (board[k][j] > 0 && board[i][j] != board[k][j]) {
							break;
						}
						if (board[i][j] == board[k][j]) {
							board[i][j] *= 2;
							board[k][j] = 0;
							break;
						}
					}
				}

			}
		}
		for (int i = N - 1; i >= 0; i--) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 0) {
					for (int k = i - 1; k >= 0; k--) {
						if (board[k][j] > 0) {
							board[i][j] = board[k][j];
							board[k][j] = 0;
							break;
						}
					}
				}

			}
		}

		play(cnt + 1);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = boardCopy[i][j];

			}
		}

		// 좌

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] > 0) {
					for (int k = j + 1; k < N; k++) {
						if (board[i][k] > 0 && board[i][j] != board[i][k]) {
							break;
						}
						if (board[i][j] == board[i][k]) {
							board[i][j] *= 2;
							board[i][k] = 0;
							break;
						}
					}
				}

			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 0) {

					for (int k = j + 1; k < N; k++) {
						if (board[i][k] > 0) {
							board[i][j] = board[i][k];
							board[i][k] = 0;
							break;

						}
					}
				}

			}
		}

		play(cnt + 1);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = boardCopy[i][j];

			}
		}

		// 우

		for (int i = 0; i < N; i++) {
			for (int j = N - 1; j >= 0; j--) {
				if (board[i][j] > 0) {
					for (int k = j - 1; k >= 0; k--) {
						if (board[i][k] > 0 && board[i][j] != board[i][k]) {
							break;
						}
						if (board[i][j] == board[i][k]) {
							board[i][j] *= 2;
							board[i][k] = 0;
							break;

						}
					}
				}

			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = N - 1; j >= 0; j--) {
				if (board[i][j] == 0) {
					for (int k = j - 1; k >= 0; k--) {
						if (board[i][k] > 0) {
							board[i][j] = board[i][k];
							board[i][k] = 0;
							break;
						}
					}
				}

			}
		}
		
		play(cnt + 1);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = boardCopy[i][j];

			}
		}
	}

}