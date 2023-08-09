import java.io.*;
import java.util.*;

public class Solution {
	static int N, roomNo, ans;
	static int room[][], visited[][];
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	private static void bfs(int i, int j) {
		Deque<int[]> deque = new ArrayDeque<>();
		deque.add(new int[] { i, j });
		int cnt = 0;
		while (deque.size() > 0) {
			int[] now = deque.poll();
			for (int d = 0; d < 4; d++) {
				int ni = now[0] + dy[d], nj = now[1] + dx[d];
				if (ni >= 0 && ni < N && nj >= 0 && nj < N && visited[ni][nj] == 0
						&& room[ni][nj] - room[now[0]][now[1]] == 1) {
					visited[ni][nj] = 1;
					deque.add(new int[] { ni, nj });
					cnt += 1;
				}
			}
		}
		if(cnt==ans) {
			if(roomNo>room[i][j]) {
				roomNo=room[i][j];
			}
		}
		else if (cnt > ans) {
			ans = cnt;
			roomNo = room[i][j];
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			room = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			ans = -1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					visited = new int[N][N];
					bfs(i, j);

				}
			}
			System.out.println("#" + tc + " " + roomNo + " " + (ans + 1));

		}
	}

}