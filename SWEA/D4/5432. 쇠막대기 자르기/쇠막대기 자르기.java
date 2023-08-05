import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int ans = 1, cnt = 0;
			String s = br.readLine();
			for(int i = 0; i < s.length() - 1; i++) {
				if(s.charAt(i) == '(' && s.charAt(i + 1) == ')') { 
					ans += cnt;
					i++;
				}
				else if(s.charAt(i) == '(') cnt++; 
				else { cnt--; ans++; } 
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}