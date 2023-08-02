import java.io.BufferedReader;
import java.io.InputStreamReader;




class Solution {
	static int ans=0;
	private static void sol(int[] shortt,int[] longg) {
		int max=Integer.MIN_VALUE;
		for(int st=0;st<longg.length-shortt.length+1;st++) {
			int sum=0;
			for(int i=0;i<shortt.length;i++) {
				sum+=shortt[i]*longg[st+i];
			}
			max=Math.max(max, sum);
		}
		ans=max;
		
	}
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc=1;tc<=T;tc++) {
			String[] sin=in.readLine().split(" ");
			int n=Integer.parseInt(sin[0]);
			int m=Integer.parseInt(sin[1]);
			int[] arr1=new int[n];
			int[] arr2=new int[m];
			String[] tmp=in.readLine().split(" ");
			for(int i=0;i<n;i++) {
				arr1[i]=Integer.parseInt(tmp[i]);
			}
			tmp=in.readLine().split(" ");
			for(int i=0;i<m;i++) {
				arr2[i]=Integer.parseInt(tmp[i]);
			}
			if(n<m) {
				sol(arr1,arr2);
			}else {
				sol(arr2,arr1);
			}
			System.out.println("#"+tc+" "+ans);
			
			
			 
		}
		
	}
}