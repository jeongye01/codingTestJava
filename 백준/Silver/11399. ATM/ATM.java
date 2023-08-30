import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int ans = 0;
		int acc = 0;
		for (int i = 0; i < N; i++) {
			ans = ans + acc + arr[i];
			acc += arr[i];

		}
		System.out.println(ans);
	}
}