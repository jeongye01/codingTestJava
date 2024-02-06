import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Stack<Character> stk = new Stack<>();

		while (true) {
			String words = br.readLine();
			if (words.equals(".")) {
				System.out.println(sb);
				break;
			}
			boolean check = true;

			for (int i = 0; i < words.length(); i++) {

				char c = words.charAt(i);
				if (c == '(') {
					stk.add('(');
				} else if (c == '[') {
					stk.add('[');
				} else if (c == ')') {
					if (stk.isEmpty() || stk.peek() == '[') {

						check = false;
						break;
					}

					stk.pop();

				} else if (c == ']') {
					if (stk.isEmpty() || stk.peek() == '(') {

						check = false;
						break;
					}

					stk.pop();

				}
			}
			if (!stk.isEmpty())
				check = false;
			sb.append(check ? "yes" : "no").append('\n');
			stk.clear();

		}

	}

}