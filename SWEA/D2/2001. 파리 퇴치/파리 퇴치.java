import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T=Integer.parseInt(st.nextToken());
		for(int tc=1;tc<=T;tc++) {
			int ans=0;
			st = new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			int [][] board=new int[N][N];
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					board[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0;i<=N-M;i++) {
				for(int j=0;j<=N-M;j++) {
					int sum=0;
					for(int k=i;k<i+M;k++) {
						for(int z=j;z<j+M;z++) {
							sum+=board[k][z];
						}
					}
					ans=Math.max(ans, sum);
				}
				
				
			}
			System.out.println("#"+tc+" "+ans);
		}
	}

}