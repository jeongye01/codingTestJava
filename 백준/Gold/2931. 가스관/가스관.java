
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int[] dx = { 0, -1, 0, 1 }; // x축 방향 정의
	public static int[] dy = { -1, 0, 1, 0 }; // y축 방향 정의
	// 1~4번 보드 방향별 바뀔 방향 정의 -1인 경우 해당방향에서는 이동할 수 없음을 의미.
	public static int[][] numBlock = { { 3, 2, -1, -1 }, { -1, 0, 3, -1 }, { -1, -1, 1, 0 }, { 1, -1, -1, 2 } };
	static int[] dlblock = { 0, -1, 2, -1 };
	static int[] dmblock = { -1, 1, -1, 3 };
	// 지워진 설계도 입력
	public static char[][] board;
	// 이미 방문했는지 여부
	public static boolean[][] visited;
	// 행,열 사이즈
	public static int R, C, ex, ey;
	public static char eb;
	public static int z[], m[]; // 집과 유치원 위치 인덱스 0-> 행,1->열 의미
	static char[] shapes = { '|', '-','+',  '1', '2', '3', '4' };
	static int id;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine().trim());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		visited = new boolean[R][C];
		m = new int[2];
		ex = -1;
		ey = -1;
		eb = 'x';
		for (int i = 0; i < R; i++) {
			char[] chrs = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				board[i][j] = chrs[j]; // 보드 입력 받기
				if (chrs[j] == 'M') {// 집
					m[0] = i;
					m[1] = j;
				}
			}
		}
		id = -1;

		for (int d = 0; d < 4; d++) {
			int ny = m[0] + dy[d];
			int nx = m[1] + dx[d];
			if (nx >= 0 && nx < C && ny >= 0 && ny < R && board[ny][nx] != '.' && board[ny][nx] != 'Z') { // 시작점 기준 진입할
																											// 타일 정해짐 .
																											// 해당 방향으로
																											// 방향
				// // // 설정하기
				id = d;
				break;
			}

		}

		search(m[1], m[0], id);

		sb.append(ey).append(" ").append(ex).append(" ").append(eb);

		System.out.println(sb);
	}

	public static void search(int x, int y, int d) {
		//System.out.println(y + " " + x);
		if (x < 0 || x >= C || y < 0 || y >= R || visited[y][x]&&board[y][x]!='+') {
			return;
		}
		
		if (board[y][x] == 'Z') {
			if (ey != -1 && ex != -1) {

				eb = board[ey - 1][ex - 1];

			}
			return;
		}
		if (board[y][x] == '.') {// 중간에 길이 끊긴 지점으므로 이곳에서 지워진 영역임.
			if (ey == -1 && ex == -1) {
				ey = y + 1;
				ex = x + 1;
				// 어떤 타일이 지워진건지 계산하고 리턴
				// System.out.println("." + x + " " + y + "asdf");
				for (int i = 0; i < 7; i++) {
					visited=new boolean[R][C];
					board[y][x] = shapes[i];

					search(m[1], m[0], id);
					if (eb != 'x') {
						return;
					}
				}

			}
			return;
		}
		char tile = board[y][x];
		int nd = d;
		if (tile == '1' || tile == '2' || tile == '3' || tile == '4') {
			nd = numBlock[tile - '0' - 1][d];

		} else if (tile == '|') {
			nd = dlblock[d];
		} else if (tile == '-') {
			nd = dmblock[d];
		}
		if (nd == -1) {
			return;
		}
		int nx = x + dx[nd];
		int ny = y + dy[nd];
		search(nx, ny, nd);

	}

}
/*
 * 

3 7
.14....
.M.Z...
..23...
 * 
 * 
 */