import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// 둘 이상의 물고기가 같은 칸에 있을 수도 있으며, 마법사 상어와 물고기가 같은 칸에 있을 수도 있다.

//  ans :  연습을 마친 후 격자에 있는 물고기 의 수 
public class Main {
	static int ans;
	static int N, S;
	static Queue<Fish>[][] board = new LinkedList[4][4];
	static int[][] smell = new int[4][4];
	static int dx[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int dy[] = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int sy, sx;
	static int fq;
	static int sroot[] = new int[3];
	static int sdx[] = { 0, -1, 0, 1 };
	static int sdy[] = { -1, 0, 1, 0 };

	static class Fish {
		int y, x, d;
		int ny = -1, nx = -1, nd = -1;
		boolean moved;

		public Fish(int y, int x, int d, boolean active) {
			this.y = y;
			this.x = x;
			this.d = d;
			this.moved = active;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				board[i][j] = new LinkedList<>();
			}

		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken()) - 1;
			board[y][x].add(new Fish(y, x, d, true));
		}
		st = new StringTokenizer(br.readLine().trim());
		sy = Integer.parseInt(st.nextToken()) - 1;
		sx = Integer.parseInt(st.nextToken()) - 1;

		solve();

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				ans += board[i][j].size();
			}

		}
		System.out.println(ans);
	}

	private static void solve() {
		Queue<Fish>[][] board2 = new LinkedList[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				board2[i][j] = new LinkedList<>();
			}

		}
		int[] moves = new int[3];
		for (int s = 0; s < S; s++) {
			//System.out.println(sy + " " + sx + " " + s + " 번째 판 ");
			// 1. 복제 마법 시전
			// 2. 이동
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					
					for (Fish f : board[i][j]) {
						int nd = f.d;
						int ny = f.y;
						int nx = f.x;
						boolean moved = false;
						for (int k = 0; k < 8; k++) {

							ny = f.y + dy[nd];
							nx = f.x + dx[nd];

							if (ny < 0 || ny >= 4 || nx < 0 || nx >= 4 || (sy == ny && sx == nx) || smell[ny][nx] > 0) {

								nd = nd - 1;
								if (nd < 0)
									nd += 8;
								continue;
							}

							moved = true;
							break;

						}
						if (moved) {
							board2[ny][nx].add(new Fish(ny, nx, nd, true));
						} else {
							board2[f.y][f.x].add(new Fish(f.y, f.x, f.d, false));
						}

						// System.out.println(f.ny + " " +f.nx + " 에서 " + board2[f.ny][f.nx].size());

					}
				}

			}
			fq = -1;
			sroot[0] = 4;
			sroot[1] = 4;
			sroot[2] = 4;

			// 3. 상어이동
			dfs(moves, 0, 0, sy, sx, board2, -1);
			// 4. 제외 시키기

			for (int d = 0; d < 3; d++) {

				sy = sy + sdy[sroot[d]];
				sx = sx + sdx[sroot[d]];
				if (board2[sy][sx].size() == 0)
					continue;
				
				// System.out.println(sx + " " + sy + " " + sroot[d] + " " + d);
				smell[sy][sx] = 3;
				while (!board2[sy][sx].isEmpty()) {
					board2[sy][sx].poll();

				}

			}

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					// System.out.println(i+" "+j+" 에서 "+board2[i][j].size());
					for (Fish f : board2[i][j]) {

						board[i][j].add(new Fish(f.y, f.x, f.d, true));

					}

					board2[i][j].clear();
					if (smell[i][j] > 0) {
						smell[i][j]--;
					}

				}

			}

			
		}

	}

	private static void dfs(int[] direcs, int sum, int depth, int y, int x, Queue<Fish>[][] board2, int prevd) {

		if (depth == 3) {

			if (fq < sum ) {

				//System.out.println(Arrays.toString(direcs) + " " + y + " " + x + " " + sum + " ?");
				fq = sum;
//				boolean check = false;
//				if (direcs[0] < sroot[0]) {
//					check = true;
//				} else if ((direcs[0] == direcs[0]) && direcs[1] < sroot[1]) {
//					check = true;
//				} else if ((direcs[1] == direcs[1]) && direcs[2] < sroot[2]) {
//					check = true;
//				}
//				if (check) {
//					
//				}
				sroot[0] = direcs[0];
				sroot[1] = direcs[1];
				sroot[2] = direcs[2];
			}
			return;
		}
		for (int d = 0; d < 4; d++) {
			

			direcs[depth] = d;
			int sny = y + sdy[d];
			int snx = x + sdx[d];
		

			if (sny < 0 || sny >= 4 || snx < 0 || snx >= 4)
				continue;
			if (depth>1 && (d == prevd + 2 || d == prevd - 2)) { // 뒤로 back 하는 경우 
				dfs(direcs, sum , depth + 1, sny, snx, board2, d);
			}else {
				dfs(direcs, sum + board2[sny][snx].size(), depth + 1, sny, snx, board2, d);
			}
				
		
		}
	}

}
