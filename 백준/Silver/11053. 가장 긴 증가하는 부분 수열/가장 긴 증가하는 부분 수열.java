
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[N];
		dp[0]=1;
		int ans=1;
		for(int i=1;i<N;i++) {
			int max=0;
			for(int j=i-1;j>=0;j--) {
				if(arr[j]<arr[i] && dp[j]>max) {
					max=dp[j];
				}
			}
			dp[i]=max+1;
			ans = Math.max(ans, max+1);
		}
		System.out.println(ans);
	

	}

}
