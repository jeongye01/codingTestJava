import java.util.*;
import java.io.*;

public class Main {

	static int K, W, H, ans;
	static int board[][];
	static boolean visited[][][];
	// 말 움직임 정의
	static int dhx[] = { 1, -1, -1, 1, 2, 2, -2, -2 };
	static int dhy[] = { 2, 2, -2, -2, -1, 1, -1, 1 };
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine().trim());
		ans = Integer.MAX_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		board = new int[H][W];
		visited = new boolean[H][W][K + 1];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < W; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());

			}
		}

		System.out.println(go());
	}

	public static int go() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0, 0, K });
		visited[0][0][K] = true;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0], y = now[1], m = now[2], k = now[3];
			// System.out.println(x+" "+y);
			if (x == W - 1 && y == H - 1) {
				return m;

			}
			for (int d = 0; d < 8; d++) {
				int nx = x + dhx[d], ny = y + dhy[d];
				if (nx < 0 || nx >= W || ny < 0 || ny >= H || k == 0 || visited[ny][nx][k - 1] || board[ny][nx] == 1) {
					continue;
				}
				visited[ny][nx][k - 1] = true;
				q.offer(new int[] { nx, ny, m + 1, k - 1 });
			}
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d], ny = y + dy[d];
				if (nx < 0 || nx >= W || ny < 0 || ny >= H || visited[ny][nx][k] || board[ny][nx] == 1) {
					continue;
				}
				visited[ny][nx][k] = true;
				q.offer(new int[] { nx, ny, m + 1, k });
			}
		}
		return -1;
	}

}
