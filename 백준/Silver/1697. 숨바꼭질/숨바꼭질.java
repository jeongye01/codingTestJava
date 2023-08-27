import java.util.*;
import java.io.*;

public class Main {
	static int N, K, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		move();

		System.out.println(ans);

	}

	private static void move() {
		Deque<int[]> q = new ArrayDeque<>();
		int[] visited = new int[100001];
		q.add(new int[] { N, 0 });

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int pos = now[0], cnt = now[1];
			// System.out.println(pos+" "+cnt);
			if (pos == K) {
				ans = cnt;
				return;
			}

			int[] toGo = { pos + 1, pos - 1, pos * 2 };
			for (int np : toGo) {
				if ( np >= 0 && np <= 100000 && visited[np] == 0) {
					q.add(new int[] { np, cnt + 1 });
					visited[np] = 1;
				}

			}

		}

	}

}