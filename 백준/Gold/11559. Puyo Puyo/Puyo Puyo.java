import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 뿌요는 중력의 영향을 받아 아래에 바닥이나 다른 뿌요가 나올 때까지 아래로 떨어진다.
// 같은 색 뿌요가 4개 이상 상하좌우로 연결되어 있으면 연결된 같은 색 뿌요들이 한꺼번에 없어진다. 이때 1연쇄가 시작된다.

// ans : 현재 주어진 상황에서 몇연쇄가 되는지 출력한다. 하나도 터지지 않는다면 0을 출력한다.
public class Main {
	static int N = 12, M = 6;
	static char[][] board;
	static int dx[] = { 0, -1, 0, 1 };
	static int dy[] = { -1, 0, 1, 0 };

	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine().trim());
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		for (int i = 0; i < N; i++) {
			char chrs[] = br.readLine().trim().toCharArray();
			for (int j = 0; j < M; j++) {
				board[i][j] = chrs[j];
			}
		}
		solve();
		System.out.println(ans);

	}

	private static void solve() {

		while (pop()) {
			ans++;
			gravity();
//			for (int a = 0; a < N; a++) {
//				System.out.println(Arrays.toString(board[a]));
//			}
//			System.out.println();
		}
	}

	private static boolean pop() {

		boolean check = false;
		boolean visited[][] = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && board[i][j] != '.') {
					if (bfs(i, j, visited, board[i][j]) >= 4) {
						check = true;

					}

				}
			}
		}

		return check;

	}

	private static int bfs(int i, int j, boolean[][] visited, char c) {
		int cnt = 0;

		Queue<int[]> q1 = new LinkedList<>();
		Queue<int[]> q2 = new LinkedList<>();
		q1.add(new int[] { i, j });
		visited[i][j] = true;
		while (!q1.isEmpty()) {
			int now[] = q1.poll();
			int y = now[0];
			int x = now[1];
			q2.add(new int[] { y, x });
			cnt++;
			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if (ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx] || board[ny][nx] != c)
					continue;
				visited[ny][nx] = true;
				q1.add(new int[] { ny, nx });
			}
		}
		if (cnt >= 4) {
			while (!q2.isEmpty()) {
				int now[] = q2.poll();
				int y = now[0];
				int x = now[1];
				board[y][x] = '.';
			}
		}

		return cnt;
	}

	private static void gravity() {
		for (int j = 0; j < M; j++) {
			for (int i = N - 2; i >= 0; i--) {
				if (board[i][j] == '.')
					continue;
				int k = i;
				char tmp = board[k][j];
				while (k + 1 < N && board[k + 1][j] == '.') {
					board[k][j] = '.';
					k++;
				}
				board[k][j] = tmp;

			}
		}
	}

}
