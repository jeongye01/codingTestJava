import java.util.*;
import java.io.*;

public class Main {
	static int N, M, ans, board[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		ans = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			String s = br.readLine().trim();
			for (int j = 0; j < M; j++) {
				board[i][j] = s.charAt(j) == 'W' ? 1 : 0;
			}
		}
		for (int i = 0; i < N - 7; i++) {
			for (int j = 0; j < M - 7; j++) {
				checkCnt(1, i, j);
				checkCnt(0, i, j);
			}
		}

		System.out.println(ans);
	}

	public static void checkCnt(int flag, int i, int j) {
	
		int cnt = 0;
		for (int y = i; y < i + 8; y++) {
			for (int x = j; x < j + 8; x++) {
				if (board[y][x] != flag) {
					cnt++;
				}
				if (x != j + 7) {
					flag = flag == 1 ? 0 : 1;
				}
			}
		}
		ans = Math.min(ans, cnt);
	}
}