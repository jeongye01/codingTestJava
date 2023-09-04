import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, M, coins[], dp[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			coins = new int[N];
			dp = new int[10001];
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < N; i++) {
				coins[i] = Integer.parseInt(st.nextToken());
			}
			dp[0] = 1;
			M = Integer.parseInt(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				for (int i = 1; i <= M; i++) {

					if (i - coins[j] >= 0) {
						dp[i] += dp[i - coins[j]];
					}

				}

			}
			sb.append(dp[M]).append("\n");

		}
		System.out.println(sb);

	}

}