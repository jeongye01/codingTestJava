import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 쿠키들은 신체를 측정하기 위해서 한 변의 길이가 N인 정사각형 판 위에 누워있으며, 어느 신체 부위도 판 밖으로 벗어나지 않는다. 
// ans : 쿠키의 신체가 주어졌을 때 심장의 위치와 팔, 다리, 허리의 길이
public class Main {
	static int N;
	static char[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		board = new char[N][N];
		int hy = -1, hx = -1;
		for (int i = 0; i < N; i++) {
			char chrs[] = br.readLine().trim().toCharArray();
			for (int j = 0; j < N; j++) {
				board[i][j] = chrs[j];
				if (hy == -1 && chrs[j] == '*') {
					hy = i;
					hx = j;
				}
			}
		}
		sb.append(hy + 2).append(' ').append(hx + 1).append('\n');
		int ans = 0;
		// 왼팔
		for (int j = 0; j < hx; j++) {
			if (board[hy + 1][j] == '*')
				ans++;
		}
		sb.append(ans).append(' ');
		ans = 0;
		// 오른팔
		for (int j = hx + 1; j < N; j++) {
			if (board[hy + 1][j] == '*')
				ans++;
		}
		sb.append(ans).append(' ');
		ans = 0;
		int legStart = 0;
		for (int i = hy + 2; i < N; i++) {
			if (board[i][hx] == '*')
				ans++;
			else {
				legStart = i;
				break;
			}
			;
		}
		sb.append(ans).append(' ');
		ans = 0;
		for (int i = legStart; i < N; i++) {
			if (board[i][hx - 1] == '*')
				ans++;
			else {

				break;
			}
			;
		}
		sb.append(ans).append(' ');
		ans = 0;
		for (int i = legStart; i < N; i++) {
			if (board[i][hx + 1] == '*')
				ans++;
			else {

				break;
			}
			
		}
		sb.append(ans).append(' ');
		System.out.println(sb);

	}

}