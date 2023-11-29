import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// 테트로미노 : 정사각형 4개를 이어 붙인 폴리오미노.
// ans : 테트로미노 하나를 놓아서 테트로미노가 놓인 칸에 쓰여있는 수들의 합 최대

public class Main {
	static int N, M;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

	static int board[][];
	static boolean visited[][];
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = 0;
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				makeTetro(i, j, 1, board[i][j]);
				visited[i][j] = false;
			}
		}

		System.out.println(ans);
	}

	public static void makeTetro(int sy, int sx, int cnt, int sum) {
		

		if (cnt == 4) {

			if (sum > ans) {
				ans = sum;
			}
			return;
		}
		for (int d = 0; d < 4; d++) {

			int ny = sy + dy[d];
			int nx = sx + dx[d];

			if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[ny][nx]) {
				if (cnt == 2) {
					visited[ny][nx] = true;
					makeTetro(sy, sx, cnt + 1, sum + board[ny][nx]);
					visited[ny][nx] = true;
				}
				visited[ny][nx] = true;
				makeTetro(ny, nx, cnt + 1, sum + board[ny][nx]);
				visited[ny][nx] = false;
				

			}

		}
		

	}

}