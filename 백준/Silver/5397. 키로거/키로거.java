import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {

			Deque<Character> left = new LinkedList<>();
			Deque<Character> right = new LinkedList<>();

			char[] chs = br.readLine().trim().toCharArray();
			for (char c : chs) {
				if (c == '<') {
					if (!left.isEmpty()) {
						right.addFirst(left.pollLast());
					}
				} else if (c == '>') {
					if (!right.isEmpty()) {
						left.addLast(right.pollFirst());
					}
				} else if (c == '-') {
					if (!left.isEmpty()) {
						left.pollLast();
					}
				} else {
					left.addLast(c);
				}
			}
			while (!left.isEmpty()) {
				sb.append(left.pollFirst());
			}
			while (!right.isEmpty()) {
				sb.append(right.pollFirst());
			}
			sb.append('\n');

		}
		System.out.println(sb);
	}

}
