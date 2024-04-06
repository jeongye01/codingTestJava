
import java.io.*;
import java.util.*;

public class Main {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine().trim());
		int dp[] = new int[N<=2?3:N+1];
		dp[1]=1;
		dp[2]=2;
		for(int i=3;i<=N;i++) {
			dp[i]=(dp[i-1]+dp[i-2])%15746;
		}
		System.out.println(dp[N]);

	}

}
