import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stk = new Stack<>();
		char[] chs = br.readLine().trim().toCharArray();
		boolean isTagOpen = false;
		for (char c : chs) {
			if (c == '<') {
				isTagOpen = true;

				while (!stk.isEmpty()) {
					sb.append(stk.pop());
				}
				sb.append(c);
			} else if (isTagOpen) {

				if (c == '>') {

					isTagOpen = false;

				}
				sb.append(c);
			} else if (c == ' ') {

				while (!stk.isEmpty()) {
					sb.append(stk.pop());
				}
				sb.append(c);
			} else {
				stk.add(c);

			}

		}
		while (!stk.isEmpty()) {
			sb.append(stk.pop());
		}
		System.out.println(sb);

	}

}