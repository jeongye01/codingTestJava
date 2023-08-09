import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int ans=0;
		int board[][] = new int[100][100];
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken()),y=Integer.parseInt(st.nextToken());
			for(int r=y;r<y+10;r++) {
				for(int c=x;c<x+10;c++) {
				        board[r][c]+=1;
				}
			}
		}
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(board[i][j]>0) {
					ans+=1;
				}
			}
		}
		System.out.println(ans);
	}

}