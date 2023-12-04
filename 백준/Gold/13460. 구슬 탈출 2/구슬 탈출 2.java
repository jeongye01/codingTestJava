import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 구슬 탈출은 직사각형 보드에 빨간 구슬과 파란 구슬을 하나씩 넣은 다음, 빨간 구슬을 구멍을 통해 빼내는 게임
// 가장 바깥 행과 열은 모두 막혀져 있고, 보드에는 구멍이 하나 있다.
// 빨간 구슬과 파란 구슬의 크기는 보드에서 1×1크기의 칸을 가득 채우는 사이즈 
// 구슬을 손으로 건드릴 수는 없고, 중력을 이용해서 이리 저리 굴려야 한다. 왼쪽으로 기울이기, 오른쪽으로 기울이기, 위쪽으로 기울이기, 아래쪽으로 기울이기와 같은 네 가지 동작
//  빨간 구슬이 구멍에 빠지면 성공이지만, 파란 구슬이 구멍에 빠지면 실패이다.(0) 
// 기울이는 동작을 그만하는 것은 더 이상 구슬이 움직이지 않을 때 까지이다.(0)
// ans : 최소 몇 번 만에 빨간 구슬을 구멍을 통해 빼낼 수 있는지
// 0 : 구멍 # : 벽 . : 빈칸 
public class Main {
	static int N, M;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static boolean visited[][][][];
	static char[][] board;

	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int redx = 0, redy = 0, bluex = 0, bluey = 0;

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N][M][N][M];
		board = new char[N][M];
		ans = 11;
		for (int i = 0; i < N; i++) {
			char[] chrs = br.readLine().trim().toCharArray();

			for (int j = 0; j < M; j++) {
				board[i][j] = chrs[j];
				if (chrs[j] == 'R') {
					redy = i;
					redx = j;
				} else if (chrs[j] == 'B') {
					bluey = i;
					bluex = j;
				}
			}
		}

		
		for (int d = 0; d < 4; d++) {

			bt(d, 1, redy, redx, bluey, bluex);
		}

		System.out.println(ans == 11 ? -1 : ans);
	}

	public static void bt(int d, int time, int redy, int redx, int bluey, int bluex) {
		if (time >= 11) {
			return;
		}

		// 기울이는 동작을 그만하는 것은 더 이상 구슬이 움직이지 않을 때 까지이다.
		while (true) {
			int rny = redy + dy[d];
			int rnx = redx + dx[d];
			int bny = bluey + dy[d];
			int bnx = bluex + dx[d];
			if (board[bny][bnx] == 'O') {
				// System.out.println("파랑이 골 ");
				return;
			}
			// 움직일 수 없는 경우
			// System.out.println(redy+" "+rny + " " + rnx + " " + time+" "+d);
			if (board[rny][rnx] == '#' && board[bny][bnx] == '#') {
				break;
			}
			if (board[rny][rnx] == '#' && bny == redy && bnx == redx) {
				break;
			}
			if (board[bny][bnx] == '#' && rny == bluey && rnx == bluex) {
				break;
			}

			if (board[redy][redx] == 'O' && board[bny][bnx] == '#') {
				break;
			}

			if (board[rny][rnx] != '#' && board[redy][redx]!='O') {
				redy = rny;
				redx = rnx;

			}
			if (board[bny][bnx] != '#') {
				bluey = bny;
				bluex = bnx;

			}
			

		}
//		if(redy==3 && redx==5 ) {
//			System.out.println(redy + " " + redx+" "+bluey + " " + bluex + " " + time+" "+moved+" "+visited[redy][redx][bluey][bluex]);
//
//		}
		if (board[redy][redx] == 'O' && board[bluey][bluex] != 'O') {
			// System.out.println("빨강 골 " + " " + time);
			ans = Math.min(ans, time);
			return;

		}

		if (visited[redy][redx][bluey][bluex]) {
			return;
		}
		visited[redy][redx][bluey][bluex] = true;

		// 기울이기
		for (int nd = 0; nd < 4; nd++) {
			if (nd != d) {

				bt(nd, time + 1, redy, redx, bluey, bluex);
			}

		}
		visited[redy][redx][bluey][bluex] = false;

	}

}