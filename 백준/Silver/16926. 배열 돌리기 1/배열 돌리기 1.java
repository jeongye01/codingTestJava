import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R;
	static int arr[][];

	private static void rotate() {
		int rst = 0, cst = 0, ced = M - 1, red = N - 1;
		while (red - rst >= 1 && ced - cst >= 1) {
			for (int t = 0; t < R; t++) {
				int corner = arr[rst][cst];

				for (int i = cst; i < ced; i++) {
					arr[rst][i] = arr[rst][i + 1];
				}
				for (int i = rst; i < red; i++) {
					arr[i][ced] = arr[i + 1][ced];
				}
				for (int i = ced; i > cst; i--) {
					arr[red][i] = arr[red][i - 1];
				}

				for (int i = red; i > rst; i--) {
					arr[i][cst] = arr[i - 1][cst];
				}
				arr[rst + 1][cst] = corner;

			}
			rst+=1;
			cst+=1;
			ced-=1;
			red-=1;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		rotate();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);

	}

}