import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//  1의 번호를 가진 어른 상어는 가장 강력해서 나머지 모두를 쫓아낼 수 있다.
// 냄새는 상어가 k번 이동하고 나면 사라진다.
// 모든 상어가 이동한 후 한 칸에 여러 마리의 상어가 남아 있으면, 가장 작은 번호를 가진 상어를 제외하고 모두 격자 밖으로 쫓겨난다.
// ans : 1번 상어만 격자에 남게 되기까지 걸리는 시간을 출력한다. 단, 1,000초가 넘어도 다른 상어가 격자에 남아 있으면 -1을 출력
public class Main {

	static int N, M, K;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int ans;

	static Smell smell[][];
	static TreeMap<Integer, Shark> sharks;

	static class Shark {
		int x, y, d;
		int order[][] = new int[4][4];

		public Shark(int y, int x) {
			this.x = x;
			this.y = y;

		}

	}

	static class Smell {
		int k, n;

		public Smell(int n, int k) {
			this.n = n;
			this.k = k;

		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		sharks = new TreeMap<>();
		smell = new Smell[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {

				int n = Integer.parseInt(st.nextToken());
				if (n > 0) {
					sharks.put(n, new Shark(i, j));
					smell[i][j] = new Smell(n, K);

				}

			}
		}
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < M; i++) {

			Shark s = sharks.get(i + 1);
			s.d = Integer.parseInt(st.nextToken()) - 1;

		}
		for (int i = 0; i < M; i++) {
			Shark s = sharks.get(i + 1);
			for (int j = 0; j < 4; j++) {
				st = new StringTokenizer(br.readLine().trim());
				s.order[j][0] = Integer.parseInt(st.nextToken()) - 1;
				s.order[j][1] = Integer.parseInt(st.nextToken()) - 1;
				s.order[j][2] = Integer.parseInt(st.nextToken()) - 1;
				s.order[j][3] = Integer.parseInt(st.nextToken()) - 1;

			}
		}

		solve();

		System.out.println(ans > 1000 ? -1 : ans);

	}

	public static void solve() {
		List<Integer> board[][] = new ArrayList[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = new ArrayList<>();
			}
		}
		while (sharks.size() > 1 && ans <= 1000) {
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print((smell[i][j] == null ? 0 : smell[i][j].k) + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();

			Iterator<Integer> keys = sharks.keySet().iterator();
			while (keys.hasNext()) {
				Integer key = keys.next();
				Shark shark = sharks.get(key);
				//System.out.println(shark.y + " " + shark.x);

				int nd = -1;
				boolean canMove = false;
				for (int d = 0; d < 4; d++) {
					int ny = shark.y + dy[shark.order[shark.d][d]];
					int nx = shark.x + dx[shark.order[shark.d][d]];
					if (ny >= 0 && ny < N && nx >= 0 && nx < N && smell[ny][nx] == null) {
						nd = shark.order[shark.d][d];
						canMove = true;
						break;
					}
				}
				if (!canMove) {
					for (int d = 0; d < 4; d++) {
						int ny = shark.y + dy[shark.order[shark.d][d]];
						int nx = shark.x + dx[shark.order[shark.d][d]];
						if (ny >= 0 && ny < N && nx >= 0 && nx < N && smell[ny][nx] != null && smell[ny][nx].n == key) {
							nd = shark.order[shark.d][d];
							canMove = true;
							break;
						}
					}

				}
				if (!canMove) {
					smell[shark.y][shark.x].k = K + 1;
					continue;
				}
				shark.y = shark.y + dy[nd];
				shark.x = shark.x + dx[nd];
				shark.d = nd;
				// System.out.println(shark.y+" "+ shark.x);

				// System.out.println(shark.y + " " + shark.x + " " + key +"
				// "+smell[shark.y][shark.x].n);
				board[shark.y][shark.x].add(key);

			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int s = 1; s < board[i][j].size(); s++) {

						sharks.remove(board[i][j].get(s));
					}
					if (board[i][j].size() > 0) {
						smell[i][j]= new Smell(board[i][j].get(0), K + 1);
						board[i][j].clear();
					}
				}
			}

			for (int i = 0; i < N; i++) {// 냄새 감소
				for (int j = 0; j < N; j++) {
					if (smell[i][j] != null) {

						if (smell[i][j].k > 1) {

							smell[i][j].k--;

						} else if (smell[i][j].k == 1) {
							smell[i][j] = null;
						}

					}

				}
			}

			ans++;
		}
	}

}