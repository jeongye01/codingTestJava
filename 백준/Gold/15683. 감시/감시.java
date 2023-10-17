
import java.util.*;
import java.io.*;

public class Main {
	static class CCTV {
		int x;
		int y;
		int n;
		int c;

		public CCTV(int x, int y, int n, int c) {
			this.x = x;
			this.y = y;
			this.n = n;
			this.c = c;
		}

		void setC(int c) {
			this.c = c;
		}

	}

	static char[][] map;
	static char[][] map2;
	static int N, M;
	static List<CCTV> cctvs;
	static int ans, cntZero;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cctvs = new ArrayList<>();
		map = new char[N][M];
		ans = 0;
		cntZero = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < M; j++) {
				char c = st.nextToken().charAt(0);
				map[i][j] = c;
				if (map[i][j] <= '5' && map[i][j] >= '1') {
					cctvs.add(new CCTV(j, i, map[i][j] - '0', 1));
				}
				if (map[i][j] == '0') {
					ans++;
				}
			}
		}

		map2 = new char[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				map2[i][j] = map[i][j];

			}
		}

		play(0);
		System.out.println(ans);

	}

	public static void change() {

		for (CCTV c : cctvs) {

			if (c.n == 1) {
				if (c.c == 1) {
					seeUp(c.x, c.y);
				} else if (c.c == 2) {
					seeRight(c.x, c.y);
				} else if (c.c == 3) {
					seeDown(c.x, c.y);
				} else {
					seeLeft(c.x, c.y);
				}

			} else if (c.n == 2) {
				if (c.c == 1) {

					see21(c.x, c.y);
				} else if (c.c == 2) {
					see22(c.x, c.y);
				}
			} else if (c.n == 3) {
				if (c.c == 1) {
					see31(c.x, c.y);
				} else if (c.c == 2) {
					see32(c.x, c.y);
				} else if (c.c == 3) {
					see33(c.x, c.y);
				} else {
					see34(c.x, c.y);
				}
			} else if (c.n == 4) {
				if (c.c == 1) {
					see41(c.x, c.y);
				} else if (c.c == 2) {
					see42(c.x, c.y);
				} else if (c.c == 3) {
					see43(c.x, c.y);
				} else {
					see44(c.x, c.y);
				}
			} else {
				see5(c.x, c.y);
			}
		}
	}

	public static void play(int depth) {
		if (depth == cctvs.size()) {
			change();
			int tmp = 0;
			for (int i = 0; i < N; i++) {
                //System.out.println(Arrays.toString(map[i]));
				for (int j = 0; j < M; j++) {

					if (map[i][j] == '0') {
						tmp++;
					}
				}
			}
			//System.out.println();
			ans = Math.min(ans, tmp);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {

					map[i][j] = map2[i][j];

				}
			}
			return;
		}

		if (cctvs.get(depth).n == 1 || cctvs.get(depth).n == 3 || cctvs.get(depth).n == 4) {
			play(depth + 1);
			cctvs.get(depth).setC(2);
			play(depth + 1);
			cctvs.get(depth).setC(3);
			play(depth + 1);
			cctvs.get(depth).setC(4);
			play(depth + 1);
			cctvs.get(depth).setC(1);
		} else if (cctvs.get(depth).n == 2) {

			play(depth + 1);
			cctvs.get(depth).setC(2);
			play(depth + 1);
			cctvs.get(depth).setC(1);
		} else {

			play(depth + 1);
		}

	}

	public static void seeRight(int x, int y) {
		// ->
		for (int j = x + 1; j < M; j++) {
			if (map[y][j] == '6')
				break;
			else if (map[y][j] != '0')
				continue;
			map[y][j] = '#';
		}

	}

	public static void seeDown(int x, int y) {

		// 아래
		for (int i = y + 1; i < N; i++) {
			if (map[i][x] == '6')
				break;
			else if (map[i][x] != '0')
				continue;
			map[i][x] = '#';
		}

	}

	public static void seeLeft(int x, int y) {

		// <-
		for (int j = x-1; j >= 0; j--) {
			if (map[y][j] == '6')
				break;
			else if (map[y][j] != '0')
				continue;
			map[y][j] = '#';
		}

	}

	public static void seeUp(int x, int y) {

		// 위
		for (int i = y-1; i >= 0; i--) {
			if (map[i][x] == '6')
				break;
			else if (map[i][x] != '0')
				continue;
			map[i][x] = '#';
		}

	}

	public static void see21(int x, int y) {
		// 좌우가로방향
		seeLeft(x, y);
		seeRight(x, y);

	}

	public static void see22(int x, int y) {
		seeUp(x, y);
		seeDown(x, y);
	}

	public static void see41(int x, int y) {
		seeUp(x, y);
		seeLeft(x, y);
		seeRight(x, y);

	}

	public static void see42(int x, int y) {
		seeDown(x, y);
		seeLeft(x, y);
		seeRight(x, y);

	}

	public static void see43(int x, int y) {
		seeDown(x, y);
		seeUp(x, y);
		seeRight(x, y);

	}

	public static void see44(int x, int y) {
		seeDown(x, y);
		seeUp(x, y);
		seeLeft(x, y);

	}

	public static void see31(int x, int y) {
		seeUp(x, y);
		seeRight(x, y);

	}

	public static void see32(int x, int y) {
		seeDown(x, y);
		seeRight(x, y);

	}

	public static void see33(int x, int y) {
		seeDown(x, y);
		seeLeft(x, y);

	}

	public static void see34(int x, int y) {
		seeUp(x, y);
		seeLeft(x, y);

	}

	public static void see5(int x, int y) {
		seeDown(x, y);
		seeUp(x, y);
		seeRight(x, y);
		seeLeft(x, y);

	}

}