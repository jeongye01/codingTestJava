
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// ans : 모든 승객을 성공적으로 데려다줄 수 있는지 알아내고, 데려다줄 수 있을 경우 최종적으로 남는 연료의 양
public class Main {

	static int N, M;
	static int[] dx = { 0, -1, 1, 0 };
	static int[] dy = { -1, 0, 0, 1 };
	static int fuel;
	static int y, x;
	static int[][] board;
	static HashMap<Integer, Man> map = new HashMap<>();

	static class Man {
		int ex, ey;

		public Man(int ey, int ex) {

			this.ex = ex;
			this.ey = ey;

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine().trim());
		y = Integer.parseInt(st.nextToken()) - 1;
		x = Integer.parseInt(st.nextToken()) - 1;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim());

			int sy = Integer.parseInt(st.nextToken()) - 1;
			int sx = Integer.parseInt(st.nextToken()) - 1;
			int ey = Integer.parseInt(st.nextToken()) - 1;
			int ex = Integer.parseInt(st.nextToken()) - 1;
			board[sy][sx] = i + 2; // // 승객 번호는 2부터 시작
			map.put(i + 2, new Man(ey, ex));

		}
		solve();

		System.out.println(fuel);

	}

	public static void solve() {
		while (map.size() > 0 && fuel > 0) {
			int shortest = Integer.MAX_VALUE;
			int shortestNum = -1;
			int cost = Integer.MAX_VALUE;
			int sy = -1, sx = -1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] >= 2) {
						int dist = bfs(i, j);
						//System.out.println(dist+" "+board[i][j]+" "+y+" "+x);
						if (shortest > dist) {
							int tcost = costbfs(i, j, board[i][j]);
							if (tcost == Integer.MAX_VALUE)
								continue;
							shortestNum = board[i][j];
							shortest = dist;
							cost = tcost;
							sy = i;
							sx = j;
						}
					}
				}
			}
			if (shortestNum != -1) {
				if (fuel - shortest <= 0 || fuel - shortest - cost < 0) {
					//System.out.println(1);
					fuel = -1;
					return;
				}
				fuel = fuel - shortest + cost;

				Man m = map.get(shortestNum);
				y = m.ey;
				x = m.ex;
				map.remove(shortestNum);
				//System.out.println(shortestNum+" 지움 ");
				board[sy][sx] = 0;
			} else {
				//System.out.println(2);
				fuel = -1;
				return;
			}

		}
		if (map.size() > 0 && fuel <= 0) {
			fuel = -1;
		}
	}

	public static int costbfs(int sy, int sx, int n) {

		boolean visited[][] = new boolean[N][N];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { sy, sx, 0 });
		visited[sy][sx] = true;
		Man m = map.get(n);
		
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int distance = now[2];
			if (now[0] == m.ey && now[1] == m.ex) {
				return distance;
			}
			for (int d = 0; d < 4; d++) {
				int ny = now[0] + dy[d];
				int nx = now[1] + dx[d];
				if (ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx] || board[ny][nx] == 1)
					continue;
				visited[ny][nx] = true;
				q.add(new int[] { ny, nx, distance + 1 });
			}
		}
		return Integer.MAX_VALUE;
	}

	public static int bfs(int sy, int sx) {

		boolean visited[][] = new boolean[N][N];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { y, x, 0 });
		visited[y][x] = true;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int distance = now[2];
			//System.out.println(distance);
			if (now[0] == sy && now[1] == sx) {
				return distance;
			}
			for (int d = 0; d < 4; d++) {
				int ny = now[0] + dy[d];
				int nx = now[1] + dx[d];
				if (ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx] || board[ny][nx] == 1)
					continue;
				visited[ny][nx] = true;
				q.add(new int[] { ny, nx, distance + 1 });
			}
		}
		return Integer.MAX_VALUE;
	}

}
