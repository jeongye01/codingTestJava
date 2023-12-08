import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// 축구를 하기 위해 모인 사람은 총 N명이고 신기하게도 N은 짝수
// Sij는 Sji와 다를 수도 있으며, i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치는 Sij와 Sji이다.
// 축구를 재미있게 하기 위해서 스타트 팀의 능력치와 링크 팀의 능력치의 차이를 최소로 하려고 한다.

public class Main {

	static int N;
	static int[][] board;
	static int[] selected;
	static boolean[] visited;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		board = new int[N][N];
		selected = new int[N / 2];
		visited = new boolean[N + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = Integer.MAX_VALUE;
		setting(0, -1);
		System.out.println(ans);

	}

	public static void setting(int cnt, int idx) {
		if (cnt == N / 2) {
			int team1 = 0, team2 = 0;
			int[] teamDivide = new int[N];

			for (int i = 0; i < N / 2; i++) {
				teamDivide[selected[i]] = 1;
			}
			// System.out.println(Arrays.toString(teamDivide));
			for (int i = 0; i < N - 1; i++) {
				for (int j = i; j < N; j++) {
					if (teamDivide[i] == 1 && teamDivide[j] == 1) {
						team1 += (board[i][j] + board[j][i]);
					} else if (teamDivide[i] == 0 && teamDivide[j] == 0) {
						team2 += (board[i][j] + board[j][i]);
					}

				}
			}
			ans = Math.min(ans, Math.abs(team2 - team1));
			return;
		}
		for (int i = idx + 1; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				selected[cnt] = i;
				setting(cnt + 1, i);
				visited[i] = false;
			}
		}
	}

}