import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			int[] dp0 = new int[41];
			int[] dp1 = new int[41];
			dp0[0]=1;
		    dp1[0]=0;
		    dp0[1]=0;
		    dp1[1]=1;
			for(int i=2;i<=N;i++) {
				dp0[i]=dp0[i-1]+dp0[i-2];
				dp1[i]=dp1[i-1]+dp1[i-2];
			}
			sb.append(dp0[N]).append(" ").append(dp1[N]).append("\n");
			
		}
		System.out.println(sb);

	}
}
