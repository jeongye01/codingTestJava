import java.io.*;
import java.util.*;
// 60분 소요 
public class Main {
	static int N;
	static int[] arr;
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine().trim());
		arr = new int[N];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {

			// y = ax+b를 구해야함
			int cnt = 0;
			
			for (int j = i + 1; j < N; j++) {
				if(j==i+1) {
					cnt++;
					continue;
				}
				double a = (double) (arr[j] - arr[i]) / (j - i);
				double b = arr[i]-a*i;
                boolean check=true;
              
				for(int s=i+1;s<j;s++) {
					 
					if(arr[s]>=a*s+b) {
						check=false;
						break;
					}
				}
				if(check) {
					cnt++;
				}
				
				
			}

			for (int j = i - 1; j >= 0; j--) {
				if(j==i-1) {
					cnt++;
					continue;
				}
				double a = (double) (arr[i] - arr[j]) / (i - j);
				double b = arr[i]-a*i;
                boolean check=true;
				for(int s=i-1;s>j;s--) {
					if(arr[s]>=a*s+b) {
						check=false;
						break;
					}
				}
				if(check) {
					cnt++;
				}
			}
			
			max=Math.max(max, cnt);

		}
		System.out.println(max);

	}

}