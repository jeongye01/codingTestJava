import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// 테트로미노 : 정사각형 4개를 이어 붙인 폴리오미노.
// ans : 테트로미노 하나를 놓아서 테트로미노가 놓인 칸에 쓰여있는 수들의 합 최대

public class Main {
	static int N;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

	static int board[][];
	static int data[][];
	static int ans;

	static class Seat implements Comparable<Seat> {
		int like, empty;

		public Seat(int like, int empty) {
			this.like = like;
			this.empty = empty;
		}

		@Override
		public int compareTo(Seat o) {
			if (this.like == o.like) {
				return this.empty - o.empty;

			}
			return this.like - o.like;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		board = new int[N][N];
		data = new int[N * N][7];

		for (int i = 0; i < N * N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < 5; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = 0;
		for (int i = 0; i < N * N; i++) {
			sit(i);
		}
		for (int i = 0; i < N * N; i++) {
			point(i);
		}
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(board[i]));
//		}
		System.out.println(ans);
	}

	public static void sit(int s) {
		int pi = 0, pj = 0;
		Seat maxp = new Seat(-1,-1);
	
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] > 0) {
					continue;
				}
				int empty = 0;
				int like = 0;
				for (int d = 0; d < 4; d++) {
					int ni = i + dy[d];
					int nj = j + dx[d];
					if (ni < 0 || ni >= N || nj < 0 || nj >= N) {
						continue;
					}
					if (board[ni][nj] > 0) {

						for (int k = 1; k <= 4; k++) {
							if (data[s][k] == board[ni][nj]) { // 좋아하는 친구일 경우

								like++;
								break;
							}
						}

					} else {
						empty++;
					}

				}
				Seat p = new Seat(like,empty);
				if (p.compareTo(maxp)>0) {
					pi = i;
					pj = j;
					maxp=p;
				} 
			}
		}

		board[pi][pj] = data[s][0];
		data[s][5] = pi;
		data[s][6] = pj;

	}

	public static void point(int s) {
		// 점수 계산
		int likeCnt = 0;
		for (int d = 0; d < 4; d++) {
			int ni = data[s][5] + dy[d];
			int nj = data[s][6] + dx[d];
			if (ni < 0 || ni >= N || nj < 0 || nj >= N) {
				continue;
			}
			if (board[ni][nj] > 0) {
				for (int k = 1; k <= 4; k++) {
					if (data[s][k] == board[ni][nj]) { // 좋아하는 친구일 경우
						likeCnt++;
						break;
					}
				}

			}

		}
		if (likeCnt == 1) {
			ans += 1;
		} else if (likeCnt == 2) {
			ans += 10;
		} else if (likeCnt == 3) {
			ans += 100;
		} else if (likeCnt == 4) {
			ans += 1000;
		}

	}

}