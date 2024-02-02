import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr1 = new int[N];
		int[] arr2 = new int[M];

		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < M; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		int p1 = 0;
		int p2 = 0;
		for (int i = 0; i < N + M; i++) {
			if (p1 >= N) {
				sb.append(arr2[p2]).append(' ');
				p2++;
				continue;
			} else if (p2 >= M) {
				sb.append(arr1[p1]).append(' ');
				p1++;
				continue;
			}
			if (arr1[p1] < arr2[p2]) {
				sb.append(arr1[p1]).append(' ');
				p1++;
			} else {
				sb.append(arr2[p2]).append(' ');
				p2++;
			}
			

		}

		System.out.println(sb);

	}

}