import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//  ans : 크기가 1×1인 정사각형의 네 꼭짓점이 모두 드래곤 커브의 일부인 것의 개수

public class Main {
	static int N; // 드래곤 커브의 개수
	static boolean[][] board = new boolean[101][101];
	static int ans;
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken()); // 시작 점
			int d = Integer.parseInt(st.nextToken()); // 시작방향
			int g = Integer.parseInt(st.nextToken()); // 세대
			draw(x, y, d, g);
		}
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(board[i][j] &&board[i][j+1] && board[i+1][j] && board[i+1][j+1]) {
					ans++;
				}
			}
		}
		System.out.println(ans);

	}

	public static void draw(int x, int y, int d, int g) {
		List<Integer> history = new ArrayList<>();
		history.add(d);
		board[y][x] = true;
		for (int i = 1; i <= g; i++) {
			for (int j = history.size() - 1; j >= 0; j--) {
				history.add((history.get(j) + 1) % 4);
			}
		}
		for (Integer nd : history) {
			x += dx[nd];
			y += dy[nd];
			board[y][x] = true;
		}

	}

}