import java.io.*;
import java.util.*;

public class Main {
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	    StringBuilder sb = new StringBuilder();
	   
		int N = Integer.parseInt(br.readLine().trim());
		Set<Integer> set = new HashSet<>();
		st = new StringTokenizer(br.readLine().trim());
        for(int i=0;i<N;i++) {
        	set.add(Integer.parseInt(st.nextToken()));
		}
       
		int M = Integer.parseInt(br.readLine().trim());
		st = new StringTokenizer(br.readLine().trim());
		for(int i=0;i<M;i++) {
			sb.append(set.contains(Integer.parseInt(st.nextToken()))?1:0).append('\n');
		}
		
		System.out.println(sb);

	}

}