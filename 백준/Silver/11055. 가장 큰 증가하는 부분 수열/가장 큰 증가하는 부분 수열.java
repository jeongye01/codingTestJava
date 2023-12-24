import java.io.*;
import java.util.*;

public class Main {



	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine().trim());
		int[] dp = new int[N];
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp[0]=arr[0];
		int ans=dp[0];
		for(int i=1;i<N;i++) {
			dp[i] = arr[i];
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j]) {
					dp[i]=Math.max(dp[j]+arr[i], dp[i]);
				}
			}
			ans= Math.max(ans, dp[i]);
		}
		
		
	    
	
		System.out.println(ans);

	}



	

	

}