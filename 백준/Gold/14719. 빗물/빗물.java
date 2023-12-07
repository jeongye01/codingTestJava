import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int H, W;
	static int[] arr;
	static int[] dp;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		arr = new int[W];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < W; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

		}
		for (int i = 1; i < W - 1; i++) {
			int s = arr[i];
			int e = arr[i];
			for (int j = i - 1; j >= 0; j--) {

				if (arr[j] > s) {
					s = arr[j];
				}
			}
			for (int j = i + 1; j < W; j++) {
				if (arr[j] > e) {
					e = arr[j];
				}
			}
			if (s != arr[i] && e != arr[i]) {
				ans += Math.min(s, e) - arr[i];
				// System.out.println(s + " " + e + " " + (Math.min(s, e) - arr[i]) + " " + i);
			}
		}
		System.out.println(ans);

	}

}