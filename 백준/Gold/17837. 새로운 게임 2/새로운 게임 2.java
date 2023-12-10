import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 하나의 말 위에 다른 말을 올릴 수 있다. 
// 턴이 진행되던 중에 말이 4개 이상 쌓이는 순간 게임이 종료
// 체스판을 벗어나는 경우에는 파란색과 같은 경우이다.
// ans : 게임이 종료되는 턴의 번호를 출력한다. 그 값이 1,000보다 크거나 절대로 게임이 종료되지 않는 경우에는 -1을 출력
public class Main {
	static int N, K;
	static int[][] board; // 0: 흰색 1:빨간색 2:파란색
	static List<Integer> horse[][];
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int ans = 0;
	static HashMap<Integer, Horse> map;

	static class Horse {
		public int r, c, n, d;

		public Horse(int r, int c, int n, int d) {
			this.r = r;
			this.c = c;
			this.n = n;
			this.d = d;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		board = new int[N][N];
		horse = new ArrayList[N][N];
		map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				horse[i][j] = new ArrayList<>();
			}
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken()) - 1;
			map.put(i, new Horse(r, c, i, d));
			horse[r][c].add(i);

		}
		solve();
		System.out.println(ans > 1000 ? -1 : ans);

	}

	public static void solve() {
		while (true) {
			ans++;
			if (ans > 1000)
				return;
			for (int i = 1; i <= K; i++) {
				
				Horse mh = map.get(i);
				//System.out.println(mh);
				int nr = mh.r + dy[mh.d];
				int nc = mh.c + dx[mh.d];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || board[nr][nc] == 2) { // 파란색, 혹은 바깥
					if (mh.d == 0 || mh.d == 2) {
						mh.d += 1;
					} else {
						mh.d -= 1;
					}
					nr = mh.r + dy[mh.d];
					nc = mh.c + dx[mh.d];
					if (nr < 0 || nr >= N || nc < 0 || nc >= N || board[nr][nc] == 2)
						continue;
				}
				int st = 0;

				for (Integer hn : horse[mh.r][mh.c]) {
					
					if (hn == mh.n) {
						
						break;
					}
					
					st++;

				}
				
				int size = horse[mh.r][mh.c].size();
				//System.out.println(mh.r + " " + mh.c + " <"+mh.n+"> "+nr+" "+nc+" "+st);
				int r=mh.r,c=mh.c;
				if (board[nr][nc] == 0) { // 흰색
                   
					for (int idx = st; idx < size; idx++) {
						Horse h = map.get(horse[r][c].get(idx));
						h.r = nr;
						h.c = nc;
						horse[nr][nc].add(h.n);
						
						
					}
					for (int idx = st; idx < size; idx++) {
						horse[r][c].remove(st);
					}

				} else { // 빨간색
					for (int idx = size - 1; idx >= st; idx--) {
						Horse h = map.get(horse[r][c].get(idx));
						h.r = nr;
						h.c = nc;
						horse[nr][nc].add(h.n);
					
					}
					for (int idx = st; idx < size; idx++) {
						horse[r][c].remove(st);
					}

				}
				//System.out.println(" aslkgnkals"+" "+horse[nr][nc].size());
				if (horse[nr][nc].size() >= 4) { // 종료 조건
					return;
				}
				

			}

		}

	}

}
