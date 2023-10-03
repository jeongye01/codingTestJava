import java.util.*;
import java.io.*;

public class Main {
	static int[][] paper;
	static int result[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		paper = new int[N][N];
		result = new int[3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}

		}
		count(0, 0, N);
		for (int i = 0; i < 3; i++) {
			System.out.println(result[i]);
		}
	}

	static void count(int sr, int sc, int n) {
		boolean check = true;
		int start = paper[sr][sc];
		for (int i = sr; i < sr + n; i++) {
			for (int j = sc; j < sc + n; j++) {
				if (paper[i][j] != start) {
					check = false;
					break;
				}
			}
			if (!check) {
				break;
			}
		}
		if (!check) {
			for (int i = sr; i < sr + n; i += n / 3) {
				for (int j = sc; j < sc + n; j += n / 3) {
					count(i, j, n / 3);
				}
			}

		} else {
			result[start + 1]++;
			return;
		}
	}

}