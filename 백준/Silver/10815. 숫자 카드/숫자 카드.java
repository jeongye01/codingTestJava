import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;
class Main{	
public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Set<Integer> set = new HashSet<>();
		int N = Integer.parseInt(br.readLine().trim());
		st = new StringTokenizer(br.readLine().trim());
		for(int i=0;i<N;i++){
			set.add(Integer.parseInt(st.nextToken()));
		}
		int M = Integer.parseInt(br.readLine().trim());
		st = new StringTokenizer(br.readLine().trim());
		for(int i=0;i<M;i++){
			if(set.contains(Integer.parseInt(st.nextToken()))){
			  sb.append(1);
			}else{
				sb.append(0);
			}
			sb.append(" ");
		}
		System.out.println(sb);


	}
}
