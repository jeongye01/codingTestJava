import java.io.*;
import java.util.*;

public class Solution {
	static int cards0[],cards[],gyus[];

	private static boolean np() {
		int N = 9;
		int i = N - 1;
		while (i > 0 && cards[i - 1] >= cards[i])
			--i;
		if (i == 0)
			return false;
		int j = N - 1;
		while (cards[i - 1] >= cards[j])
			--j;
		swap(i - 1, j);
		int k = N - 1;
		while (i < k) {
			swap( i++, k--);
		}
		return true;
	}

	private static void swap(int a, int b) {
		int temp = cards[b];
		cards[b] = cards[a];
		cards[a] = temp;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			cards0 = new int[9];
			cards = new int[9];
			gyus=new int[19];
			for (int i = 0; i < 9; i++) {
				cards0[i]=Integer.parseInt(st.nextToken());
				gyus[cards0[i]]=1;
			}
			int k = 0;
			for (int i = 1; i <= 18; i++) {
				if (gyus[i]==0) {
					cards[k++] = i;
				}

			}

			Arrays.sort(cards);
			int win = 0, lose = 0;
			do {

				int user1 = 0, user2 = 0;
				for (int j = 0; j < 9; j++) {
					if (cards0[j] > cards[j]) {
						user1 += (cards0[j] + cards[j]);
					}
					if (cards0[j] < cards[j]) {
						user2 += (cards0[j] + cards[j]);
					}

				}
				if (user1 > user2) {
					win += 1;
				}
				if (user1 < user2) {
					lose += 1;
				}

			} while (np());

			sb.append("#").append(tc).append(" ").append(win).append(" ").append(lose).append("\n");

		}
		System.out.println(sb);

	}

}