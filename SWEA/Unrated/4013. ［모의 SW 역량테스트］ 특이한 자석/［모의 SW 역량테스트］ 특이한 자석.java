import java.util.*;
import java.io.*;

public class Solution {
	static int K, ans;
	static List<Deque<Integer>> magnets = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {

			K = Integer.parseInt(br.readLine().trim());
			for (int i = 0; i < 4; i++) {
				magnets.add(new ArrayDeque<>());
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < 8; j++) {
					magnets.get(i).addLast(Integer.parseInt(st.nextToken()));
				}

			}

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int number = Integer.parseInt(st.nextToken()) - 1;
				int direction = Integer.parseInt(st.nextToken());
				spinMagnet(number, direction, true, true);

			}
			ans = 0;
			for (int i = 0; i < 4; i++) {
				if (magnets.get(i).pollFirst() == 1) {
					ans += Math.pow(2, i);
				}
			}
			magnets.clear();
			sb.append("#").append(tc).append(" ").append(ans).append("\n");

		}
		System.out.println(sb);

	}

	private static void spinMagnet(int number, int direction, boolean left, boolean right) {
		int leftMagnet = number - 1;
		boolean leftCheck = false;
		if (left && leftMagnet >= 0) {
			if (magnets.get(leftMagnet).toString().charAt(7) + magnets.get(number).toString().charAt(19) - '0'
					- '0' == 1) {
				leftCheck = true;

			}
		}
		int rightMagnet = number + 1;
		boolean rightCheck = false;
		if (right && rightMagnet < 4) {
			if (magnets.get(rightMagnet).toString().charAt(19) + magnets.get(number).toString().charAt(7) - '0'

					- '0' == 1) {
				rightCheck = true;

			}
		}
		if (direction == 1) {// 시계방향
			int tmp = magnets.get(number).pollLast();
			magnets.get(number).addFirst(tmp);

		} else {// 반시계방
			int tmp = magnets.get(number).pollFirst();
			magnets.get(number).addLast(tmp);
		}
		// 왼쪽 돌리기
		if (left && leftCheck) {
			spinMagnet(leftMagnet, direction * -1, true, false);
		}

		// 오른쪽 돌리기기
		if (right && rightCheck) {
			spinMagnet(rightMagnet, direction * -1, false, true);
		}

	}

}