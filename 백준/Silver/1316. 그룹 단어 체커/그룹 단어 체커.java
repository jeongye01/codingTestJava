import java.io.*;
import java.util.*;

public class Main {
	static boolean board[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int ans = 0;

		for (int i = 0; i < N; i++) {
			if (check(br.readLine().trim())) {
				ans++;
			}
		}

		System.out.println(ans);
	}

	public static boolean check(String s) {
		boolean[] alpas = new boolean[26];
		alpas[s.charAt(0) - 'a'] = true;
		for (int i = 1; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!alpas[c - 'a']) {
				alpas[c - 'a'] = true;
			}
			else if (alpas[c - 'a'] && s.charAt(i-1) != c) {
				return false;
			}
		}

		return true;
	}

}