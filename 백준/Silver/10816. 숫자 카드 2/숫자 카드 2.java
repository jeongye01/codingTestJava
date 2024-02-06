
import java.io.*;
import java.util.*;

public class Main {
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	    StringBuilder sb = new StringBuilder();
	    Map<Integer,Integer> map = new HashMap<>();
		int N = Integer.parseInt(br.readLine().trim());
		st = new StringTokenizer(br.readLine().trim());
		for(int i=0;i<N;i++) {
			Integer n =  Integer.parseInt(st.nextToken());
			Integer cnt = map.get(n);
			if(cnt!=null) {
				map.put(n,cnt+1);
			}else {
				map.put(n,1);
			}
			
		}
		int M = Integer.parseInt(br.readLine().trim());
		st = new StringTokenizer(br.readLine().trim());
		for(int i=0;i<M;i++) {
			Integer n =  Integer.parseInt(st.nextToken());
			Integer cnt = map.get(n);
			if(cnt!=null) {
				sb.append(cnt).append(' ');
			}else {
				sb.append(0).append(' ');
			}
			
		}
		System.out.println(sb);
	}

}