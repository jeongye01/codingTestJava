

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, r, c, cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
        
		cnt -= 1;
		int size = (int) Math.pow(2, N);
		visit(0, size - 1, 0, size - 1, size);

	}

	public static void visit(int rs, int re, int cs, int ce, int size) {
		if (rs >= re || cs >= ce) {
			cnt += 1;
			if (rs == r && cs == c) {
				System.out.print(cnt);

			}

			return;
		}

		if (rs <= r && r < rs + size / 2 && cs <= c && c < cs + size / 2) {// 1사분면
			visit(rs, rs + size / 2 - 1, cs, cs + size / 2 - 1, size / 2);
		} else if (rs <= r && r < rs + size / 2 && cs + size / 2 <= c && c <= ce) {// 2사분면

			cnt += Math.pow(size / 2, 2);
			visit(rs, rs + size / 2 - 1, cs + size / 2, ce, size / 2);
		} else if (rs + size / 2 <= r && r <= re && cs <= c && c < cs+size / 2) {// 3사분면

			cnt += Math.pow(size / 2, 2) * 2;
			visit(rs + size / 2, re, cs, cs + size / 2 - 1, size / 2);
		} else {// 4사분면

			cnt += Math.pow(size / 2, 2) * 3;
			visit(rs + size / 2, re, cs + size / 2, ce, size / 2);
		}

	}

}
