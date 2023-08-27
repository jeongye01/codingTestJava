

import java.util.*;
import java.io.*;

public class Main {
	static int N, M, ans, D;
	static List<int[]> enemy;
	static int board[][];
	static boolean selected[];
	static int players[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		selected = new boolean[M];
		players = new int[3];
		enemy = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < M; j++) {
				int input = Integer.parseInt(st.nextToken());
				if (input == 1) {
					enemy.add(new int[] { j, i, 1 });
				}

			}

		}

		pick(0, 0);

		System.out.println(ans);

	}

	static class Enemy implements Comparable<Enemy> {
		int x;
		int y;
		int d;
		int idx;

		public Enemy(int x, int y, int idx, int d) {
			this.x = x;
			this.y = y;
			this.idx = idx;
			this.d = d;
		}

		@Override
		public int compareTo(Enemy e) {
			if (this.d == e.d) {
				return this.x - e.x;
			}
			return this.d - e.d;
		}
	}

	private static void play() {

		List<int[]> copyEnemy=new ArrayList<>() ;
		for(int i=0;i<enemy.size();i++) {
			int[] pos = enemy.get(i);
			copyEnemy.add(new int[] {pos[0],pos[1],pos[2]});
		}
		int deleted = enemy.size();
		int point = 0;
		while (deleted > 0) {
			PriorityQueue<Enemy> q1 = new PriorityQueue<>();
			PriorityQueue<Enemy> q2 = new PriorityQueue<>();
			PriorityQueue<Enemy> q3 = new PriorityQueue<>();
			// System.out.println(deleted);
			for (int i = 0; i < enemy.size(); i++) {
				int[] pos = copyEnemy.get(i);
				if (pos[2] == 0) {

					continue;
				}
				int ex = pos[0], ey = pos[1];
				int d1 = Math.abs(ex - players[0]) + Math.abs(ey - N);
				//System.out.println(d1);
				if (d1 <= D) {
					q1.offer(new Enemy(ex, ey, i, d1));
				}
				int d2 = Math.abs(ex - players[1]) + Math.abs(ey - N);
				if (d2 <= D) {
					q2.offer(new Enemy(ex, ey, i, d2));
				}
				int d3 = Math.abs(ex - players[2]) + Math.abs(ey - N);
				if (d3 <= D) {
					q3.offer(new Enemy(ex, ey, i, d3));
				}

			}
			Enemy kill1 = q1.poll();
			Enemy kill2 = q2.poll();
			Enemy kill3 = q3.poll();
			for (int i = 0; i < enemy.size(); i++) {
				// System.out.println(kill1.idx);
				if ((kill1 != null && i == kill1.idx) || (kill2 != null && i == kill2.idx)
						|| (kill3 != null && i == kill3.idx)) {
					copyEnemy.set(i, new int[] { -1, -1, 0 });
					deleted--;
					point++;
					//System.out.println("audwnd");
					continue;
				}
				copyEnemy.get(i)[1]++;
				if (copyEnemy.get(i)[1] >= N) {
					deleted--;
					copyEnemy.set(i, new int[] { -1, -1, 0 });
				}

			}

		}
        //System.out.println(point+"point");
		ans = Math.max(ans, point);

	}

	private static void pick(int cnt, int idx) {
		if (cnt == 3) {
			play();
			return;
		}
		for (int i = idx; i < M; i++) {
			if (!selected[i]) {
				selected[i] = true;
				players[cnt] = i;
				pick(cnt + 1, i+1);
				selected[i] = false;

			}
		}

	}

}