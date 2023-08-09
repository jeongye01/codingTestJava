

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R;
	static int arr[][];

	static void inst1() {
		int[][] tmp = new int[N][M];
		for (int i = 0; i < N; i++) {
			tmp[i] = arr[N - i - 1].clone();
		}
		arr = tmp.clone();
	}

	static void inst2() {
		int st = 0, ed = M - 1;
		while (st < ed) {
			for (int i = 0; i < N; i++) {
				int tmp = arr[i][ed];
				arr[i][ed] = arr[i][st];
				arr[i][st] = tmp;
			}
			st += 1;
			ed -= 1;
		}
	}

	static void inst3() {
		int[][] tmp = arr.clone();
		arr = new int[M][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[j][N - 1 - i] = tmp[i][j];
			}
		}
		int tt=N;
		N=M;
		M=tt;
	}

	static void inst4() {
		int[][] tmp = arr.clone();
		arr = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = tmp[j][M - 1 - i];
			}
		}
		int tt=N;
		N=M;
		M=tt;
	}

	static void inst5() {
		int[][] tmp = arr.clone();
		arr = new int[N][M];

		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				arr[i][j + (int) M / 2] = tmp[i][j];
			}
		}
		for (int i = 0; i < N / 2; i++) {
			for (int j = M / 2; j < M; j++) {
				arr[i + (int) N / 2][j] = tmp[i][j];
			}
		}
		for (int i = N / 2; i < N; i++) {
			for (int j = M / 2; j < M; j++) {
				arr[i][j - (int) M / 2] = tmp[i][j];
			}
		}
		for (int i = N / 2; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				arr[i - (int) N / 2][j] = tmp[i][j];
			}
		}
	}

	static void inst6() {
		int[][] tmp = arr.clone();
		arr = new int[N][M];

		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				arr[i + (int) N / 2][j] = tmp[i][j];
			}
		}
		for (int i = 0; i < N / 2; i++) {
			for (int j = M / 2; j < M; j++) {
				arr[i][j - (int) M / 2] = tmp[i][j];
			}
		}
		for (int i = N / 2; i < N; i++) {
			for (int j = M / 2; j < M; j++) {
				arr[i - (int) N / 2][j] = tmp[i][j];
			}
		}
		for (int i = N / 2; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				arr[i][j + (int) M / 2] = tmp[i][j];
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
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
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			
			int o = Integer.parseInt(st.nextToken());
			
			switch (o) {
			case 1:
				inst1();
				break;
			case 2:
				inst2();
				break;
			case 3:
				inst3();
				break;
			case 4:
				inst4();
				break;
			case 5:
				inst5();
				break;
			default:
				inst6();
				break;

			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

}
