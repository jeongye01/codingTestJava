import java.io.*;
import java.util.*;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int[][][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		dp = new int[51][51][51];

		while (true) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a == -1 && b == -1 && c == -1)
				break;

			sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(w(a, b, c))
					.append('\n');

		}

		System.out.println(sb);
	}

	private static int w(int a, int b, int c) {
		if (a <= 0 || b <= 0 || c <= 0)
			return 1;
		if (dp[a][b][c] > 0)
			return dp[a][b][c];
		int tmp = 0;
		if (a > 20 || b > 20 || c > 20)
			tmp = w(20, 20, 20);

		else if (a < b && b < c)
			tmp = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
		else
			tmp = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
		dp[a][b][c] = tmp;
		return tmp;

	}

}