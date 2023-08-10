import java.io.*;
import java.util.*;

public class Solution {
	static int record[][], N, ans;
	static int[] classify;

	private static void comb(int idx) {
		if (idx == N) {
			int food1 = 0, food2 = 0;
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					if (classify[i] == 1 && classify[j] == 1) {
						food1 += record[i][j] + record[j][i];
					} else if (classify[i] == 2 && classify[j] == 2) {
						food2 += record[i][j] + record[j][i];
					}
				}
			}
			ans = Math.min(ans, Math.abs(food1 - food2));
			return;
		}
		classify[idx] = 1;
		comb(idx + 1);
		classify[idx] = 2;
		comb(idx + 1);

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			ans = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			record = new int[N][N];
			classify = new int[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					record[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			comb(0);
			System.out.println("#" + tc + " " + ans);
		}

	}

}
