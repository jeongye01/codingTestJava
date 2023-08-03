import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    static int arr[][];
    static int N;
    static int ans=Integer.MAX_VALUE;
	private static void bt(int idx,int sin,int sen) {
		if(idx==N) {
			
			if(sen!=0) {
				ans=Math.min(ans, Math.abs(sin-sen));
			}
			
			return;
		}
    	bt(idx+1,sin*arr[idx][0],sen+arr[idx][1]);
    	bt(idx+1,sin,sen);
    }
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(in.readLine());
		String[] sin;
		arr=new int[N][2];
		for(int i=0;i<N;i++) {
			sin=in.readLine().split(" ");
			arr[i]=new int[] {Integer.parseInt(sin[0]),Integer.parseInt(sin[1])};
		}
		bt(0,1,0);
		System.out.println(ans);

	}

}