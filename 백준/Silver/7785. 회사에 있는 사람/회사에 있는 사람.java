import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	    Set<String> set = new HashSet<>();
	    StringBuilder sb=new StringBuilder();
	    int N = Integer.parseInt(br.readLine().trim());
	    for(int i=0;i<N;i++) {
		   st = new StringTokenizer(br.readLine().trim());
		   String name = st.nextToken();
		   String state = st.nextToken();
		   if(state.equals("enter")) {
			   set.add(name);
		   }else {
			   set.remove(name);
		   }
			   
	    }
	    List<String> list = new ArrayList<>(set);
	    Collections.sort(list);
	    Collections.reverse(list);
	    for(String name:list) {
	    	sb.append(name).append('\n');
	    }
	    System.out.println(sb);
	}

}