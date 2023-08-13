import java.io.*;
import java.util.*;

public class Solution {

	static int N, board[][], max;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int wormhole[][];
	static Scanner sc=new Scanner(System.in);
	static int[][] block = { { 1, 3, 0, 2 }, { 3, 0, 1, 2 }, { 2, 0, 3, 1 }, { 1, 2, 3, 0 }, { 1, 0, 3, 2 } };

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt();

		

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			board = new int[N + 2][N + 2];
			for (int i = 0; i <= N + 1; i++) {
			    board[i][0]=board[i][N+1]=board[0][i]=board[N+1][i]=5;
			}
			wormhole = new int[5][4];
			max = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					int input = sc.nextInt();
					if (input >= 6 && input <= 10) {
						if (wormhole[input - 6][0] == 0 && wormhole[input - 6][2] == 0) {
							wormhole[input - 6][0] = i;
							wormhole[input - 6][2] = j;

						} else {
							wormhole[input - 6][1] = i;
							wormhole[input - 6][3] = j;

						}

					}
					board[i][j] = input;
				}

			}
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					for (int d = 0; d < 4; d++) {
						if (board[i][j] == 0) {
							play(i, j, d);

						}
					}
				}
			}

			sb.append("#").append(tc).append(" ").append(max).append("\n");

		}
		System.out.println(sb);

	}

	public static void play(int r, int c, int d) {
		int p = 0;
		int sr = r;
		int sc = c;
		while (true) {
			r += dy[d];
			c += dx[d];

			int n = board[r][c];
			if (r == sr && c == sc || n == -1) {
				if (p > max) {
					max = p;
				}
				return;
			}
			if (n >= 1 && n <= 5) {// 블록을 만났을 때
				p++;
				d = block[n - 1][d];

			} else if (n >= 6 && n <= 10) { // 웜홀을 만났을 때
				if (r == wormhole[n - 6][0] && c == wormhole[n - 6][2]) {
					r = wormhole[n - 6][1];
					c = wormhole[n - 6][3];
				} else {
					r = wormhole[n - 6][0];
					c = wormhole[n - 6][2];

				}

			}

		}

	}

}