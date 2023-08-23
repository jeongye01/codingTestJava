
import java.io.*;
import java.util.*;

import java.util.*;
import java.io.*;

public class Main {
	static int N, ans;
	static int arr[][], selected[], perm[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ans=0;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][9];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		selected = new int[9];
		perm = new int[9];
		perm[3] = 0; // 1번 선수는 무조건 4번 타자
		bt(0);
		System.out.println(ans);

	}

	public static void bt(int cnt) {
		//System.out.println(cnt);
		if (cnt == 9) {
			//System.out.println(Arrays.toString(perm));
			int player = 0;
			int tmp = 0;
			
			for (int i = 0; i < N; i++) {
				Deque<Integer> q = new ArrayDeque<>(); // 경기장 상황
				int out = 0;
				while(out<3) {
					int res = arr[i][perm[player]];
					if (res == 0) {// out
						out += 1;
					} else if (res == 1) { // 안타
						q.add(1);
						if (q.size() == 4) {
							tmp += q.poll();
						}
					} else if (res == 2) { // 2루타
						q.add(1);
						if (q.size() == 4) {
							tmp += q.poll();
						}
						q.add(0);
						if (q.size() == 4) {
							tmp += q.poll();
						}

					} else if (res == 3) { // 3루타
						q.add(1);
						if (q.size() == 4) {
							tmp += q.poll();
						}
						q.add(0);
						if (q.size() == 4) {
							tmp += q.poll();
						}
						q.add(0);
						if (q.size() == 4) {
							tmp += q.poll();
						}

					} else { // 홈런
						q.add(1);
						while (!q.isEmpty()) {
							tmp += q.poll();
						}

					}

					player = (player + 1) % 9; // 선수 업데이트
				}
				

			}
			ans = Math.max(tmp, ans);
		}
		if (cnt == 3) {
			bt(cnt + 1);
			return;
		}
		for (int i = 1; i < 9; i++) {
			if (selected[i] != 1) {
				selected[i] = 1;
				perm[cnt] = i;
                bt(cnt+1);
				selected[i] = 0;
			}
		}
	}

}

/*
 * 
 * 
 * 3 7 .14.... .M.Z... ..23...
 * 
 * 
 */