import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] board = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine().trim());
			for(int j=0;j<M;j++) {
				board[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		int T = Integer.parseInt(br.readLine().trim());
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine().trim());
			int I=Integer.parseInt(st.nextToken())-1;
			int J=Integer.parseInt(st.nextToken())-1;
			int X=Integer.parseInt(st.nextToken())-1;
			int Y=Integer.parseInt(st.nextToken())-1;
			int sum=0;
			for(int i=I;i<=X;i++) {
				for(int j=J;j<=Y;j++) {
					sum+=board[i][j];
				}
			}
			sb.append(sum).append('\n');
			
		}
		System.out.println(sb);
		
	}

}