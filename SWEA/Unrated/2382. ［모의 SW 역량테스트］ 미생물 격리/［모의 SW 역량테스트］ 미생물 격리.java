import java.io.*;
import java.util.*;

public class Solution {
	static int N, M, K;
	static List<int[]> data;
	static int tmp[][];
	static int[] dx = { 0, 0, 0, -1, 1 };
	static int[] dy = { 0, -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			data = new LinkedList<>();
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int[] tmpData = new int[4];
				for (int j = 0; j < 4; j++) {
					tmpData[j] = Integer.parseInt(st.nextToken());
				}
				data.add(tmpData);
			}

			for (int t = 0; t < M; t++) {
				tmp = new int[data.size()][4];

				for (int i = 0; i < data.size(); i++) {
					int y = data.get(i)[0] + dy[data.get(i)[3]], x = data.get(i)[1] + dx[data.get(i)[3]];
					if (x == 0 || x == N - 1 || y == 0 || y == N - 1) {// 약품 처리 공간 진입
						tmp[i][2] = (int) data.get(i)[2] / 2;
						tmp[i][3] = data.get(i)[3] == 1 || data.get(i)[3] == 3 ? data.get(i)[3] + 1
								: data.get(i)[3] - 1;
					} else {//
						tmp[i][2] = data.get(i)[2];
						tmp[i][3] = data.get(i)[3];
					}
					tmp[i][0] = y;
					tmp[i][1] = x;
				}
				Arrays.sort(tmp, new Comparator<int[]>() {
					public int compare(int[] row1, int[] row2) {
						int cmp = Integer.compare(row1[0], row2[0]); // 첫 번째 열을 기준으로 정렬
						if (cmp != 0) {
							return cmp;
						}
						return Integer.compare(row1[1], row2[1]); // 두 번째 열을 기준으로 정렬
					}
				});

				data = new LinkedList<>();

				for (int i = 0; i < tmp.length; i++) {
					int j = i + 1;
					int sum = tmp[i][2];
					int maxIdx = i;
					int y = tmp[i][0], x = tmp[i][1];
					while (i < tmp.length && j < tmp.length && x == tmp[j][1] && y == tmp[j][0]) {
						sum += tmp[j][2];

						if (tmp[maxIdx][2] < tmp[j][2]) {
							maxIdx = j;

						}
						i++;
						j++;
					}
					data.add(new int[] { y, x, sum, tmp[maxIdx][3] });

				}

			}

			for (int[] e : data) {
				ans += e[2];
			}
			System.out.println("#" + tc + " " + ans);

		}
	}

}