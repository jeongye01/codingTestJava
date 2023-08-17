import java.io.*;
import java.util.*;

public class Solution {
	static int N, board[][], lineCnt, coreCnt;
	static List<int[]> processorPos;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			lineCnt = 0;
			coreCnt = 0;
			processorPos = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < N; j++) {
					int input = Integer.parseInt(st.nextToken());
					board[i][j] = input;
					if (input == 1) {
						if (i > 0 && i < N - 1 && j > 0 && j < N - 1) {
							processorPos.add(new int[] { i, j });
						}
					}
				}
			}

			bt(0, 0);

			sb.append("#").append(tc).append(" ").append(lineCnt).append("\n");
		}

		System.out.println(sb);

	}

	public static void bt(int idx, int cnt) {

		if (coreCnt <= cnt) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					if (board[i][j] == 2) {
						sum++;
					}
				}

			}
			if (coreCnt < cnt) {
				coreCnt = cnt;
				lineCnt = sum;
			} else if (coreCnt == cnt) {
				lineCnt = Math.min(lineCnt, sum);
			}

		}
		if (idx == processorPos.size()) {
			return;
		}
		int[] pos = processorPos.get(idx);
		int[][] board_copy = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board_copy[i][j] = board[i][j];
			}
		}

		for (int d = 0; d < 4; d++) {
			int nx = pos[1] + dx[d], ny = pos[0] + dy[d];
			boolean canConnect = true;
			while (ny >= 0 && ny < N && nx >= 0 && nx < N) {
				if (board[ny][nx] == 0) {
					board[ny][nx] = 2;
				} else {
					canConnect = false;
					break;
				}
				nx += dx[d];
				ny += dy[d];
			}
			if (canConnect) {

				bt(idx + 1, cnt + 1);
			}

			nx = pos[1] + dx[d];
			ny = pos[0] + dy[d];
			while (ny >= 0 && ny < N && nx >= 0 && nx < N) {
				board[ny][nx] = board_copy[ny][nx];
				nx += dx[d];
				ny += dy[d];
			}

		}
		bt(idx + 1, cnt);

	}
}