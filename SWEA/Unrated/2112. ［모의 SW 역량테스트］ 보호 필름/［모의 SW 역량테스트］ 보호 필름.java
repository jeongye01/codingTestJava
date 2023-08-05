

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	static int ans, D, W, K;
	static int[][] arr;
	static int selected[];

	private static void pick(int idx, int cnt) {
		
		boolean check = true;
		// System.out.println(Arrays.toString(selected));

		for (int c = 0; c < W; c++) {
			int repeat = 1;
			for (int r = 1; r < D; r++) {
				int e1 = selected[r - 1] == 0 ? arr[r - 1][c] : (selected[r - 1] - 1);
				int e2 = selected[r] == 0 ? arr[r][c] : (selected[r] - 1);
				if (e1 == e2) {
					repeat += 1;
					if (repeat >= K) {
						break;
					}
				} else {
					repeat = 1;
				}
			}
			if (repeat < K) {
				check = false;
				break;
			}

		}

		if (check) {
			ans=Math.min(cnt,ans);
			return;
		}
		if(idx==D) {
			return;
		}
	
		selected[idx] = 1;
		pick(idx + 1, cnt + 1);
		selected[idx] = 2;
		pick(idx + 1, cnt + 1);
		selected[idx]=0;
		pick(idx + 1, cnt);
	
	

	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[D][W];
			selected = new int[D];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ans=K;
			pick(0, 0);

			System.out.println("#" + tc + " " + ans);
		}

	}
}