

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 지도의 오른쪽은 동쪽, 위쪽은 북쪽이다.
// 가장 처음에 주사위의 이동 방향은 동쪽이다.
//  ans :  각 이동에서 획득하는 점수의 합
public class Main {
	static int ans;
	static int N, M, K;
	static int[][] board;
	static int direction;
	// 동서남북 순서
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };
	static Dice dice;

	static class Dice {
		int x = 0, y = 0;
		int top = 1, bottom = 6;
		int up = 2, left = 4, right = 3, down = 5;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dice = new Dice();
		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());

			}
		}
		solve();
		System.out.println(ans);

	}

	private static void solve() {
		for (int k = 0; k < K; k++) {

			if (direction == 0) {// 동
				right();
			} else if (direction == 1) {// 서
				left();
			} else if (direction == 2) { // 남
				down();
			} else { // 북
				up();
			}

		}
	}

	private static void right() {

		int nx = dice.x + dx[direction];
		int ny = dice.y + dy[direction];
		if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
			direction = 1;
			left();
			return;
		}

		int tmp = dice.bottom;
		dice.bottom = dice.right;
		dice.right = dice.top;
		dice.top = dice.left;
		dice.left = tmp;
		// 점수 구하기
		int B = board[ny][nx];
		ans += bfs(ny, nx, B) * B;
		dice.x = nx;
		dice.y = ny;
		//
		int A = dice.bottom;

		if (A > B) { // 시계 방향 회전
			direction = 2;

		} else if (A < B) { // 반 시계 방향 회전
			direction = 3;

		}

	}

	private static void left() {
		int nx = dice.x + dx[direction];
		int ny = dice.y + dy[direction];

		if (nx < 0 || nx >= M || ny < 0 || ny >= N) {

			direction = 0;
			right();
			return;
		}

		int tmp = dice.bottom;
		dice.bottom = dice.left;
		dice.left = dice.top;
		dice.top = dice.right;
		dice.right = tmp;

		// 점수 구하기
		int B = board[ny][nx];
		ans += bfs(ny, nx, B) * B;
		dice.x = nx;
		dice.y = ny;

		//
		int A = dice.bottom;
		
		if (A > B) { // 시계 방향 회전
			direction = 3;

		} else if (A < B) { // 반 시계 방향 회전
			direction = 2;

		}

	}

	private static void down() {

		int nx = dice.x + dx[direction];
		int ny = dice.y + dy[direction];

		if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
			direction = 3;
			up();
			return;
		}
		
		int tmp = dice.bottom;
		dice.bottom = dice.down;
		dice.down = dice.top;
		dice.top = dice.up;
		dice.up = tmp;
		// 점수 구하기
		int B = board[ny][nx];
		ans += bfs(ny, nx, B) * B;
		dice.x = nx;
		dice.y = ny;
		//
		int A = dice.bottom;

		if (A > B) { // 시계 방향 회전
			direction = 1;

		} else if (A < B) { // 반 시계 방향 회전
			direction = 0;

		}
	}

	private static void up() {

		int nx = dice.x + dx[direction];
		int ny = dice.y + dy[direction];
		if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
			direction = 2;
			down();
			return;
		}
		int tmp = dice.bottom;
		dice.bottom = dice.up;
		dice.up = dice.top;
		dice.top = dice.down;
		dice.down = tmp;
		// 점수 구하기
		int B = board[ny][nx];
		ans += bfs(ny, nx, B) * B;
		dice.x = nx;
		dice.y = ny;

		int A = dice.bottom;

		if (A > B) { // 시계 방향 회전
			direction = 0;

		} else if (A < B) { // 반 시계 방향 회전
			direction = 1;

		}
	}

	private static int bfs(int i, int j, int b) {
		int cnt = 0;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { i, j });
		boolean[][] visited = new boolean[N][M];
		visited[i][j] = true;
		while (!q.isEmpty()) {
			int now[] = q.poll();
			int y = now[0];
			int x = now[1];
			cnt++;
			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if (ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx] || board[ny][nx] != b)
					continue;
				visited[ny][nx] = true;
				q.add(new int[] { ny, nx });

			}
		}

		return cnt;

	}

}
