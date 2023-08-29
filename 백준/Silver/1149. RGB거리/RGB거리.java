import java.util.*;
import java.io.*;

public class Main {

	static int N, ans;
	static int arr[][], dp[][];
	static int[][] color = { { 1, 2 }, { 0, 2 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine().trim());
		ans = Integer.MAX_VALUE;
		arr = new int[3][N];
		dp = new int[3][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			arr[0][i] = Integer.parseInt(st.nextToken());
			arr[1][i] = Integer.parseInt(st.nextToken());
			arr[2][i] = Integer.parseInt(st.nextToken());

		}
		for (int c = 0; c < N; c++) {
			for (int r = 0; r < 3; r++) {
				dp[r][c] = arr[r][c];

			}

		}
		for (int c = 1; c < N; c++) {
			for (int r = 0; r < 3; r++) {
				dp[r][c] = Math.min(dp[color[r][0]][c - 1] + arr[r][c], dp[color[r][1]][c - 1] + arr[r][c]);

			}

		}
		ans = Math.min(dp[0][N - 1], dp[1][N - 1]);
		ans = Math.min(ans, dp[2][N - 1]);
		System.out.println(ans);

	}

}