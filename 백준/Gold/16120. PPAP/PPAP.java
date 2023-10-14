import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine().trim());
		String s = br.readLine().trim();
		Stack<Character> stack = new Stack<>();

		boolean check = true;
		for (int i = 0; i < s.length(); i++) {
			// System.out.println(stack.toString());
			if (s.charAt(i) == 'P') {
				stack.add('P');
			} else if (s.charAt(i) == 'A'  ) {
				if (i + 1 < s.length() && s.charAt(i + 1) == 'P' && stack.size() >= 2) {
					stack.pop();
					stack.pop();

				} else {
					check = false;
					break;
				}
			} 
		}
		// System.out.println(stack.toString());
		if (check && stack.size() == 1) {
			System.out.println("PPAP");
		} else {
			System.out.println("NP");
		}

	}

}