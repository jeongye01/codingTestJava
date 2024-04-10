import java.io.*;
import java.util.*;
//ans : 적어도 M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값
public class Main {
	static int N,M;
    static int[] arr;
    static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	    StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	    arr = new int[N];
	    int max=0;
	    st = new StringTokenizer(br.readLine().trim());
	    for(int i=0;i<N;i++) {
	    	arr[i] = Integer.parseInt(st.nextToken());
	    	max=Math.max(max, arr[i]);
	    }
	    int s=0;
	    int e=max;
	    while(s<=e) {
	    	int mid=(s+e)/2;
	    	
	    	long sum=0;
	    	for(int t:arr) {
	    		if(t>mid) {
	    			sum+=t-mid;
	    		}
	    	}
	    	
	    	if(sum>=M) {
	    		ans=mid;
	    	    s=mid+1;
	    		
	    	}else {
	    		e=mid-1;
	    	}
	    	
	    	
	    }
	   
	    System.out.println(ans);
	}
	
}