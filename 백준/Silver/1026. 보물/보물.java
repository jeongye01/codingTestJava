import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int ans = 0;

		int N = Integer.parseInt(br.readLine().trim());
		int[] arra = new int[N];
		int[] arrb = new int[N];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			arra[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			arrb[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arra);
		Arrays.sort(arrb);
		for (int i = 0; i < N; i++) {
			ans += (arra[i] * arrb[N - i - 1]);
		}

		System.out.println(ans);

	}
}