import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// ans :원숭이가 최소한의 동작으로 시작지점에서 도착지점까지 갈 수 있는 방법( 시작점에서 도착점까지 갈 수 없는 경우엔 -1을 출력)
public class Main {
	static int K, W, H;
	static int[][] board;
	static int dx[] = { 0, -1, 0, 1 };
	static int dy[] = { -1, 0, 1, 0 };
	static int hdx[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int hdy[] = { -2, -1, 1, 2, 2, 1, -1, -2 };

	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		board = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < W; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(bfs());

	}

	private static int bfs() {
		boolean[][][] visited = new boolean[H][W][K+1];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0, 0, 0 });
		
		visited[0][0][0] = true;
		
		while (!q.isEmpty()) {
			int now[] = q.poll();
			int y = now[0];
			int x = now[1];
			int cnt = now[2];
			int k = now[3];
			//System.out.println(y + " " + x);
			if (y == H - 1 && x == W - 1)
				return cnt;
			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if (ny < 0 || ny >= H || nx < 0 || nx >= W || board[ny][nx] == 1)
					continue;

				if (!visited[ny][nx][k]) {
					visited[ny][nx][k] = true;
					q.add(new int[] { ny, nx, cnt + 1, k });
				}

			}
			if (k+1 <= K) {
				for (int d = 0; d < 8; d++) {
					int ny = y + hdy[d];
					int nx = x + hdx[d];
					if (ny < 0 || ny >= H || nx < 0 || nx >= W || board[ny][nx] == 1)
						continue;

					if (!visited[ny][nx][k+1]) {
						visited[ny][nx][k+1] = true;
						q.add(new int[] { ny, nx, cnt + 1, k + 1 });
					}

				}

			}

		}
		return -1;

	}

}