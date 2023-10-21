
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N = 4, ans;
	static int dx[] = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int dy[] = { -1, -1, 0, 1, 1, 1, 0, -1 };

	static class Fish {

		int n;
		int d;

		public Fish(int n, int d) {

			this.n = n;
			this.d = d;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		Fish[][] map = new Fish[N][N];
		int n = 0;
		int d = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken()) - 1;
				if (i == 0 && j == 0) {
					n = a;
					d = b;
					continue;
				}
				map[i][j] = new Fish(a, b);

			}
		}
	
		ans = 0;
		

		bt(n, 0, 0, d, map);
		System.out.println(ans);

	}

	public static void moveOne(int number, int sharkX, int sharkY, Fish[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != null && map[i][j].n == number) {
					int d = map[i][j].d;

					for (int k = 0; k < 8; k++) {

						int ny = i + dy[(d + k) % 8];
						int nx = j + dx[(d + k) % 8];
						if (ny < 0 || ny >= N || nx < 0 || nx >= N || (ny == sharkY && nx == sharkX)) {
							continue;
						}

						Fish temp = new Fish(map[i][j].n, (d + k) % 8);
						map[i][j] = map[ny][nx] == null ? null : new Fish(map[ny][nx].n, map[ny][nx].d);
						map[ny][nx] = new Fish(temp.n, temp.d);

						break;

					}

					return;
				}
			}
		}
	}

	public static void move(int sharkX, int sharkY, Fish[][] map) {

		for (int n = 1; n <= 16; n++) {
			moveOne(n, sharkX, sharkY, map);
		}
	}

	public static void bt(int sum, int x, int y, int d, Fish[][] map) {

		int sx = x;
		int sy = y;
		move(x, y, map);

		
		while (true) {
			sx += dx[d];
			sy += dy[d];
			if (sx < 0 || sx >= N || sy < 0 || sy >= N) {

	

				ans = Math.max(ans, sum);
				return;
			}
			if (map[sy][sx] == null)
				continue;
			Fish f = map[sy][sx];

			Fish nmap[][] = new Fish[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					nmap[i][j] = map[i][j] == null ? null : new Fish(map[i][j].n, map[i][j].d);

				}
			}

			nmap[sy][sx] = null;
		

			
			
		
			bt(sum + f.n, sx, sy, f.d, nmap);

		}

	}

}
