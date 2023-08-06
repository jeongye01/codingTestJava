import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static List<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			list = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int num=Integer.parseInt(st.nextToken());
			int offset=num/15*15-15;
			list.add(num-offset);
			for (int i = 1; i < 8; i++) {
				list.add(Integer.parseInt(st.nextToken())-offset);
			}
			
			int dec = 1;
			while (true) {
				int tmp = list.get(0);
				tmp -= dec;
				list.remove(0);
				if (tmp <= 0) {
					list.add(0);
					break;
				}
				list.add(tmp);
				dec = dec == 5 ? 1 : (dec + 1);
			}
			System.out.print("#" + tc + " ");
			for (int i = 0; i < 8; i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();

		}

	}

}