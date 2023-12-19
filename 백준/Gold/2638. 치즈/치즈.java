
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 4변 중에서 적어도 2변 이상이 실내온도의 공기와 접촉한 것은 정확히 한시간만에 녹아 없어져 버린다. 
// 치즈 내부에 있는 공간은 치즈 외부 공기와 접촉하지 않는 것으로 가정한다. 
// ans : 입력으로 주어진 치즈가 모두 녹아 없어지는데 걸리는 정확한 시간
public class Main {
	static int N, M;
	static int[][] board;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };
	static Queue<int[]> cq = new LinkedList<>();
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N + 2][M + 2]; // 임의로 바깥 추가. 무조건 외부 공기임, 2-> 바깥공기

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 1; j <= M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1) {
					cq.add(new int[] { i, j });
				}
			}
		}
		checkOuter();
		
		solve();
		System.out.println(ans);

	}

	private static void solve() {
		while (!cq.isEmpty() ) {
//			for (int i = 0; i <N+2; i++) {
//				System.out.println(Arrays.toString(board[i]));
//			}
			ans++;
			int size = cq.size();
		//	System.out.println(size);
			for (int t = 0; t < size; t++) {

				int[] cheese = cq.poll();
				int y = cheese[0];
				int x = cheese[1];
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					int ny = y + dy[d];
					int nx = x + dx[d];
					if (ny < 0 || ny >= N +2|| nx < 0 || nx >= M+2)
						continue;
					if (board[ny][nx] == 2) {
						cnt++;
					}

				}
			   //System.out.println(cnt);
				if (cnt < 2) {
					cq.add(cheese);
					
				} else {
					board[y][x]=0; // 녹이기 
				}
				
			}
			checkOuter();

		}

	}

	private static void checkOuter() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0 });
		boolean visited[][] = new boolean[N+2][M+2];
		visited[0][0] = true;
		board[0][0] = 2;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int y = now[0];
			int x = now[1];
			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if (ny < 0 || ny >= N+2 || nx < 0 || nx >= M+2 || visited[ny][nx] || board[ny][nx] == 1)
					continue;
				board[ny][nx] = 2;
				visited[ny][nx] = true;
				q.add(new int[] { ny, nx });

			}
		}
	}

}