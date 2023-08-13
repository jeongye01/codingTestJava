import java.io.*;
import java.util.*;

public class Solution {

	static int N, max, board[][];
	static int wormhole[][] = new int[5][5];
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int[][] block = { { 1, 3, 0, 2 }, { 3, 0, 1, 2 }, { 2, 0, 3, 1 }, { 1, 2, 3, 0 }, { 1, 0, 3, 2 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			board = new int[N][N];
			max = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < N; j++) {
					int input = Integer.parseInt(st.nextToken());
					board[i][j] = input;
					if (input >= 6 && input <= 10) {
						int wh[]=wormhole[input - 6];
						wh[(wh[4]++) % 4] = i;
						wh[(wh[4]++) % 4] = j;

					}

				}

			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int d = 0; d < 4; d++) {
						if (board[i][j] == 0) {

							max = Math.max(max, play(i, j, d));

						}
					}
				}
			}

			sb.append("#").append(tc).append(" ").append(max).append("\n");

		}
		System.out.println(sb);

	}



	public static int play(int r, int c, int d) {
		int p = 0;
		int sr = r;
		int sc = c;
		while (true) {

			r += dy[d];
			c += dx[d];

			if ( r < 0 || r >= N || c < 0 || c >= N) {
				return p * 2 + 1;
			}
			int n = board[r][c];
			if (r == sr && c == sc || n == -1) {
				return p;
			} else if (n == 0) {
				continue;
			} else if (n <= 5) {// 블록을 만났을 때
				p++;
				d = block[n - 1][d];

			} else if (n >= 6 && n <= 10) { // 웜홀을 만났을 때
				int[] wh = wormhole[n - 6];
				if (r == wh[0] && c == wh[1]) {
					r = wh[2];
					c = wh[3];
				} else {
					r = wh[0];
					c = wh[1];

				}

			}

		}

	}

}