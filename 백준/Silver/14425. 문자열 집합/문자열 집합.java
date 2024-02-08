
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int ans=0;
		Set<String> set = new HashSet<>();
		for(int i=0;i<N;i++) {
			set.add(br.readLine().trim());
		}
		for(int i=0;i<M;i++) {
			if(set.contains(br.readLine().trim()))ans++;
		}
		System.out.println(ans);
		

	

	}

}
