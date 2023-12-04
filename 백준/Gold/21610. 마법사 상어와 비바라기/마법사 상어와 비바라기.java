import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// 각 칸에는 바구니가 "하나" 있고, 물을 저장. 양은 무제한 
// 끝  행,열 연결되어 있음. 
// 비바라기 : ,(N-1,1),(N-2,0),(N-2,1) 에 비구름 생김 . 구름은 칸 전체 차지
// ans :M번의 이동이 모두 끝난 후 바구니에 들어있는 물의양의 합 

public class Main {
	static int N, M;
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };

	static boolean[][] cloudDie;
	static int[][] water;
	static List<int[]> cloudP;
	static List<int[]> waterR;
	static int ans;

//	public static class Cloud {
//		int s, d;
//
//		public Cloud(int s, int d) {
//			this.d = d;
//			this.s = s;
//		}
//	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = 0;
		cloudDie = new boolean[N][N];
		water = new int[N][N];
		cloudP = new ArrayList<>();
		waterR = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				water[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ans = 0;
		// 비바라기
		cloudP.add(new int[] { N - 1, 0 });
		cloudP.add(new int[] { N - 1, 1 });
		cloudP.add(new int[] { N - 2, 0 });
		cloudP.add(new int[] { N - 2, 1 });
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			move(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())); // d,s가 순서대로 주어짐
//			for (int k = 0; k < N; k++) {
//				System.out.println(Arrays.toString(water[k]));
//				
//			}
//			System.out.println();
		}
		


		calAns();

		System.out.println(ans);
	}

	public static void calAns() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				ans += water[i][j];

			}
		}
	}

	public static void move(int d, int s) {
		// 1. 모든 구름이 d,s로 이동
		for (int[] p : cloudP) {

			int ny = (p[0] + dy[d] * s) % N;
			int nx = (p[1] + dx[d] * s) % N;
			if (ny < 0) {
				ny += N;
			}
			if (nx < 0) {
				nx += N;
			}
			// 2. 비 내리기
			water[ny][nx] += 1;

			// 3. 구름 사라지기
			cloudDie[ny][nx] = true;
			waterR.add(new int[] { ny, nx });

		}
		// 4. 물복사 버그
		for(int[] p: waterR) {
			
			for (int dd = 1; dd < 8; dd += 2) {
				int dny = p[0] + dy[dd];
				int dnx = p[1] + dx[dd];
				if (dny < 0 || dny >= N || dnx < 0 || dnx >= N || water[dny][dnx] == 0) {
					continue;
				}
				water[p[0]][p[1]] += 1;

			}
		}

		cloudP.clear();
		waterR.clear();
		// 5. 구름 생성
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (water[i][j] >= 2 && !cloudDie[i][j]) {
					cloudP.add(new int[] { i, j });
					water[i][j] -= 2;
				}
				cloudDie[i][j] = false;
			}
		}

	}

}