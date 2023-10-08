import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			String command = br.readLine().trim();
			int N = Integer.parseInt(br.readLine().trim());
			Deque<Integer> arr = new ArrayDeque<>();
			String nums = br.readLine().trim();
			nums = nums.substring(1, nums.length() - 1);
			String[] tmp = nums.split(",");
			for (int i = 0; i < N; i++) {
				arr.add(Integer.parseInt(tmp[i]));
			}
			boolean error = false;
			boolean reversed = false;
			for (int c = 0; c < command.length(); c++) {
				if (command.charAt(c) == 'R') {
					reversed = !reversed;
				} else {
					if (arr.isEmpty()) {
						error = true;

						break;

					}
					if (reversed) {
						arr.pollLast();
					} else {
						arr.pollFirst();
					}

				}

			}
			if (error) {
				sb.append("error").append("\n");
			} else if (!reversed) {

				sb.append("[");
				while (!arr.isEmpty()) {
					sb.append(arr.pollFirst());
					if (!arr.isEmpty()) {
						sb.append(",");
					}
				}
				sb.append("]").append("\n");

			} else {
				sb.append("[");
				while (!arr.isEmpty()) {
					sb.append(arr.pollLast());
					if (!arr.isEmpty()) {
						sb.append(",");
					}
				}
				sb.append("]").append("\n");
			}

		}
		System.out.println(sb);

	}

}