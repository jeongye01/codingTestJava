import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		int N = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int arr[] = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[N];
		dp[0]=arr[0];
		int max=arr[0];
		for(int i=1;i<N;i++) {
			if(dp[i-1]<0) {
				dp[i]=arr[i];
			}else {
				dp[i]=dp[i-1]+arr[i];
			}
			max=Math.max(max, dp[i]);
		}
		System.out.println(max);
	
		
		
	

	}

}
