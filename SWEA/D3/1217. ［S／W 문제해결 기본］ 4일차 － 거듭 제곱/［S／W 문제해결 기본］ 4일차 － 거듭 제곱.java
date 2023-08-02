import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	private static int pow(int n,int m) {
		if(m==0) {
			return 1;
		}
		return n*pow(n,m-1);
	}
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for(int tc=1;tc<=T;tc++) {
			int dummy = Integer.parseInt(in.readLine());
			String[] sin=in.readLine().split(" ");
			int n=Integer.parseInt(sin[0]);
			int m=Integer.parseInt(sin[1]);
			System.out.println("#"+tc+" "+pow(n,m));
		}
		
	}
}