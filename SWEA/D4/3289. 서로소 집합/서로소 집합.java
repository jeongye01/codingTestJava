

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int n, m;
	static int parents[];
	static StringBuilder ans = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			ans = new StringBuilder();
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			make();
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int o = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (o == 0) {// 합치기
					union(a, b);
				} else {// 같은 집합인지 확인
					if (find(a) == find(b)) {
						ans.append(1);
					}else {
						ans.append(0);
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(ans.toString()).append("\n");
		}
		System.out.println(sb);
	}

	private static void make() {
		parents = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}
	}

	private static int find(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = find(parents[a]);
	}

	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot) {
			return false; // 서로의 대표자가 같은 즉, 같은 집합의 상황이므로 union하지 않음.
		}
		// union 처리 (bRoot를 aRoot아래로 붙이기.임의로)
		if (aRoot < bRoot) {
			parents[bRoot] = aRoot;
		} else {
			parents[aRoot] = bRoot;
		}

		return true;

	}

}
