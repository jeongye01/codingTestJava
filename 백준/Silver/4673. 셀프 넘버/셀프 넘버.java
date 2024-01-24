import java.io.*;
import java.util.*;
// 60분 소요 
public class Main {
	static int N;


	public static void main(String[] args) throws Exception {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		boolean[] nums = new boolean[10001];
		for(int i=1;i<=10000;i++) {
			int s=0;
			int tmp=i;
		
			while(tmp>0) {
				s+=(tmp%10);
				tmp/=10;
			
			}
			s+=tmp;
		   if(i+s>10000)continue;
		 
			nums[i+s]=true;
		}
		for(int i=1;i<=10000;i++) {
			if(!nums[i]) {
				sb.append(i).append('\n');
			}
		
		}
		System.out.println(sb);
	

	}

}