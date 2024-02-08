import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int s = 0, e = 0;
		int sum = arr[0];
		int ans =  0;
		while (true) {
			if (sum == M)
				ans++;
			if (e == N - 1 && s == e)
				break;
			if (s < e && (sum > M || e == N - 1)) {
				sum -= arr[s];
				s++;
			} else {
				e++;
				sum += arr[e];
			}
			

		}
		System.out.println(ans);

	}

}