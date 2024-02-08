import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
        Set<Integer> set = new HashSet<>();
		int ans = 0;
		st = new StringTokenizer(br.readLine().trim());
		for(int i=0;i<N;i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine().trim());
		for(int i=0;i<M;i++) {
			Integer n = Integer.parseInt(st.nextToken());
			if(set.contains(n)) {
				set.remove(n);
			}else {
				set.add(n);
			}
			
			
		}
		
		System.out.println(set.size());

	}

}