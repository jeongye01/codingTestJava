import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//구역을 다섯 개의 선거구로 나눠야 하고
// ans: 인구가 가장 많은 선거구와 가장 적은 선거구의 인구 차이의 최솟값
public class Main {

	static int N;
	static int[][] board;
	static int total;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		board = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 1; j <= N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				total += board[i][j];
			}
		}
		solve();
		System.out.println(ans);

	}

	public static void solve() {
		for (int x = 1; x <= N; x++) {
			for (int y = 1; y <= N; y++) {
				for (int d1 = 1; d1 <= N; d1++) {
					for (int d2 = 1; d2 <= N; d2++) {

						if (x + d1 + d2 <= N && 1 <= y - d1 && y + d2 <= N) {
							boolean[][] border = new boolean[N + 1][N + 1];
							// 경계선 세팅
							for (int i = 0; i <= d1; i++) {
								border[x + i][y - i] = true;
								border[x + d2 + i][y + d2 - i]  = true;
							}

							for (int i = 0; i <= d2; i++) {
								border[x + i][y + i] = true;
								border[x + d1 + i][y - d1 + i] = true;
							}

						
							int min = total;
							int max = 0;
							// 1
							int cnt1 = 0;
							for (int r = 1; r < x + d1; r++) {
								for (int c = 1; c <= y; c++) {
									if (border[r][c])
										break;
									cnt1 += board[r][c];
								}
							}

							min = Math.min(min, cnt1);
							max = Math.max(max, cnt1);
							// 2
							int cnt2 = 0;
							for (int r = 1; r <= x + d2; r++) {
								for (int c = N; c > y ; c--) {
									if (border[r][c])
										break;
									cnt2 += board[r][c];

								}
							}
							min = Math.min(min, cnt2);
							max = Math.max(max, cnt2);
							// 3
							int cnt3 = 0;
							for (int r = x + d1; r <= N; r++) {
								for (int c = 1; c < y - d1 + d2; c++) {
									if (border[r][c])
										break;
									cnt3 += board[r][c];

								}
							}
							min = Math.min(min, cnt3);
							max = Math.max(max, cnt3);
							// 4
							int cnt4 = 0;
							for (int r = x + d2 + 1; r <= N; r++) {
								for (int c = N ; c >= y - d1 + d2; c--) {
									if (border[r][c])
										break;
									cnt4 += board[r][c];

								}
							}
							min = Math.min(min, cnt4);
							max = Math.max(max, cnt4);
							// 5
							int cnt5 = total - cnt1 - cnt2 - cnt3 - cnt4;
							// if(cnt5<=0)continue;
							min = Math.min(min, cnt5);
							max = Math.max(max, cnt5);

							
							ans = Math.min(ans, max - min);

						}

					}
				}
			}
		}

	}

}