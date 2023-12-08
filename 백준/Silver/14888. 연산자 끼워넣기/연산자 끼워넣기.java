import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

	static int N;
	static long min, max;
	static List<Character> operator;
	static int[] selected;
	static boolean[] visited;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine().trim());
		int plus = Integer.parseInt(st.nextToken());
		int minus = Integer.parseInt(st.nextToken());
		int mul = Integer.parseInt(st.nextToken());
		int div = Integer.parseInt(st.nextToken());
		operator = new ArrayList<>();
		for (int i = 0; i < plus; i++) {
			operator.add('+');
		}
		for (int i = 0; i < minus; i++) {
			operator.add('-');
		}
		for (int i = 0; i < mul; i++) {
			operator.add('*');
		}
		for (int i = 0; i < div; i++) {
			operator.add('/');
		}
		visited = new boolean[operator.size()];
		selected = new int[N- 1];
		min = Long.MAX_VALUE;
		max = Long.MIN_VALUE;
		insert(0);

		System.out.println(max);
		System.out.println(min);

	}

	public static void insert(int cnt) {
		if (cnt == N - 1) {
			int value = arr[0];
			for (int i = 0; i < N - 1; i++) {

				char o = operator.get(selected[i]);
				if (o == '+') {
					value += arr[i + 1];
				} else if (o == '-') {
					value -= arr[i + 1];
				} else if (o == '*') {
					value *= arr[i + 1];
				} else {
					value /= arr[i + 1];
				}

			}
			//System.out.println(value + " "+Arrays.toString(selected)+" "+N);
			min = Math.min(value, min);
			max = Math.max(value, max);

		}
		for (int i = 0; i < operator.size(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				selected[cnt] = i;
				insert(cnt + 1);
				visited[i] = false;

			}

		}
	}

}
