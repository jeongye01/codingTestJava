

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//  ans : 이동할 때마다 주사위의 윗 면에 쓰여있는 수 
// 주사위는 지도 위에 윗 면이 1이고, 동쪽을 바라보는 방향이 3인 상태로 놓여져 
// 가장 처음에 주사위에는 모든 면에 0이 적혀져 있다.
// 이동한 칸에 쓰여 있는 수가 0이면, 주사위의 바닥면에 쓰여 있는 수가 칸에 복사된다. 
// 0이 아닌 경우에는 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사되며, 칸에 쓰여 있는 수는 0이 된다.
public class Main {
	static int N, M, x, y, K;
	static Dice dice;

	static class Dice {
		int x, y;
		int top, bottom, up, down, left, right;

		public Dice(int x, int y) {
			this.x = x;
			this.y = y;

		}
		@Override
		public String toString() {
			return top+" "+bottom+" "+up+" "+down+" "+left+" "+right;
		}
	}

	static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		dice = new Dice(x, y);
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < K; i++) {
			// 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
			switch (Integer.parseInt(st.nextToken())) {
			case 1: // 동쪽
				int nx = dice.x + 1;
				if (nx < M) {
					dice.x = nx;
					int tmp = dice.bottom;
					dice.bottom = dice.right;
					dice.right = dice.top;
					dice.top = dice.left;
					dice.left = tmp;
					if (board[dice.y][nx] == 0) {
						board[dice.y][nx] = dice.bottom;
					} else {
						dice.bottom = board[dice.y][nx];
						board[dice.y][nx] = 0;
					}
					sb.append(dice.top).append('\n');

				}

				break;
			case 2: // 서쪽
				nx = dice.x - 1;
				if (nx >= 0) {
					dice.x = nx;
					int tmp = dice.bottom;
					dice.bottom = dice.left;
					dice.left = dice.top;
					dice.top = dice.right;
					dice.right = tmp;
					if (board[dice.y][nx] == 0) {
						board[dice.y][nx] = dice.bottom;
					} else {
						dice.bottom = board[dice.y][nx];
						board[dice.y][nx] = 0;
					}
					sb.append(dice.top).append('\n');

				}
				break;
			case 3: // 북쪽
				int ny = dice.y - 1;
				if (ny >= 0) {
					dice.y = ny;
					int tmp = dice.bottom;
					dice.bottom = dice.up;
					dice.up = dice.top;
					dice.top = dice.down;
					dice.down = tmp;
					if (board[ny][dice.x] == 0) {
						board[ny][dice.x] = dice.bottom;
					} else {
						dice.bottom = board[ny][dice.x];
						board[ny][dice.x] = 0;
					}
					sb.append(dice.top).append('\n');
				}
				break;
			case 4: // 남쪽
				ny = dice.y + 1;
				if (ny < N) {
					dice.y = ny;
					int tmp = dice.bottom;
					dice.bottom = dice.down;
					dice.down = dice.top;
					dice.top = dice.up;
					dice.up = tmp;
					if (board[ny][dice.x] == 0) {
						board[ny][dice.x] = dice.bottom;
					} else {
						
						dice.bottom = board[ny][dice.x];
						board[ny][dice.x] = 0;
					}
					sb.append(dice.top).append('\n');
				}
				break;
			}
			//top, bottom, up, down, left, right;
			//System.out.println(dice);

			//

		}
		System.out.print(sb);

	}

}
