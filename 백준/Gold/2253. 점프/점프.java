import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static boolean disAble[];
	static boolean visited[][];
	static int dp[] = { -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		disAble = new boolean[N + 1];
		visited = new boolean[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			disAble[Integer.parseInt(br.readLine().trim())] = true;
		}

		System.out.println(bfs());
	}

	public static int bfs() {
		if(disAble[2]) {
			return -1;
		}
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 2, 1, 1 });
		visited[1][1] = true;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int p = now[0], x = now[1], jCnt = now[2];
			//System.out.println(p);
			if (p == N) {
				
				return jCnt;
			}
			for (int d = 0; d < 3; d++) {
				int np = p + x + dp[d];
				
				if ((x + dp[d] <= 0) ||  np > N || visited[p][x + dp[d]] || disAble[np]) {
					continue;
				}
				visited[p][x + dp[d]] = true;
				q.add(new int[] { np, x + dp[d], jCnt + 1 });
			}
		}
		return -1;
	}

}
