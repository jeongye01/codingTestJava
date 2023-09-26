import java.io.*;
import java.util.*;

public class Main {
	static List<List<Integer[]>> list;
	static int max_idx, max;
	static boolean visited[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		list = new ArrayList<>();
		max = 0;
		for (int i = 0; i < N; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			list.get(a).add(new Integer[] { b, c });
			list.get(b).add(new Integer[] { a, c });

		}
		visited = new boolean[N];
		dfs(0, 0);
		visited = new boolean[N];
		dfs(max_idx, 0);
		System.out.println(max);

	}

	public static void dfs(int idx, int w) {
		if (w > max) {
			max_idx = idx;
			max = w;
		}
		visited[idx] = true;
		for (Integer[] node : list.get(idx)) {
			if (!visited[node[0]]) {

				dfs(node[0], node[1] + w);
			}
		}

	}

}