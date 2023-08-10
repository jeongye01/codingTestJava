import java.io.*;
import java.util.*;
public class Solution {
	static int N, roomNo, ans; 
	static int room[][], dp[][];//dp->메모이제이션
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	private static void bfs(int i, int j) {
		Deque<int[]> deque = new ArrayDeque<>(); 
		deque.add(new int[] { i, j });
		dp[i][j] = 1;
		while (!deque.isEmpty()) {
			int[] now = deque.poll();
			for (int d = 0; d < 4; d++) {
				int ni = now[0] + dy[d], nj = now[1] + dx[d];
				if (ni >= 0 && ni < N && nj >= 0 && nj < N && room[ni][nj] - room[now[0]][now[1]] == 1) { //범위 안에 있는지 && 현재 방보다 1큰 수의 방인지 확인  
					if (dp[ni][nj] != 0) {// 이미 탐색할수 있는 방 개수 정보를 가진 방이라면 더해주고 더 탐색하지 않는다.
						dp[i][j] += dp[ni][nj]; 
					} else {// 탐색 진행 
						dp[i][j] += 1;
						deque.add(new int[] { ni, nj });
					}
				}
			}
		}
		
		if (dp[i][j] == ans) { 
			if (roomNo > room[i][j]) { // 룸 넘버 갱신 
				roomNo = room[i][j];
			}
		} else if (dp[i][j] > ans) { //최대값 갱신 
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
            // 룸 번호 정보 받기  
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			ans = -1;
			dp = new int[N][N];
			// 각 방마다 bfs 진행  
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					bfs(i, j);

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