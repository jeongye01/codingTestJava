

import java.util.*;
import java.io.*;

public class Main {
	static int[][] board = new int[9][9];
	static List<int[]> blank;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
		blank = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 0) {
					blank.add(new int[] { i, j });
				}
			}

		}
		bt(0);
	}

	public static void bt(int cnt) {
		if (blank.size() == cnt) {
			write();
			flag = true;
			return;
		}
		boolean[] notUsed = new boolean[10];
		int[] pos = blank.get(cnt);
		int y = pos[0], x = pos[1];
		for (int i = 0; i < 9; i++) {
			notUsed[board[i][x]] = true;
		}
		for (int j = 0; j < 9; j++) {
			notUsed[board[y][j]] = true;
		}
		int sy = (y / 3) * 3, sx = (x / 3) * 3;
		for (int i = sy; i < sy + 3; i++) {
			for (int j = sx; j < sx + 3; j++) {
				notUsed[board[i][j]] = true;
			}
		}
		for (int i = 1; i <= 9; i++) {
			if (!notUsed[i]) {
				board[y][x] = i;
				bt(cnt + 1);
				if (flag) {
					return;
				}
				board[y][x] = 0;
			}
		}
	}

	public static void write() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(board[i][j]).append(" ");
			}
			sb.append("\n");

		}
		System.out.println(sb);
	}

}