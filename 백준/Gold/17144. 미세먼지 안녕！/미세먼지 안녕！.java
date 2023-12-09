

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 공기청정기는 항상 1번 열에 설치되어 있고, 크기는 두 행을 차지한다. 
// 공기청정기가 설치되어 있지 않은 칸에는 미세먼지가 있고, (r, c)에 있는 미세먼지의 양은 Ar,c이다.
//ans : T초가 지난 후 구사과의 방에 남아있는 미세먼지의 양
public class Main {

	static int R, C, T;
	static int[][] board, boardCopy;
	static int cleanerUp = -1, cleanerDown = -1;

	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		board = new int[R][C];
		boardCopy = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < C; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				boardCopy[i][j] = board[i][j];
				if (board[i][j] == -1) {
					if (cleanerUp == -1) {
						cleanerUp = i;
					} else {
						cleanerDown = i;
					}

				}
			}
		}
         //System.out.println(cleanerUp+" "+cleanerDown);
		spread();
		for (int i = 0; i < R; i++) {

			for (int j = 0; j < C; j++) {
				if (board[i][j] > 0) {
					ans += board[i][j];
				}
			}
		}
		System.out.println(ans);

	}

	public static void spread() {
		int dx[] = { 0, -1, 0, 1 };
		int dy[] = { -1, 0, 1, 0 };
		for (int t = 0; t < T; t++) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					int cnt = 0;
					if (board[i][j] > 0) {
						for (int d = 0; d < 4; d++) {
							int ny = i + dy[d];
							int nx = j + dx[d];
							if (ny < 0 || ny >= R || nx < 0 || nx >= C || board[ny][nx] == -1)
								continue;
							cnt++;
							boardCopy[ny][nx] += (board[i][j] / 5);
						}
						boardCopy[i][j] -= cnt * (board[i][j] / 5);
					}
				}
			}

			// TODO: 순환 시키기
			// 위쪽
			int tmp = 0;
			for (int j = 1; j < C; j++) {
				int tmp2 = boardCopy[cleanerUp][j];
				boardCopy[cleanerUp][j] = tmp;
				tmp = tmp2;
			}

			for (int i = cleanerUp - 1; i >= 0; i--) {
				int tmp2 = boardCopy[i][C - 1];
				boardCopy[i][C - 1] = tmp;
				tmp = tmp2;
			}

			for (int j = C - 2; j >= 0; j--) {
				int tmp2 = boardCopy[0][j];
				boardCopy[0][j] = tmp;
				tmp = tmp2;
			}

			for (int i = 1; i < cleanerUp; i++) {
				int tmp2 = boardCopy[i][0];
				boardCopy[i][0] = tmp;
				tmp = tmp2;

			}

			// 아래 쪽
			tmp = 0;
			for (int j = 1; j < C; j++) {
				int tmp2 = boardCopy[cleanerDown][j];
				boardCopy[cleanerDown][j] = tmp;
				tmp = tmp2;
			}

			for (int i = cleanerDown + 1; i < R; i++) {
				int tmp2 = boardCopy[i][C - 1];
				boardCopy[i][C - 1] = tmp;
				tmp = tmp2;
			}

			for (int j = C - 2; j >= 0; j--) {
				int tmp2 = boardCopy[R - 1][j];
				boardCopy[R - 1][j] = tmp;
				tmp = tmp2;
			}

			for (int i = R - 2; i > cleanerDown; i--) {
				int tmp2 = boardCopy[i][0];
				boardCopy[i][0] = tmp;
				tmp = tmp2;

			}
			for (int i = 0; i < R; i++) {

				for (int j = 0; j < C; j++) {
					board[i][j] = boardCopy[i][j];
				}
			}

//			for (int i = 0; i < R; i++) {
//				System.out.println(Arrays.toString(boardCopy[i]));
//			}

		}

	}

}

