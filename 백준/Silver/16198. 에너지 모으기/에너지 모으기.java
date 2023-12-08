
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//을 수 있는 에너지의 최댓값
public class Main {

	static int N;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		energy(arr, 0);

		System.out.println(ans);

	}

	public static void energy(int[] arr, int power) {
		//System.out.println(Arrays.toString(arr));
		if (arr.length == 2) {
			//System.out.println(power);
			ans = Math.max(ans, power);
			return;
		}

		for (int i = 1; i < arr.length - 1; i++) {
			int[] newArr = new int[arr.length - 1];
			int idx = 0;
			for (int j = 0; j < arr.length; j++) {

				if (i != j) {
					newArr[idx++] = arr[j];

				}
			}
			//System.out.println(Arrays.toString(newArr) + " new");
			energy(newArr, power + arr[i - 1] * arr[i + 1]);

		}
	}

}