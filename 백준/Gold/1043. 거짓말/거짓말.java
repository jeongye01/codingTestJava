import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, M;
	static List<List<Integer>> list1, list2;
	static int visited1[];
	static int visited2[];
	static int know[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited1 = new int[N];
		visited2 = new int[M];
		list1 = new ArrayList<>();
		list2 = new ArrayList<>();
		know = new int[N];
		for (int i = 0; i < N; i++) {
			list1.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			list2.add(new ArrayList<>());
		}
		st = new StringTokenizer(br.readLine().trim());
		int cnt= Integer.parseInt(st.nextToken());
		for (int i = 0; i < cnt; i++) {
			know[Integer.parseInt(st.nextToken()) - 1] = 1;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			cnt= Integer.parseInt(st.nextToken());
			for (int j = 0; j <cnt; j++) {
				int f=Integer.parseInt(st.nextToken()) - 1;
				list1.get(f).add(i);
				list2.get(i).add(f);
			}
		}
		for (int i = 0; i < N; i++) {
			if (know[i] == 1) {
				bfs(i);
			}

		}
		int ans = 0;
		for (int i = 0; i < M; i++) {

			if (visited2[i] == 0) {
				ans++;
			}

		}
		System.out.println(ans);
	}

	public static void bfs(int st) {

		visited1[st] = 1;
		Queue<Integer> q = new LinkedList<>();
		q.offer(st);
		while (!q.isEmpty()) {
			int now = q.poll();
			for (Integer party : list1.get(now)) {
				for (Integer node : list2.get(party)) {
					visited2[party] = 1;
					if (visited1[node] == 0) {
						visited1[node] = 1;
						q.offer(node);
					}

				}

			}

		}

	}
}