import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int[][] board;
	static int time;
	static int N;
	static int cnt;
//	static List<Shark> sharkList;

	static int sx, sy; // 상어의 위치
	static int size = 2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		N = Integer.parseInt(br.readLine().trim());
		board = new int[N][N];
		// sharkList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
//				if (n >= 1 && n <= 6) {
//					sharkList.add(new Shark(j, i, n));
//				} else 
				if (n == 9) {
					sx = j;
					sy = i;
					continue;
				}
				board[i][j] = n;
			}
		}
		cnt = 0;
		time = 0;
		while (true) {
			boolean check = false;
			// System.out.println(size + " " + time);
			for (int i = 0; i < N; i++) {

				// System.out.println(Arrays.toString(board[i]));
				for (int j = 0; j < N; j++) {
					if (board[i][j] != 0 && board[i][j] < size) {
						check = true;
						break;
					}
				}

			}
			// System.out.println(check + " " + sy + " " + sx);
			if (!check || !move()) {
				break;
			}

		}
		System.out.println(time);

	}

	public static boolean move() {
		int[] dy = { -1, 0, 0, 1 };
		int[] dx = { 0, -1, 1, 0 };
		boolean visited[][] = new boolean[N][N];
		visited[sy][sx] = true;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { sx, sy, 0 });
		int min_t = Integer.MAX_VALUE;
		int mx = sx, my = sy;
		while (!q.isEmpty()) {
			int now[] = q.poll();
			int x = now[0], y = now[1], t = now[2];

			// System.out.println(x+" "+y);

			if (board[y][x] > 0 && board[y][x] < size) {
				if (min_t > t) {
					min_t = t;
					mx = x;
					my = y;

				} else if (min_t == t) {
					if (my > y) {
						my = y;
						mx = x;

					} else if (my == y) {
						if (mx > x) {
							mx = x;
						}
					}

				}
			}
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[ny][nx] || board[ny][nx] > size) {
					continue;
				}
				visited[ny][nx] = true;
				q.add(new int[] { nx, ny, t + 1 });

			}
		}
		if (min_t != Integer.MAX_VALUE) {
			cnt++;
			if (cnt == size) {
				size += 1;
				cnt = 0;
			}
			// System.out.println(sy + " " + sx + " " + min_t + " " + size + " " +
			// board[sy][sx]);
			time += min_t;
			board[my][mx] = 0;
			sx = mx;
			sy = my;

			return true;
		}

		return false;

	}
}