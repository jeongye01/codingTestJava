import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] info;
	static int[] picked;
	static boolean[] selected;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		flag = false;
		info = new int[N];
		picked = new int[N];
		selected = new boolean[N];
		for (int i = 0; i < N; i++) {
			info[i] = Integer.parseInt(st.nextToken());
		}
		order(0, 0);

	}

	public static void order(int p, int cnt) {

		if (cnt == N) {
			for (int i = N - 1; i >= 0; i--) {
				int taller = 0;
				for (int j = 0; j < i; j++) {
					if (picked[j] > picked[i]) {
						taller++;
					}
				}
				if (taller != info[picked[i]]) {
					return;

				}
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				sb.append(picked[i] + 1).append(" ");
			}
			sb.append("\n");
			System.out.println(sb);
			flag = true;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!flag && !selected[i]) {
				selected[i] = true;
				picked[cnt] = i;
				order(i + 1, cnt + 1);
				selected[i] = false;
			}

		}
	}

}