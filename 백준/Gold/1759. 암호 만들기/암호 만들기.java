import java.util.*;
import java.io.*;

public class Main {
	static int L, C;
	static int picked[], selected[];
	static char chars[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		picked = new int[L];
		selected = new int[C];
		chars = new char[C];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < C; i++) {
			chars[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(chars);
		pick(0, 0);
		System.out.println(sb);
	}

	public static void pick(int idx, int cnt) {
		if (cnt == L) {
			boolean check = false;
			int aCnt = 0;
			int bCnt = 0;
			StringBuilder tmp = new StringBuilder();
			for (int i = 0; i < L; i++) {
				char c = chars[picked[i]];
				if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
					aCnt++;

				} else {
					bCnt++;

				}
				if (aCnt >= 1 && bCnt >= 2) {
					check = true;
				}
				tmp.append(c);
			}

			if (check) {
				sb.append(tmp.toString()).append("\n");
			}
			return;
		}
		for (int i = idx; i < C; i++) {
			if (selected[i] == 0) {
				selected[i] = 1;
				picked[cnt] = i;
				pick(i + 1, cnt + 1);
				selected[i] = 0;
			}
		}
	}

}