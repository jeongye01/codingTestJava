import java.io.*;
import java.util.*;

public class Main {
	static boolean board[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine().trim());
		board = new boolean[N][N];
		printStar(0, 0, N);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				bw.write(board[i][j] ? '*' : ' ');
			}
			bw.write("\n");

		}
		bw.flush();
	}

	public static void printStar(int x, int y, int k) {
		if (k == 0) {
			board[y][x] = true;
			return;
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 1 && j == 1) {
					continue;
				}
				printStar(x + j * k / 3, y + i * k / 3, k / 3);
			}

		}

	}

}