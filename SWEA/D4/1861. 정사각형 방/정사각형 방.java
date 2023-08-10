
import java.io.*;
import java.util.*;

public class Solution {
	static int N, roomNo, ans;
	static int room[][], dp[][];
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	private static int dfs(int r, int c) {
		if (dp[r][c] > 0) {
			return dp[r][c];
		}
		dp[r][c] = 1;

		for (int d = 0; d < 4; d++) {
			int nr = r + dy[d], nc = c + dx[d];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N) { 
				if(room[nr][nc] - room[r][c] == 1)	{
					dp[r][c]+=dfs(nr,nc);
				}															
			}
		}

		return dp[r][c];

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
			// 룸 번호 정보 받기
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
					dfs(i, j);
					if(dp[i][j]==ans) {
						if(roomNo>room[i][j]) {
							roomNo=room[i][j];
						}
					}
					if(dp[i][j]>ans) {
						ans=dp[i][j];
						roomNo=room[i][j];
						
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(roomNo).append(" ").append(ans).append("\n");

		}
		// 테스트 케이스 모두 진행 후 한번에 출력
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}

}
