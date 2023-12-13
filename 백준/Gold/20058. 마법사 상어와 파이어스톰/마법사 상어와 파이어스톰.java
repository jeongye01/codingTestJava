import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// A[r][c]는 (r, c)에 있는 얼음의 양을 의미
//
// ans1 : 남아있는 얼음 A[r][c]의 합
// ans2 : 남아있는 얼음 중 가장 큰 덩어리가 차지하는 칸의 개수
public class Main {

	static int N, Q;
	static int size;
	static int[][] board;
	static int sum, cnt;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		size = (int) Math.pow(2, N);
		board = new int[size][size];

		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < size; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}

		}
		st = new StringTokenizer(br.readLine().trim());

		for (int i = 0; i < Q; i++) {
			solve(Integer.parseInt(st.nextToken()));
		}
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				sum += board[i][j];
			}

		}
		cnt = findBiggest();
		sb.append(sum).append('\n').append(cnt);

		System.out.println(sb);

	}

	public static void solve(int L) {
		int[][] board2 = new int[size][size];

		for (int q = 0; q < 1; q++) {
			int gap = (int) Math.pow(2, L);
			// rotate(0, 0, gap, board2);
			for (int r = 0; r < size; r += gap) {
				for (int c = 0; c < size; c += gap) {
					rotate(r, c, gap, board2);

				}
			}

			for (int r = 0; r < size; r++) {
				for (int c = 0; c < size; c++) {
					board[r][c] = board2[r][c];

				}
			}
//			for (int r = 0; r < size; r++) {
//				System.out.println(Arrays.toString(board[r]));
//			}

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					int ice = 0;
					for (int d = 0; d < 4; d++) {
						int ny = i + dy[d];
						int nx = j + dx[d];
						if (ny < 0 || ny >= size || nx < 0 || nx >= size)
							continue;
						if (board2[ny][nx] > 0)
							ice++;

					}

					if (ice < 3 && board2[i][j] > 0) {

						board[i][j] -= 1;
					}

				}

			}
		}

	}

	public static void rotate(int sr, int sc, int gap, int[][] board2) {

		for (int r = 0; r < gap; r++) {
			for (int c = 0; c < gap; c++) {
				board2[r + sr][c + sc] = board[sr + gap - 1 - c][sc + r];
			}
		}

	}

	public static int findBiggest() {
		int big = 0;
		boolean[][] visited = new boolean[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (!visited[i][j] && board[i][j] > 0) {
					big = Math.max(bfs(i, j, visited), big);
				}
			}
		}

		return big;

	}

	public static int bfs(int i, int j, boolean[][] visited) {
		visited[i][j] = true;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { i, j });
		int res = 0;
		while (!q.isEmpty()) {
			int now[] = q.poll();
			res++;
			for (int d = 0; d < 4; d++) {
				int ny = now[0] + dy[d];
				int nx = now[1] + dx[d];
				if (ny < 0 || ny >= size || nx < 0 || nx >= size || visited[ny][nx] || board[ny][nx] <= 0)
					continue;
				visited[ny][nx] = true;
				q.add(new int[] { ny, nx });

			}

		}
		return res;
	}

}