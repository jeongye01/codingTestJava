import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int arr[];
	static int dp[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		dp = new int[N];
		dp[0]=-1;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i < N; i++) {
			if (arr[i - 1] > arr[i]) {
				dp[i] = i - 1;
			} else {
				int j = i - 1;
				while (j >= 0 &&dp[j]>=0 && arr[dp[j]] <= arr[i]) {
					j -= 1;
				}
			
				dp[i] = j>=0? dp[j]:-1;
			

			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(dp[i]+1).append(" ");
		}
		System.out.println(sb.toString());

	}

}