
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
	    
		for (int tc = 1; tc <= T; tc++) {
			boolean check=true;
			String brace = br.readLine().trim();
			int cnt = 0;
			for (int i = 0; i < brace.length(); i++) {
				char b = brace.charAt(i);
				if (b == '(') {
					cnt++;
				} else {
					if (cnt == 0) {
						check=false;
	                    break;
					}
					cnt--;
				}
				
			}
			if(check && cnt==0) {
				sb.append("YES").append('\n');
			}else {
				sb.append("NO").append('\n');
			}
		
			
			
		}
		System.out.println(sb);

	}

}