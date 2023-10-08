import java.util.*;
import java.io.*;

public class Main {
	static int M, N, H;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		int[][][] map = new int[H][N][M];
		boolean[][][] visited = new boolean[H][N][M];
		Queue<int[]> q = new LinkedList<>();
		int cnt = 0;
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < M; j++) {
					int input = Integer.parseInt(st.nextToken());
					map[h][i][j] = input;
					if (input == 1) {
						q.add(new int[] { h, i, j, 0 });
						visited[h][i][j] = true;
					} else if (input == 0) {
						cnt++;
					}
				}

			}
		}
		if (cnt == 0) {
			System.out.println(0);
			return;
		}
		int ans = -1;
		int[] dx = { 0, -1, 0, 1 };
		int[] dy = { -1, 0, 1, 0 };
		int[] dh = { -1, 1 };
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int h = now[0], y = now[1], x = now[2], day = now[3];
			for (int d = 0; d < 2; d++) {
				int nh = h + dh[d];
				if (nh < 0 || nh >= H || map[nh][y][x] == -1 || visited[nh][y][x]) {
					continue;
				}
				if (map[nh][y][x] == 0) {
					cnt--;
				}
				if (cnt == 0) {
					ans = day + 1;
					break;
				}
				visited[nh][y][x] = true;
				q.add(new int[] { nh, y, x, day + 1 });
			}
			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d], nx = x + dx[d];
				if (nx < 0 || nx >= M || ny < 0 || ny >= N || map[h][ny][nx] == -1 || visited[h][ny][nx]) {
					continue;
				}
				if (map[h][ny][nx] == 0) {
					cnt--;
				}
				if (cnt == 0) {
					ans = day + 1;
					break;
				}
				visited[h][ny][nx] = true;
				q.add(new int[] { h, ny, nx, day + 1 });
			}

		}
		System.out.println(ans);

	}

}