import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			int ans=1;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N; i++) {
				String[] ch = br.readLine().split(" ");
				String s=ch[1];
				if (ch.length == 4) {
					if (!s.equals("+") && !s.equals("-") && !s.equals("/") &&!s.equals("*")) {
						ans=0;
					}
				}
				if (ch.length == 2) {
					if (s.equals("+") || s.equals("-") || s.equals("/") ||s.equals("*")) {
						ans=0;
					}
				}
			}
			System.out.println("#" + tc + " " + ans);

		}

	}

}
