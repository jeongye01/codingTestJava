import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	static int N;
	static int board[][];
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			int num = 1, row = 0, col = 0, d = 0;
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
			StringBuilder s = new StringBuilder("#");
			s.append(tc).append("\n");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					s.append(board[i][j]).append(" ");
				}
				s.append("\n");
			}
			bw.write(s.toString());
		}
		bw.flush();
		bw.close();
	}
}