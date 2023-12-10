

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 총 T번 회전시키려고 한다. 
// i번째 회전할때 사용하는 변수는 xi, di, ki이다.
// ans : 원판을 T번 회전시킨 후 원판에 적힌 수의 합.
public class Main {
	static int N, M, T;
	static LinkedList<Integer> board[];
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		board = new LinkedList[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			board[i] = new LinkedList<>();
			for (int j = 0; j < M; j++) {
				board[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			rotate(x, d, k);
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				ans += board[i].get(j);
			}
		}
		System.out.println(ans);

	}

	public static void rotate(int x, int d, int k) {
		// 돌리기
		for (int i = 0; i < N; i++) {
			if ((i + 1) % x == 0) {
				for (int t = 0; t < k; t++) { // 회전
					if (d == 0) { // 시계방향
						board[i].offerFirst(board[i].pollLast());

					} else { // 반시계방향
						board[i].offerLast(board[i].pollFirst());
					}
				}

			}
		}
		// 인접한 수 확인

		boolean res = erase(); // 인접한 수 지웠는지 여부 반환

		if (!res) { // 평균내고 빼고 더하기
			int cnt = 0;
			int sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!board[i].get(j).equals(0)) {
						cnt++;
						sum += board[i].get(j);
					}

				}
			}
			if(cnt==0)return;
			double avg = (double)sum / cnt;
		
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					int num = board[i].get(j);
					if (num != 0) {
						if ((double)num > avg)
							board[i].set(j, num - 1);
						else if((double)num < avg)
							board[i].set(j, num + 1);

					}

				}
			}
			
			

		}
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(board[i].get(j) + " ");
//			}
//			System.out.println();
//		}

	}

	public static boolean erase() {
		boolean[][] visited = new boolean[N][M];
		boolean erased = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && !board[i].get(j).equals(0)) {
					bfs(visited, i, j);
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && !board[i].get(j).equals(0)) {
					bfs(visited, i, j);
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j] && !board[i].get(j).equals(0)) { // 인접한 애 있는지 확인
					boolean check = false;
					for (int d = 0; d < 4; d++) {
						int ny = i + dy[d];
						int nx = (j + dx[d]) % M;
						if (nx < 0)
							nx += M;
						if (ny < 0 || ny >= N)
							continue;
						if (board[i].get(j).equals(board[ny].get(nx))) {
							check = true;
							break;
						}

					}
					if (!check) {
						visited[i][j] = false;
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j]) { // 인접한 애 있는지 확인
					board[i].set(j, 0);
					erased = true;
				}
			}
		}
		return erased;
	}

	public static void bfs(boolean[][] visited, int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { i, j });
		visited[i][j] = true;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int y = now[0], x = now[1];
			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = (x + dx[d]) % M;
				if (nx < 0)
					nx += M;
				if (ny < 0 || ny >= N || visited[ny][nx] || board[ny].get(nx).equals(0)
						|| !board[ny].get(nx).equals( board[y].get(x)))
					continue;
				visited[ny][nx] = true;
				q.add(new int[] { ny, nx });

			}
		}

	}

}
