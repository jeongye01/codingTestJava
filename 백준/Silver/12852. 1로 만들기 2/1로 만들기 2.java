import java.util.*;
import java.io.*;

public class Main {
	static int history[];
	static boolean flag;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());

		int[] dp = new int[N + 1];
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + 1;
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
			}
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
			}

		}
		sb.append(dp[N]).append('\n');
		history = new int[dp[N] + 1];
		history[0] = N;
		getHistory(1, dp[N] + 1);
		System.out.println(sb);
	}

	public static void getHistory(int cnt, int size) {

		if (cnt == size) {
			if (history[size - 1] == 1) {
				for (int i = 0; i < size; i++) {
					sb.append(history[i]).append(' ');
				}

				flag = true;
			}
			return;
		}

		history[cnt] = history[cnt - 1] - 1;
		getHistory(cnt + 1, size);
		if (flag)
			return;
		if (history[cnt - 1] % 2 == 0) {
			history[cnt] = history[cnt - 1] / 2;
			getHistory(cnt + 1, size);
		}
		if (flag)
			return;
		if (history[cnt - 1] % 3 == 0) {
			history[cnt] = history[cnt - 1] / 3;
			getHistory(cnt + 1, size);
		}

	}

}