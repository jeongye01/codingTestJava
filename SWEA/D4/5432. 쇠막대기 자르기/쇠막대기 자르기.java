import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int res = 0, cnt = 0;
			String s = br.readLine();
			for(int i = 0; i < s.length() - 1; i++) {
				if(s.charAt(i) == '(' && s.charAt(i + 1) == ')') { 
					res += cnt;
					i++;
				}
				else if(s.charAt(i) == '(') cnt++; 
				else { cnt--; res++; } 
			}
			System.out.println("#" + t + " " + ++res);
		}
	}
}