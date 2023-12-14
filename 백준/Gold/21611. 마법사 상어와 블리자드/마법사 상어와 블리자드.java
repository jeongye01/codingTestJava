import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 가장 처음에 상어가 있는 칸을 제외한 나머지 칸에는 구슬이 하나 들어갈 수 있다. 
// 구슬은 1번 구슬, 2번 구슬, 3번 구슬이 있다.
// 같은 번호를 가진 구슬이 번호가 연속하는 칸에 있으면, 그 구슬을 연속하는 구슬이라고 한다. 
// 블리자드 마법을 시전하려면 방향 di와 거리 si를 정해야 한다. 
// ans : 1×(폭발한 1번 구슬의 개수) + 2×(폭발한 2번 구슬의 개수) + 3×(폭발한 3번 구슬의 개수)
public class Main {

	static int N, M;
	static int[][] board;
	static List<int[]> order;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int D, S;
	static int ans;
	static int[] doll = new int[4];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][N];
		order = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		writeNum();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			solve(d - 1, s);
		}
		ans = doll[1] + doll[2] * 2 + doll[3] * 3;
		System.out.println(ans);

	}

	private static void writeNum() {
		int[] ddx = { -1, 0, 1, 0 };
		int[] ddy = { 0, 1, 0, -1 };
		int M = 1;
		int y = N / 2, x = N / 2;
		int d = 0;
		while (true) {
			for (int m = 0; m < M; m++) {

				x += ddx[d];
				y += ddy[d];

				if (y < 0 || x < 0)
					return;
				order.add(new int[] { y, x });
			}
			d = (d + 1) % 4;
			if (d == 2 || d == 0)
				M++;
		}

	}

	private static void solve(int d, int s) {

		// TODO: 파괴
		destroy(d, s);
		// TODO: 구슬 이동 시키기
		move();
		// TODO: 폭발 , 구슬 이동 반복 (더 이상 폭발할 구슬이 없을 때 까지 )

		while (explosion()) {
			move();

		}
		// TODO: 구슬 변화 (하나의 그룹 -> 연속하는 구슬 )
		change();
	//	for (int i = 0; i < N; i++) {
		//	System.out.println(Arrays.toString(board[i]));
		//}

	};

	private static void destroy(int d, int s) {
		int ny = N / 2;
		int nx = N / 2;
		for (int _s = 0; _s < s; _s++) {
			ny += dy[d];
			nx += dx[d];
			if (ny < 0 || ny >= N || nx < 0 || nx >= N)
				break;
			board[ny][nx] = 0;
		}

	}

	private static void move() {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < order.size(); i++) {
			int pos[] = order.get(i);

			if (board[pos[0]][pos[1]] != 0) {
				q.offer(board[pos[0]][pos[1]]);
			}
		}
		for (int i = 0; i < order.size(); i++) {
			int pos[] = order.get(i);
			if (q.isEmpty()) {
				board[pos[0]][pos[1]] = 0;
			} else {
				board[pos[0]][pos[1]] = q.poll();
			}

		}

	}

	private static boolean explosion() {
		Queue<int[]> q = new LinkedList<>();
		int cnt = 1;
		int pos[] = order.get(0);
		int prev = board[pos[0]][pos[1]];
		q.offer(new int[] { pos[0], pos[1] });
		boolean check = false;
		for (int i = 1; i < order.size(); i++) {
			pos = order.get(i);
            if(board[pos[0]][pos[1]]==0)break;
			if (board[pos[0]][pos[1]] == prev) {
				cnt++;
				
			} else {
				if (cnt >= 4) {
					doll[prev]+=cnt;
					while (!q.isEmpty()) { // 폭발
						int now[] = q.poll();
						
						

						// System.out.println(prev+" "+board[now[0]][now[1]]);
						board[now[0]][now[1]] = 0;

					}
					check = true;
				} else {
					q.clear();
				}
				cnt = 1;
			}
			q.offer(new int[] { pos[0], pos[1] });
			prev = board[pos[0]][pos[1]];
		}
		if (cnt >= 4 ) {
			//System.out.println("???"+" "+cnt);
			doll[prev]+=cnt;
			while (!q.isEmpty()) { // 폭발
				int now[] = q.poll();
				
				

				// System.out.println(prev+" "+board[now[0]][now[1]]);
				board[now[0]][now[1]] = 0;

			}
			check = true;
		}

		return check;
	}

	private static void change() {
		Queue<int[]> q = new LinkedList<>();
		int cnt = 1;
		int pos[] = order.get(0);
		int prev = board[pos[0]][pos[1]];

		for (int i = 1; i < order.size(); i++) {
			pos = order.get(i);
			if (board[pos[0]][pos[1]] == 0) {
				break;
			} else if (board[pos[0]][pos[1]] == prev) {
				cnt++;
			} else {
				q.offer(new int[] { cnt, prev });
				cnt = 1;
			}
			prev = board[pos[0]][pos[1]];
		}
	    if(prev>0) {
	    	q.offer(new int[] { cnt, prev });
	    }
		
	   // System.out.println(cnt+" "+prev);
		for (int i = 0; i < order.size(); i++) {
			pos = order.get(i);
			if (!q.isEmpty()) {
				int now[] = q.poll();
				cnt = now[0];
				prev = now[1];
				// System.out.println(cnt + " " + prev);
				board[pos[0]][pos[1]] = cnt;
				i += 1;
				pos = order.get(i);
				board[pos[0]][pos[1]] = prev;

			} else {
				board[pos[0]][pos[1]] = 0;

			}
		}

	}

}
