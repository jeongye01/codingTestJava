import java.io.*;
import java.util.*;

public class Solution {
	static int N, roomNo, ans;
	static int room[][], dp[][];
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	private static void bfs(int i, int j) {
		Deque<int[]> deque = new ArrayDeque<>();
		deque.add(new int[] { i, j });
		while (deque.size() > 0) {
			int[] now = deque.poll();
			for (int d = 0; d < 4; d++) {
				int ni = now[0] + dy[d], nj = now[1] + dx[d];
				if (ni >= 0 && ni < N && nj >= 0 && nj < N && room[ni][nj] - room[now[0]][now[1]] == 1) {
					if (dp[ni][nj] != 0) {
						dp[i][j] += dp[ni][nj];
					} else {
						dp[i][j] += 1;
						deque.add(new int[] { ni, nj });
					}
				}
			}
		}
		dp[i][j] += 1;
		if (dp[i][j] == ans) {
			if (roomNo > room[i][j]) {
				roomNo = room[i][j];
			}
		} else if (dp[i][j] > ans) {
			ans = dp[i][j];
			roomNo = room[i][j];
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();

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
			dp = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					bfs(i, j);

				}
			}
			sb.append("#").append(tc).append(" ").append(roomNo).append(" ").append(ans).append("\n");

		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}

}