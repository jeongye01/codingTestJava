import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
	public static final int div = 10007;
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] Triangle = new int[N+1][N+1]; 
        
		for(int i = 0; i < Triangle.length; i++) { 
			for(int j = 0; j <= i; j++) { 
				if(i == j || j == 0) Triangle[i][j] = 1; 
				else Triangle[i][j] = (Triangle[i-1][j-1] + Triangle[i-1][j]) % 10007; 
			} 
		} 
		System.out.println(Triangle[N][K]);
	}
}
