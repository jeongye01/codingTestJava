import java.io.*;
import java.util.*;

public class Main {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for(int t=0;t<T;t++) {
			int ans=1;
			int N = Integer.parseInt(br.readLine().trim());
			Map<String,Integer> map = new HashMap<>();
			
			for(int i=0;i<N;i++) {
				 st = new StringTokenizer(br.readLine().trim());
				 st.nextToken();
				String str=st.nextToken();
				Integer cnt=map.get(str);
				if(cnt!=null) {
					map.replace(str, cnt+1);
				}else {
					map.put(str,1);
				}
			}
			Iterator<String> keys = map.keySet().iterator();
			while(keys.hasNext()) {
				String key=keys.next();
				Integer value = map.get(key) +1;
				ans*=value;
			}
	        ans-=1;
			sb.append(ans).append('\n');
		}
	    
	    
		System.out.println(sb);
		
		
	}

}