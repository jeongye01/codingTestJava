import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] board = new int[N][N];
			int num = 1, row = 0, col = 0;
			int[] dx = { 1, 0, -1, 0 };
			int[] dy = { 0, 1, 0, -1 };
			int d = 0;
			for (int i = 0; i < N * N; i++) {
				board[row][col] = num;
				int drow = row + dy[d];
				int dcol = col + dx[d];
				if (drow < 0 || drow >= N || dcol < 0 || dcol >= N || board[drow][dcol] != 0) {
					d = (d + 1) % 4;
				}
				row += dy[d];
				col += dx[d];
				num += 1;

			}
			System.out.println("#" + tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
		}

	}

}