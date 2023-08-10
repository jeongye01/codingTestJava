import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	static int ans,N,L,tasteSum;
	static int[][] arr;
	private static void bt(int idx,int p,int c,int h) {
		if(idx>=N) {
			 ans=Math.max(ans, p);
			 return;
		}
        if(tasteSum-h+p<ans){
            return;
        }
		if(c+arr[idx][1]<=L) {
			 bt(idx+1,p+arr[idx][0],c+arr[idx][1],h+arr[idx][0]);
		}
		 bt(idx+1,p,c,h+arr[idx][0]);
		
	}
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T=Integer.parseInt(st.nextToken());
		for(int tc=1;tc<=T;tc++) {
			ans=Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine());
			N= Integer.parseInt(st.nextToken());
			L= Integer.parseInt(st.nextToken());
			arr=new int[N][2];
            tasteSum=0;
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0]=Integer.parseInt(st.nextToken());
				arr[i][1]=Integer.parseInt(st.nextToken());
                tasteSum+=arr[i][0];
			}

			bt(0,0,0,0);
			
			System.out.println("#"+tc+" "+ans);
		}
		
	}
}