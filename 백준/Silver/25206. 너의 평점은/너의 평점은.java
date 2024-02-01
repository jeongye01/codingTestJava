import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	    Map<String,Double> map = new HashMap<>();
	    map.put("A+", 4.5);
	    map.put("A0", 4.0);
	    map.put("B+", 3.5);
	    map.put("B0", 3.0);
	    map.put("C+", 2.5);
	    map.put("C0", 2.0);
	    map.put("D+", 1.5);
	    map.put("D0", 1.0);
	    map.put("F", 0.0);
		int cnt=0;
		double sum = 0;
		for(int i=0;i<20;i++) {
			st = new StringTokenizer(br.readLine().trim());
			st.nextToken();
			double star = Double.parseDouble(st.nextToken());
			String subject = st.nextToken();
			if(subject.equals("P")) {
				continue;
			}
			sum += star*map.get(subject);
			cnt+=star;
		}
		System.out.println(sum/cnt);
	}

}
