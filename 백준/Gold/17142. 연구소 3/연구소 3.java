import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//활성 바이러스가 비활성 바이러스가 있는 칸으로 가면 비활성 바이러스가 활성으로 변한다.
// 모든 빈 칸에 바이러스를 퍼뜨리는 최소 시간
public class Main {

	static int N, M;
	static int[][] board;
	static List<int[]> virus;
	static int[] selected;
	static boolean[] visited;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		selected = new int[M];
		ans = Integer.MAX_VALUE;
		board = new int[N][N];
		virus = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 2) {
					virus.add(new int[] { i, j });
				}
			}
		}
		visited = new boolean[virus.size()];
		pick(0, 0);
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

	}

	public static int getTime() {

		int[] dx = { 0, -1, 0, 1 };
		int[] dy = { -1, 0, 1, 0 };
		Queue<int[]> q = new LinkedList<>();
		int[][] boardCopy = new int[N][N];
		int zCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				boardCopy[i][j] = board[i][j];
				if (boardCopy[i][j] == 0) {
					zCnt++;
				}
			}
		}
		if (zCnt == 0)
			return 0;
		for (int s = 0; s < M; s++) {
			int v[] = virus.get(selected[s]);
			boardCopy[v[0]][v[1]] = 3;
			q.add(new int[] { v[0], v[1], 0 });
		}

		while (!q.isEmpty() && zCnt > 0) {
			int now[] = q.poll();
			int y = now[0], x = now[1], t = now[2];
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || boardCopy[ny][nx] == 1 || boardCopy[ny][nx] == 3)
					continue;
				if (boardCopy[ny][nx] == 0) {
					zCnt--;
				}
				if (zCnt == 0) {
					return t + 1;
				}
				boardCopy[ny][nx] = 3;

				q.add(new int[] { ny, nx, t + 1 });

			}

		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (boardCopy[i][j] == 0) {

					return Integer.MAX_VALUE;
				}

			}
		}
		return 0;
	}

	public static void pick(int idx, int cnt) {

		if (cnt == M) {

			int t = getTime();
			// System.out.println(t);
			ans = Math.min(t, ans);
			return;
		}
		for (int i = idx; i < virus.size(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				selected[cnt] = i;
				pick(i + 1, cnt + 1);
				visited[i] = false;
			}
		}
	}

}