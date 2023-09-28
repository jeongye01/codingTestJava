import java.io.*;
import java.util.*;

public class Main {
	static boolean board[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int ans = 0;

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

		}
		Arrays.sort(arr);

		System.out.println(arr[0] * arr[N - 1]);
	}

}