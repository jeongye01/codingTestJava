
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] board = new int[N][M];
		for (int i = 0; i < N; i++) {
			char[] chs = br.readLine().trim().toCharArray();
			for (int j = 0; j < M; j++) {
				board[i][j] = chs[j] - '0';
			}
		}
		long ans = 0;
		// ㅣ*3
		for (int i = 0; i < M - 2; i++) {
			for (int j = i + 1; j < M - 1; j++) {
				long sum1 = 0, sum2 = 0, sum3 = 0;

				for (int b = 0; b < N; b++) {
					for (int a = 0; a <= i; a++) {
						sum1 += board[b][a];
					}
				}

				for (int b = 0; b < N; b++) {
					for (int a = i + 1; a <= j; a++) {
						sum2 += board[b][a];
					}
				}

				for (int b = 0; b < N; b++) {
					for (int a = j + 1; a < M; a++) {
						sum3 += board[b][a];
					}
				}
				ans = Math.max(ans, sum1 * sum2 * sum3);
			}
		}
		// -*3
		for (int i = 0; i < N - 2; i++) {
			for (int j = i + 1; j < N - 1; j++) {
				long sum1 = 0, sum2 = 0, sum3 = 0;
				for (int a = 0; a <= i; a++) {
					for (int b = 0; b < M; b++) {
						sum1 += board[a][b];
					}
				}
				for (int a = i + 1; a <= j; a++) {
					for (int b = 0; b < M; b++) {
						sum2 += board[a][b];
					}
				}
				for (int a = j + 1; a < N; a++) {
					for (int b = 0; b < M; b++) {
						sum3 += board[a][b];
					}
				}
				ans = Math.max(ans, sum1 * sum2 * sum3);
			}
		}
		// ㅗ
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < M - 1; j++) {
				long sum1 = 0, sum2 = 0, sum3 = 0;

				for (int r = 0; r <= i; r++) {
					for (int c = 0; c <= j; c++) {
						sum1 += board[r][c];
					}
				}

				for (int r = 0; r <= i; r++) {
					for (int c = j + 1; c < M; c++) {
						sum2 += board[r][c];
					}
				}

				for (int r = i + 1; r < N; r++) {
					for (int c = 0; c < M; c++) {
						sum3 += board[r][c];
					}
				}
				ans = Math.max(ans, sum1 * sum2 * sum3);
			}
		}

		// ㅜ
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < M - 1; j++) {
				long sum1 = 0, sum2 = 0, sum3 = 0;

				for (int r = i + 1; r < N; r++) {
					for (int c = 0; c <= j; c++) {
						sum1 += board[r][c];
					}
				}

				for (int r = i + 1; r < N; r++) {
					for (int c = j + 1; c < M; c++) {
						sum2 += board[r][c];
					}
				}

				for (int r = 0; r <= i; r++) {
					for (int c = 0; c < M; c++) {
						sum3 += board[r][c];
					}
				}
				ans = Math.max(ans, sum1 * sum2 * sum3);
			}
		}
		// ㅏ
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < M - 1; j++) {
				long sum1 = 0, sum2 = 0, sum3 = 0;

				for (int r = 0; r <= i; r++) {
					for (int c = j + 1; c < M; c++) {
						sum1 += board[r][c];
					}
				}

				for (int r = i + 1; r < N; r++) {
					for (int c = j + 1; c < M; c++) {
						sum2 += board[r][c];
					}
				}

				for (int r = 0; r < N; r++) {
					for (int c = 0; c <= j; c++) {
						sum3 += board[r][c];
					}
				}
				ans = Math.max(ans, sum1 * sum2 * sum3);
			}
		}
		// ㅓ
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < M - 1; j++) {
				long sum1 = 0, sum2 = 0, sum3 = 0;

				for (int r = 0; r <= i; r++) {
					for (int c = 0; c <= j; c++) {
						sum1 += board[r][c];
					}
				}

				for (int r = i + 1; r < N; r++) {
					for (int c = 0; c <= j; c++) {
						sum2 += board[r][c];
					}
				}

				for (int r = 0; r < N; r++) {
					for (int c = j + 1; c < M; c++) {
						sum3 += board[r][c];
					}
				}
				ans = Math.max(ans, sum1 * sum2 * sum3);
			}
		}
		System.out.println(ans);

	}

}