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
		int[] arr=new int[N+1];
		sin=in.readLine().split(" ");
		for(int i=1;i<N+1;i++) {
			arr[i]=arr[i-1]+Integer.parseInt(sin[i-1]);
		}
		for(int i=0;i<M;i++) {
			sin=in.readLine().split(" ");
			int st=Integer.parseInt(sin[0]);
			int ed=Integer.parseInt(sin[1]);
			System.out.println(arr[ed]-arr[st-1]);
			
		}
		
	}

}