import java.util.*;
import java.io.*;

public class Main {
	static int N, M, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = Integer.MAX_VALUE;
		int mp = Integer.MAX_VALUE;
		int mn = Integer.MAX_VALUE;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim());

			int p = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			mp = Math.min(mp, p);
			mn = Math.min(mn, n);

		}
		if (mp <= mn * 6) {
			ans = (N / 6) * mp;

			if (N % 6 != 0) {
				ans += Math.min(mp, mn * (N % 6));
			}
			
		} else {
			ans = N * mn;
		}

		System.out.println(ans);
	}

}
