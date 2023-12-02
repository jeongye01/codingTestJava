import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//파이어볼 : r,c, 질량 m, 방향 d (8방향 0~7), 속력 s 속성 가짐 
// 주의 : 같은 칸에 여러 파이어볼이 있을 수 있다. 
// ans : 마법사 상어가 이동을 k 번 명령한 후, 남아있는 파이어볼 질량의 합 

public class Main {
	static int N, M, K;
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };

	static List<Fireball> board[][];
	static int ans;

	public static class Fireball {
		int m, s, d;

		public Fireball(int m, int s, int d) {
			this.m = m;
			this.d = d;
			this.s = s;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		board = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = new ArrayList<>();
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			board[r - 1][c - 1].add(new Fireball(m, s, d));
		}
		ans = 0;
		move();
		calm();

		System.out.println(ans);
	}

	public static void calm() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (Fireball f : board[i][j]) {

					ans += f.m;
				}
			}
		}
	}

	public static void move() {
		List<Fireball> newBoard[][] = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				newBoard[i][j] = new ArrayList<>();
			}
		}
		for (int k = 0; k < K; k++) {

			// 1. 이동
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {

					for (Fireball f : board[r][c]) {

						int nr = (r + dy[f.d] * f.s) % N;
						int nc = (c + dx[f.d] * f.s) % N;
						if (nr < 0) {
							nr += N;
						}
						if (nc < 0) {
							nc += N;
						}

						newBoard[nr][nc].add(new Fireball(f.m, f.s, f.d));

					}

				}
			}
			// 2. 2개 이상 있는 칸 처리
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {

					int cnt = newBoard[r][c].size(); // 합쳐진 파이어볼 개수

					if (cnt >= 2) { // 2. 2개 이상 있는 칸 처리

						int summ = 0; // 질량 합치기

						int sums = 0; // 속력 합치기
						int oddCnt = 0;
						for (Fireball f : newBoard[r][c]) {
							summ += f.m;
							sums += f.s;
							if (f.d % 2 != 0) {
								oddCnt++;
							}
						}

						if (summ / 5 == 0) { // 소멸
							newBoard[r][c].clear();

						} else {
							newBoard[r][c].clear();

							for (int i = 0; i < 8; i += 2) {
								newBoard[r][c].add(
										new Fireball(summ / 5, sums / cnt, (oddCnt ==cnt || oddCnt == 0) ? i : (i + 1)));

							}

						}
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					board[i][j].clear();
					for (Fireball f : newBoard[i][j]) {
						board[i][j].add(new Fireball(f.m, f.s, f.d));
					}

					newBoard[i][j].clear();
				}
			}

		}

	}

}