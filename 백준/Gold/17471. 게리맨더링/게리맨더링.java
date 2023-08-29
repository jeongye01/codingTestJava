
import java.util.*;
import java.io.*;

public class Main {

	static int N, aSum, bSum, ans;
	static int selected[], arr[][];
	static int towns[], visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine().trim());
		towns = new int[N];
		visited = new int[N];
		selected = new int[N];
		arr = new int[N][N];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			towns[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int len = Integer.parseInt(st.nextToken());
			for (int j = 0; j < len; j++) {
				int tmp = Integer.parseInt(st.nextToken()) - 1;
				arr[i][tmp] = 1;
				arr[tmp][i] = 1;

			}
		}
		ans = Integer.MAX_VALUE;
		// System.out.println(canGo(0, 3));
		for (int i = 1; i <= N / 2; i++) {
			pick(0, 0, i);
			if (ans == 0) {
				break;
			}
		}
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

	}

	private static boolean canGo(int st, int ed) {
		if (arr[st][ed] == 1) {
			//System.out.println(st+" "+ed);
			return true;
		}
		for (int c = 0; c < N; c++) {
			if (c == st || visited[c] == 1 || (selected[st] != selected[c]) || arr[st][c]==0) {
				continue;
			}
			visited[c]=1;
			if (canGo(c, ed)) {
				return true;
			}

		}
		return false;
	}

	private static boolean isAble() {
		aSum = 0;
		bSum = 0;
		List<Integer> a = new ArrayList<>();
		List<Integer> b = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			if (selected[i] == 0) {
				aSum += towns[i];
				a.add(i);
			} else {
				bSum += towns[i];
				b.add(i);
			}
		}
		for (int i = 0; i < a.size() - 1; i++) {
			for (int j = i + 1; j < a.size(); j++) {
				Arrays.fill(visited, 0);
			
				if (!(canGo(a.get(i), a.get(j)))) {
					return false;
				}
			}

		}
		for (int i = 0; i < b.size() - 1; i++) {
			for (int j = i + 1; j < b.size(); j++) {
				Arrays.fill(visited, 0);
			
				if (!(canGo(b.get(i), b.get(j)))) {
					return false;
				}
			}

		}
		return true;

	}

	private static void pick(int idx, int cnt, int toPickCnt) {
		if (cnt == toPickCnt) {
			if (isAble()) {
				Arrays.fill(visited, 0);
				
			   
				ans = Math.min(ans, Math.abs(aSum - bSum));
			}
			return;
		}
		for (int i = idx; i < N; i++) {
			if (selected[i] == 0) {
				selected[i] = 1;
				pick(i + 1, cnt + 1, toPickCnt);
				selected[i] = 0;

			}
		}

	}

}
/*


6
2 2 2 2 2 2
1 3
1 4
1 1
1 2
1 6
1 5

*/