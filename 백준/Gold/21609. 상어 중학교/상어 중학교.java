

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 색은 M이하의 자연수로 표현한다. 검은색 블록은 -1, 무지개 블록은 0으로 표현
// |r1 - r2| + |c1 - c2| = 1을 만족하는 두 칸 (r1, c1)과 (r2, c2)를 인접한 칸
// 종료 조건 : 블록 그룹이 존재하는 동안
// ans : 획득한 점수의 합 
public class Main {

	static int N, M;
	static int[][] board;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };
	static long ans;

	static class Group implements Comparable<Group> {
		List<int[]> poslist = new ArrayList<>();
		int y, x;
		int cnt, rainbowCnt;
		int color;

		public Group() {

		}

		@Override
		public int compareTo(Group o) {

			if (this.cnt != o.cnt)
				return o.cnt - this.cnt;

			if (this.rainbowCnt != o.rainbowCnt)
				return o.rainbowCnt - this.rainbowCnt;

			if (this.y != o.y)
				return o.y - this.y;

			return o.x - this.x;

		}

		@Override
		public String toString() {
			return "cnt: " + cnt + " rainbowCnt: " + rainbowCnt + " y: " + y + " x: " + x + " color: " + color;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve();
		System.out.println(ans);

	}

	private static void solve() {
//		remove();
//		gravity();
//		rotate(); // 반시계 90도 회전
//		gravity();
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(board[i]));
//		}
		while (remove()) {
			gravity();
			rotate(); // 반시계 90도 회전
			gravity();
		}
	}

	private static boolean remove() {
		PriorityQueue<Group> pq = new PriorityQueue<>();
		boolean[][] visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && board[i][j] > 0 && board[i][j] <= M) {
					bfs(i, j, visited, pq, board[i][j]);
					for (int r = 0; r < N; r++) {
						for (int c = 0; c < N; c++) {
							if (board[r][c] == 0)
								visited[r][c] = false;
						}
					}
				}
			}
		}

		if (pq.isEmpty()) {
			return false;
		} else {
			Group blocks = pq.poll();
			// System.out.println(blocks);
			ans += blocks.cnt * blocks.cnt; // 점수 추가
			// System.out.println(blocks.cnt * blocks.cnt);
			for (int[] pos : blocks.poslist) {
				board[pos[0]][pos[1]] = -2;// 제거

			}
		}
		return true;

	}

	private static void bfs(int i, int j, boolean[][] visited, PriorityQueue<Group> pq, int color) {

		visited[i][j] = true;
		int cnt = 0;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { i, j });
		int my = Integer.MAX_VALUE;
		int mx = Integer.MAX_VALUE;
		Group group = new Group();
		while (!q.isEmpty()) {
			int now[] = q.poll();
			int y = now[0];
			int x = now[1];

			cnt++;
			group.cnt = cnt;
			if (board[y][x] == 0)
				group.rainbowCnt++;
			else {
				if (my > y) {
					my = y;
					mx = x;
				} else if (my == y) {
					mx = Math.min(mx, x);
				}

			}
			group.poslist.add(new int[] { y, x });
			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if (ny < 0 || ny >= N || nx < 0 || nx >= N || board[ny][nx] <= -1 || visited[ny][nx])
					continue;
				if (board[ny][nx] == 0 || board[ny][nx] == color) {
					visited[ny][nx] = true;
					q.add(new int[] { ny, nx });
				}

			}
		}
		group.y = my;
		group.x = mx;
		group.color = color;
		if (group.cnt >= 2) {
			pq.offer(group);

		}

	}

	private static void gravity() {

		for (int j = 0; j < N; j++) {
			for (int i = N - 2; i >= 0; i--) {
				if (board[i][j] >= 0) {
					int color = board[i][j];
					int r = i;
					while (r + 1 < N && board[r + 1][j] == -2) {
						board[r][j] = -2;
						board[r + 1][j] = color;
						r += 1;
					}
				}
			}
		}

	}

	private static void rotate() {
		int[][] board_copy = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board_copy[i][j] = board[j][N - i - 1];
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = board_copy[i][j];
			}
		}

	}

}

/*
 * 5 4 1 0 -1 0 0 2 0 -1 0 0 3 0 -1 0 0 4 0 -1 -1 -1 4 4 1 1 1
 */
