import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, M;
	static char[][] board;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		int x = 0, y = 0;
		for (int i = 0; i < N; i++) {
			char[] chrs = br.readLine().trim().toCharArray();
			for (int j = 0; j < M; j++) {
				board[i][j] = chrs[j];
				if (board[i][j] == 'I') {
					y = i;
					x = j;
				}
			}
		}
		bfs(y, x);

		System.out.println(ans == 0 ? "TT" : ans);

	}

	public static void bfs(int i, int j) {
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { i, j });
		visited[i][j] = true;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			if (board[now[0]][now[1]] == 'P')
				ans++;
			for (int d = 0; d < 4; d++) {
				int ny = now[0] + dy[d];
				int nx = now[1] + dx[d];
				if (ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx] || board[ny][nx] == 'X')
					continue;
				visited[ny][nx] = true;
				q.add(new int[] { ny, nx });

			}

		}
	}

}