import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int board[][];
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	private static void bfs() {
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { 0, 0 });
		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = now[0] + dx[d], ny = now[1] + dy[d];
				if (nx >= 0 && nx < M && ny >= 0 && ny < N && board[ny][nx] == 1) {
					board[ny][nx] += board[now[1]][now[0]];
					q.add(new int[] { nx, ny });
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			char[] chs = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				board[i][j] = (int) (chs[j]-'0');
			}
		}
		bfs();
		//for(int i=0;i<N;i++) {
			//System.out.println(Arrays.toString(board[i]));
		//}
		System.out.println(board[N - 1][M - 1]);

	}

}