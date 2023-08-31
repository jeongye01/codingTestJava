
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine().trim());
			int K = Integer.parseInt(br.readLine().trim());
			int dp[][] = new int[N + 1][K + 1];
			
				for (int j = 1; j < K + 1; j++) {
					dp[0][j] = j;
				}

			
			for (int i = 1; i < N + 1; i++) {
				int tmp =0;
				for (int j = 1; j < K + 1; j++) {
					tmp += dp[i-1][j];
					dp[i][j] = tmp;
				
				}

			}
			sb.append(dp[N][K]).append('\n');
		}
		System.out.println(sb);

	}
}