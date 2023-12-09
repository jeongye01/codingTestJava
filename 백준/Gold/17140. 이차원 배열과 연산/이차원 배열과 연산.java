import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//ans :  A[r][c]에 들어있는 값이 k가 되기 위한 최소 시간
public class Main {

	static int R, C, K;
	static int rSize = 3, cSize = 3;
	static int[][] board = new int[100][100];
	static int ans = 0;

	static class Number implements Comparable<Number> {
		int num, cnt;

		public Number(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;

		}

		@Override
		public int compareTo(Number o) {
			if (o.cnt == this.cnt) {
				return this.num - o.num;
			}
			return this.cnt - o.cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < 3; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve();
		System.out.println(ans > 100 ? -1 : ans);

	}

	public static void solve() {
		while (true) {
//			for(int i=0;i<rSize;i++) {
//				System.out.println(Arrays.toString(board[i]));
//			}
//			System.out.println();
			if (ans > 100 || (board[R - 1][C - 1] == K))
				return;

			if (rSize >= cSize) { // R연산
				int size = 0;
				for (int i = 0; i < rSize; i++) {
					HashMap<Integer, Integer> map = new HashMap<>();
					for (int j = 0; j < cSize; j++) {
                        if(board[i][j]==0)continue;
						if (map.get(board[i][j]) == null) {
							map.put(board[i][j], 1);
						} else {
							map.put(board[i][j], map.get(board[i][j]) + 1);
						}
					}
					PriorityQueue<Number> q = new PriorityQueue<>();
					Iterator<Integer> keys = map.keySet().iterator();
					while (keys.hasNext()) {
						int key = keys.next();
						q.add(new Number(key, map.get(key)));
					}
					int idx = 0;
					while (!q.isEmpty() && idx < 100) {
						Number now = q.poll();
						board[i][idx++] = now.num;
						board[i][idx++] = now.cnt;
					}
					if (size < idx) {
						size = idx;
					}
					for(int l=idx;l<100;l++)  {
						board[i][l] = 0;
					}
					// System.out.println(Arrays.toString(board[i]));

				}
				cSize = size;
			} else { // C연산
				int size = 0;
				for (int j = 0; j < cSize; j++) {
					HashMap<Integer, Integer> map = new HashMap<>();
					for (int i = 0; i < rSize; i++) {
						if(board[i][j]==0)continue;
						if (map.get(board[i][j]) == null) {
							map.put(board[i][j], 1);
						} else {
							map.put(board[i][j], map.get(board[i][j]) + 1);
						}
					}
					PriorityQueue<Number> q = new PriorityQueue<>();
					Iterator<Integer> keys = map.keySet().iterator();
					while (keys.hasNext()) {
						int key = keys.next();
						q.add(new Number(key, map.get(key)));
					}
					int idx = 0;
					while (!q.isEmpty() && idx < 100) {
						Number now = q.poll();
						board[idx++][j] = now.num;
						board[idx++][j] = now.cnt;
					}
					if (size < idx) {
						size = idx;
					}
					for(int l=idx;l<100;l++)  {
						board[l][j] = 0;
					}

				}
				rSize = size;
			}

			ans++;
		}
	}

}