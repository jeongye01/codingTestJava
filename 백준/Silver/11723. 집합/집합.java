
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		M = Integer.parseInt(st.nextToken());
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			String inst = st.nextToken();
		
			if ("add".equals(inst)) {
				int num = Integer.parseInt(st.nextToken());
				set.add(num);
			} else if ("remove".equals(inst)) {
				int num = Integer.parseInt(st.nextToken());
				set.remove(num);
			} else if ("check".equals(inst)) {
				int num = Integer.parseInt(st.nextToken());
				if (set.contains(num)) {
					sb.append(1).append('\n');

				} else {
					sb.append(0).append('\n');
				}
			} else if ("toggle".equals(inst)) {
				int num = Integer.parseInt(st.nextToken());
				if (set.contains(num)) {
					set.remove(num);

				} else {
					set.add(num);
				}

			} else if ("all".equals(inst)) {
				set.clear();
				for (int j = 1; j <= 20; j++) {
					set.add(j);
				}
			} else { // empty
				set.clear();
			}

		}
		System.out.println(sb);

	}

}