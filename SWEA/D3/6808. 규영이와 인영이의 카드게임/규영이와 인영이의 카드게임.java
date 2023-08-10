import java.io.*;
import java.util.*;

public class Solution {
	static List<Integer> cards0;
	static int cards[];

	static List<int[]> perm;

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
		swap(cards, i - 1, j);
		int k = N - 1;
		while (i < k) {
			swap(cards, i++, k--);
		}
		return true;
	}

	private static void swap(int[] p, int a, int b) {
		int temp = p[b];
		p[b] = p[a];
		p[a] = temp;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			cards0 = new ArrayList<>();
			cards = new int[9];
			perm = new ArrayList<>();
			for (int i = 0; i < 9; i++) {
				cards0.add(Integer.parseInt(st.nextToken()));
			}
			int k = 0;
			for (int i = 1; i <= 18; i++) {
				if (!cards0.contains(i)) {
					cards[k++] = i;
				}

			}

			Arrays.sort(cards);
			do {
				perm.add(cards.clone());
			} while (np());
			

			int win = 0, lose = 0;
			for (int i = 0; i < perm.size(); i++) {
				int user1 = 0, user2 = 0;
				for (int j = 0; j < 9; j++) {
					if (cards0.get(j) > perm.get(i)[j]) {
						user1 += (cards0.get(j) + perm.get(i)[j]);
					}
					if (cards0.get(j) < perm.get(i)[j]) {
						user2 += (cards0.get(j) + perm.get(i)[j]);
					}

				}
				if (user1 > user2) {
					win += 1;
				}
				if (user1 < user2) {
					lose += 1;
				}

			}
			System.out.println("#" + tc + " " + win + " " + lose);

		}

	}

}
