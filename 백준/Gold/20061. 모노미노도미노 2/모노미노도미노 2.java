
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 블록을 놓을 위치를 빨간색 보드에서 선택하면, 그 위치부터 초록색 보드로 블록이 이동하고, 파란색 보드로 블록이 이동한다.
// 블록의 이동은 다른 블록을 만나거나 보드의 경계를 만나기 전까지 계속해서 이동한다. 
// ans : 입력받은 국가 K의 등수를 하나의 정수로 출력
public class Main {

	static int N;
	static int p, cnt;
	static boolean[][] blue = new boolean[4][6];
	static boolean[][] green = new boolean[6][4];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int t = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken()); // 행
			int y = Integer.parseInt(st.nextToken()); // 열
			solve(t, x, y);

		}
		sb.append(p).append('\n');
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 6; j++) {
				if (blue[i][j])
					cnt++;
				if (green[j][i])
					cnt++;
			}
		}
		sb.append(cnt);
		System.out.println(sb);

	}

	public static void solve(int t, int x, int y) {
		// 이동 시키기
		if (t == 1) { // 크기가 1×1인 블록을 (x, y)에 놓은 경우
			int bx = x, by = -1, gx = -1, gy = y;
			while (by <= 4 && !blue[bx][by + 1]) { // blue
				by += 1;
			}
			while (gx <= 4 && !green[gx + 1][gy]) { // green
				gx += 1;
			}
			blue[bx][by] = true;
			green[gx][gy] = true;

		} else if (t == 2) { // 크기가 1×2인 블록을 (x, y), (x, y+1)에 놓은 경우
			int bx = x, by = -1, gx = -1, gy = y;
			while (by <= 3 && !blue[bx][by + 2]) { // blue
				by += 1;
			}
			while (gx <= 4 && !green[gx + 1][gy] && !green[gx + 1][gy + 1]) { // green
				gx += 1;
			}
			blue[bx][by] = true;
			blue[bx][by + 1] = true;
			green[gx][gy] = true;
			green[gx][gy + 1] = true;

		} else { // 크기가 2×1인 블록을 (x, y), (x+1, y)에 놓은 경우
			int bx = x, by = -1, gx = -1, gy = y;
			while (by <= 4 && !blue[bx][by + 1] && !blue[bx + 1][by + 1]) { // blue
				by += 1;
			}
			while (gx <= 3 && !green[gx + 2][gy]) { // green
				gx += 1;
			}
			blue[bx][by] = true;
			blue[bx + 1][by] = true;
			green[gx][gy] = true;
			green[gx + 1][gy] = true;

		}
	

		// 한 행이나 열이 타일로 가득 차서 사라지면 1점을 획득한다.

		for (int j = 0; j < 6; j++) {// blue
			boolean check = true;
			for (int i = 0; i < 4; i++) {
				if (!blue[i][j]) {
					check = false;
					break;
				}
			}
			if (check) { // 점수 획득
				p++;
				for (int i = 0; i < 4; i++) {
					blue[i][j] = false;
				}
				for (int c = j; c >= 1; c--) {
					for (int r = 0; r < 4; r++) {
						blue[r][c] = blue[r][c - 1];
					}
				}
			

			}
		}
		for (int i = 0; i < 6; i++) { // green
			boolean check = true;
			for (int j = 0; j < 4; j++) {
				if (!green[i][j]) {
					check = false;
					break;
				}
			}
			if (check) { // 점수 획득
				p++;
				for (int j = 0; j < 4; j++) {
					green[i][j] = false;
				}
				for (int r = i; r >= 1; r--) {
					for (int c = 0; c < 4; c++) {
						green[r][c] = green[r - 1][c];
					}
				}
			

			}
		}
		// 0, 1번 행,열 에 블록이 있으면, 블록이 있는 행의 수만큼 아래 행에 있는 타일이 사라짐
		for (int j = 0; j < 2; j++) {// blue
			boolean check = false;
			for (int i = 0; i < 4; i++) {
				if (blue[i][j]) {
					check = true;
					break;
				}
			}
			if (check) {

				for (int c = 5; c > j; c--) {
					for (int r = 0; r < 4; r++) {
						blue[r][c] = blue[r][c - 1];
					}
				}
				for (int i = 0; i < 4; i++) {
					blue[i][j] = false;
				}
			}
		}
		for (int i = 0; i < 2; i++) { // green
			boolean check = false;
			for (int j = 0; j < 4; j++) {
				if (green[i][j]) {
					check = true;
					break;
				}
			}
			if (check) {

				for (int r = 5; r > i; r--) {
					for (int c = 0; c < 4; c++) {
						green[r][c] = green[r - 1][c];
					}
				}
				for (int j = 0; j < 4; j++) {
					green[i][j] = false;
				}
			}
		}

//		for (int i = 0; i < 6; i++) {
//			System.out.println(Arrays.toString(green[i]));
//		}

	}
}