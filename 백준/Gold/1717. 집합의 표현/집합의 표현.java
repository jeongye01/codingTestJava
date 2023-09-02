
import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		make();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int o = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (o == 0) {
				union(a, b);

			} else {
				sb.append(find(a) == find(b) ? "YES" : "NO").append("\n");
			}
		}

		System.out.println(sb);
	}

	public static void make() {
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}

	}

	public static int find(int i) {
		if (i == parents[i])
			return i;
		return parents[i] = find(parents[i]);
	}

	public static void union(int a, int b) {
		int ra = find(a);
		int rb = find(b);
		if (ra == rb) {
			return;
		} else if (ra < rb) {
			parents[rb] = ra;
		} else {
			parents[ra] = rb;
		}

	}

}
