import java.io.*;
import java.util.*;

public class Main {
	static int N, M, board[][], distance[][][];
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];

		distance = new int[N][M][2];
		for (int i = 0; i < N; i++) {
			char[] chs = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				board[i][j] = chs[j] - '0';
			}
		}

		System.out.println(bfs());

	}

	public static int bfs() {
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { 0, 0, 0 });
		distance[0][0][0] = 1;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int x=now[0],y=now[1],breaked=now[2];
			if (x == M - 1 && y == N - 1) {
				return distance[N - 1][M - 1][breaked];
			}
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d], ny = y + dy[d];
				if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
					if (board[ny][nx] == 0 && distance[ny][nx][breaked]==0) {
						distance[ny][nx][breaked] = distance[y][x][breaked]+1;
						q.add(new int[] { nx, ny, breaked });
					} else if(board[ny][nx] == 1 && breaked==0){
						distance[ny][nx][1] = distance[y][x][breaked]+1;
						q.add(new int[] { nx, ny, 1 });

					}
					
					
				}
			}
		}
		return -1;
	};

}