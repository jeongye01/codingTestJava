
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int ans = 1;
	static int N, P;
	static List<Long> list;
	static long T;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		T = Long.parseLong(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		if (N == 0) {
			System.out.println(1);
			return;
		}
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			list.add(Long.parseLong(st.nextToken()));
		}
		Collections.sort(list);
		Collections.reverse(list);
		if (N == P && T <= list.get(list.size() - 1)) {
			System.out.print(-1);
			return;
		}
		

		for (Long n : list) {
			if (n > T) {
				ans++;
			} else  {

				
				break;
			}

		}

		System.out.println( ans);
	}

}
