import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			int x1, y1, r1, x2, y2, r2;
			st = new StringTokenizer(br.readLine().trim());

			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			r1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			r2 = Integer.parseInt(st.nextToken());

			double dis = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
			if (x1 == x2 && y1 == y2 && r1 == r2) { // 원이 겹치는 경우
				sb.append(-1).append("\n");
			} else if ((r1 + r2 == dis) || Math.abs(r1 - r2) == dis) { // 점점이 1개
				sb.append(1).append("\n");
			} else if ((x1 == x2 && y1 == y2 && r1 != r2) || Math.abs(r1 - r2) > dis || (r1 + r2) < dis) { // 접점이 없음
				sb.append(0).append("\n");
			} else { // 접점이 2개
				sb.append(2).append("\n");
			}

		}

		System.out.println(sb);
	}

}