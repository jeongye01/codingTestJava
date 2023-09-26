import java.io.*;
import java.util.*;

public class Main {
	static char board[][];
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		int sx = 0, sy = 0;
		for (int i = 0; i < N; i++) {
			String input = br.readLine().trim();
			for (int j = 0; j < M; j++) {
				board[i][j] = input.charAt(j);
				if (board[i][j] == '0') {
					sx = j;
					sy = i;
				}
			}
		}
		bfs(sx, sy);
	}

	public static void bfs(int sx, int sy) {
		boolean[][][] visited = new boolean[N][M][64];
		int[] dx = { 0, -1, 0, 1 };
		int[] dy = { -1, 0, 1, 0 };
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(sx, sy, 0, 0));
		visited[sy][sx][0] = true;

		while (!q.isEmpty()) {
			Node now = q.poll();
			// System.out.println(now.x + " " + now.y+ " "+Arrays.toString(now.keys));
			for (int d = 0; d < 4; d++) {
				int nx = now.x + dx[d];
				int ny = now.y + dy[d];
				if (ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx][now.key] || board[ny][nx] == '#') {
					continue;
				}
				if (board[ny][nx] == '1') {
					System.out.println(now.dis + 1);
					return;
				}
				if (board[ny][nx] >= 'A' && board[ny][nx] <= 'F') { // 문
					if ((now.key & 1 << (board[ny][nx] - 'A')) != (int) Math.pow(2, board[ny][nx] - 'A')) {
						continue;
					}
				}
				if (board[ny][nx] - 'a' >= 0 && board[ny][nx] - 'a' <= 6) {
					int next_key = 1 << (board[ny][nx] - 'a');
					next_key = now.key | next_key;
					visited[ny][nx][next_key] = true;
					q.offer(new Node(nx, ny, now.dis + 1, next_key));
				} else {
					visited[ny][nx][now.key] = true;
					q.offer(new Node(nx, ny, now.dis + 1, now.key));
				}
			}

		}
		System.out.println(-1);

	}

	public static class Node {
		int key;
		int x;
		int y;
		int dis;

		public Node(int x, int y, int dis, int key) {
			this.key = key;
			this.x = x;
			this.y = y;
			this.dis = dis;

		}
	}
}