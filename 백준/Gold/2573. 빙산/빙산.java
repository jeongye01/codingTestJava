import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, M;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

	static int board[][];
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = 0;
		melt();
		System.out.println(ans);
	}

	public static void melt() {
		while (true) {
			int pieces = pieces();
			if (pieces == 0) {
				ans = 0;
				return;
			} else if (pieces >= 2) {
				return;
			}
			ans++;
			int[][] boardCopy = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					boardCopy[i][j] = board[i][j];

				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					for (int d = 0; d < 4; d++) {
						int di = i + dy[d];
						int dj = j + dx[d];
						if (di >= 0 && di < N && dj >= 0 && dj < M && boardCopy[di][dj] == 0 && board[i][j] > 0) {
							board[i][j] -= 1;
						}
					}

				}
			}
		
		}

	}

	public static void bfs(int i, int j, int[][] boardCopy) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { i, j });
		boardCopy[i][j] = 0;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int y = now[0], x = now[1];
			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if (ny < 0 || ny >= N || nx < 0 || nx >= M || boardCopy[ny][nx] == 0) {
					continue;
				}
				boardCopy[ny][nx] = 0;
				q.add(new int[] { ny, nx });

			}
			
		}

	}

	public static int pieces() {
		int cnt = 0;
		int[][] boardCopy = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				boardCopy[i][j] = board[i][j];

			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (boardCopy[i][j] > 0) {
					bfs(i, j, boardCopy);
					cnt++;
				}

			}
		}

		return cnt;
	}

}