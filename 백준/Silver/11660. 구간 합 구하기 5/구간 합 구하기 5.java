import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] sin=in.readLine().split(" ");
		int N=Integer.parseInt(sin[0]);
		int M=Integer.parseInt(sin[1]);
		int[][] arr=new int[N+1][N+1];
		for(int i=1;i<N+1;i++) {
			sin=in.readLine().split(" ");
			for(int j=1;j<N+1;j++) {
				arr[i][j]=arr[i][j-1]+arr[i-1][j]-arr[i-1][j-1]+Integer.parseInt(sin[j-1]);
			}
		}
		for(int i=0;i<M;i++) {
			sin=in.readLine().split(" ");
			int sty=Integer.parseInt(sin[0]);
			int stx=Integer.parseInt(sin[1]);
			int edy=Integer.parseInt(sin[2]);
			int edx=Integer.parseInt(sin[3]);
			
				System.out.println(arr[edy][edx]-arr[sty-1][edx]-arr[edy][stx-1]+arr[sty-1][stx-1]);
			
			
			
		}
		
	}

}

