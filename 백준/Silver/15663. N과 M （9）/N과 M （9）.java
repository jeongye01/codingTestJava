import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;
	static int[] perm;
	static boolean[] selected;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		perm = new int[M];
	
		selected = new boolean[N];
		solve(0);

		System.out.println(sb);
	}

	private static void solve(int idx) {
		if (idx == M) {

			for (int e : perm) {
				sb.append(e).append(' ');

			}
			sb.append('\n');
			return;
		}
		perm[idx]  = -1;
		for (int i = 0; i < N; i++) {
			if (!selected[i] &&  perm[idx]!=arr[i]) {
				perm[idx] = arr[i];
				selected[i] = true;
				solve(idx + 1);
				selected[i] = false;
			}
		}
	}

}