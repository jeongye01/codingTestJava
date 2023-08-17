import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Solution {
	static int N, ans, arrX[], arrY[], order[];
	static int office[] = new int[2], home[] = new int[2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			ans = Integer.MAX_VALUE;
			arrX = new int[N];
			arrY = new int[N];
			order = new int[N];
			st = new StringTokenizer(br.readLine().trim());
			
			office[0] = Integer.parseInt(st.nextToken());
			office[1] = Integer.parseInt(st.nextToken());
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());
		
		
			for (int i = 0; i < N; i++) {
				arrX[i] = Integer.parseInt(st.nextToken());
				arrY[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < N; i++) {
				order[i] = i;
			}
			do {
				// System.out.println(Arrays.toString(order));
				calcDistance();

			} while (NP(order));
			sb.append("#").append(tc).append(" ").append(ans).append("\n");

		}
		System.out.println(sb);
	}

	private static boolean NP(int[] p) {
		int i = N - 1;
		while (i > 0 && p[i - 1] >= p[i])
			--i;
		while (i == 0)
			return false;
		int j = N - 1;
		while (p[i - 1] >= p[j])
			--j;
		swap(p, i - 1, j);
		int k = N - 1;
		while (i < k)
			swap(p, i++, k--);
		return true;

	}

	private static void swap(int[] p, int a, int b) {
		int temp = p[a];
		p[a] = p[b];
		p[b] = temp;
	}

	private static void calcDistance() {
		int tmp = Math.abs(arrX[order[0]] - office[0]) + Math.abs(arrY[order[0]] - office[1]);
		if (tmp > ans) {
			return;
		}
		for (int i = 1; i < N; i++) {
			int cur = order[i];
			int prev = order[i - 1];
			tmp += (Math.abs(arrX[cur] - arrX[prev]) + Math.abs(arrY[cur] - arrY[prev]));
			if (tmp > ans) {
				return;
			}
		}
		tmp += Math.abs(arrX[order[N-1]] - home[0]) + Math.abs(arrY[order[N-1]] - home[1]);
		if (tmp >= ans) {
			return;
		}

		ans = tmp;
	}

}