import java.util.*;
import java.io.*;

public class Main {
	static int board[];
	static int N, M;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[100];

		for (int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			board[x] = y;
		}
		bfs();
		System.out.println(ans);

	}

	public static void bfs() {
		Deque<int[]> q = new LinkedList<>();
		boolean[] visited = new boolean[100];
		q.offer(new int[] { 0, 0 });

		visited[0] = true;
		while (!q.isEmpty()) {
			int now[] = q.poll();
			int i = now[0], cnt = now[1];
			//System.out.println(i);
			if (i == 99) {

				ans = cnt;
				return;
			}

			for (int t = 1; t <= 6; t++) {
				int ni = i + t;

				if (ni >= 100 || visited[ni]) {
					continue;
				}
				visited[ni] = true;
				if (board[ni] == 0) {
					q.offer(new int[] { ni, cnt + 1 });
				} else {
					// visited[ny][nx] = true;
					ni = board[ni];
					q.offer(new int[] { ni, cnt + 1 });
				}

			}

		}

	}

}