import java.io.*;
import java.util.*;

// ans : 지훈이가 미로를 탈출할 수 있는 경우에는 가장 빠른 탈출시간
public class Main {
	static int R, C;
	static int[][] board;
	static int[][] fireBoard;
	static Queue<int[]> fq = new LinkedList<>();
	static boolean visited2[][];
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			board = new int[R][C];
			fireBoard = new int[R][C];
			visited2 = new boolean[R][C];
			int iy = 0, ix = 0;

			for (int i = 0; i < R; i++) {
				char[] chrs = br.readLine().trim().toCharArray();
				for (int j = 0; j < C; j++) {
					if (chrs[j] == '@') {
						iy = i;
						ix = j;
						board[i][j] = 1;
						continue;
					} else if (chrs[j] == '#') {
						board[i][j] = 2;
					} else if (chrs[j] == '*') {
						board[i][j] = 3;
						fq.add(new int[] { i, j, 0 });
						visited2[i][j] = true;

					} else if (chrs[j] == '.') {
						board[i][j] = 1;
					}

				}
			}

			fire();

			int ans = bfs(iy, ix);
			System.out.println(ans == -1 ? "IMPOSSIBLE" : ans);
		}

	}

	private static void fire() {
		while (!fq.isEmpty()) {

			int now[] = fq.poll();
			int y = now[0];
			int x = now[1];
			int t = now[2];
			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if (ny < 0 || ny >= R || nx < 0 || nx >= C || visited2[ny][nx] || board[ny][nx] != 1)
					continue;
				visited2[ny][nx] = true;
				fireBoard[ny][nx] = t + 1;
				fq.add(new int[] { ny, nx, t + 1 });

			}
		}
//		for (int i = 0; i < R ; i++) {
//			System.out.println(Arrays.toString(fireBoard[i]));
//		}

	}

	private static int bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[R][C];
		q.add(new int[] { i, j, 0 });
		visited[i][j] = true;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int y = now[0];
			int x = now[1];
			int cnt = now[2];

			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if (ny < 0 || ny >= R || nx < 0 || nx >= C)
					return cnt + 1;

				if (visited[ny][nx] || board[ny][nx] == 2 || board[ny][nx] == 3)
					continue;
				// System.out.println(fireBoard[ny][nx] +" "+( cnt + 1)+" "+ny+" "+nx);
				if (fireBoard[ny][nx] <= cnt + 1 && visited2[ny][nx])
					continue;
				visited[ny][nx] = true;
				q.add(new int[] { ny, nx, cnt + 1 });

			}

		}

		return -1;
	}

}