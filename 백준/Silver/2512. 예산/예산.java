import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int[] arr = new int[N];
		int max=0;
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max=Math.max(max, arr[i]);
		}
		int M = Integer.parseInt(br.readLine().trim());
		int s=0;
		int e=max;
		int ans=0;

		while(s<=e) {
			int mid = (s+e)/2;
			int sum=0;
			for(int n:arr) {
				if(mid>=n) {
					sum+=n;
				}else {
					sum+=mid;
				}
			}
			
			if(sum<=M) {
				s=mid+1;
				ans=mid;
			}else {
				e=mid-1;
			}
		}
		System.out.println(ans);

	}

}