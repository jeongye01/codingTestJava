

import java.util.*;
import java.io.*;

public class Solution {
	static int N = 10, M, A, ans;
	static int arra[], arrb[], ap[][], board[][];
	static int[] dx = { 0, 0, 1, 0, -1 };
	static int[] dy = { 0, -1, 0, 1, 0 };
	static int ax, ay, bx, by;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
            ans=0;
			arra = new int[M+1];
			arrb = new int[M+1];
			ap = new int[A][4];
			board = new int[10][10];
			ax = ay = 0;
			bx = by = 9;
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < M; i++) {
				arra[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < M; i++) {
				arrb[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine().trim());
				ap[i][0] = Integer.parseInt(st.nextToken()) - 1;
				ap[i][1] = Integer.parseInt(st.nextToken()) - 1;
				for (int j = 2; j < 4; j++) {
					ap[i][j] = Integer.parseInt(st.nextToken());
				}

			}
			for (int t = 0; t <= M; t++) {
				cal(t);
			}

			sb.append("#").append(tc).append(" ").append(ans).append("\n");

		}
		System.out.println(sb);

	}

	public static void cal(int t) {

		PriorityQueue<Charger> aq = new PriorityQueue<>();
		PriorityQueue<Charger> bq = new PriorityQueue<>();
		int max = 0;
		for (int i = 0; i < A; i++) {
			int cx = ap[i][0];
			int cy = ap[i][1];
			int c = ap[i][2];
			int p = ap[i][3];
			int ad = Math.abs(cx - ax) + Math.abs(cy - ay);
			int bd = Math.abs(cx - bx) + Math.abs(cy - by);
			if (ad <= c) {
				aq.offer(new Charger(p, i));
			}
			if (bd <= c) {
				bq.offer(new Charger(p, i));
			}

		}
        boolean aEmpty=aq.isEmpty();
        boolean bEmpty=bq.isEmpty();
		if (!aEmpty && bEmpty) {
			max = aq.poll().c;
		} else if (aEmpty && !bEmpty) {
			max = bq.poll().c;
		} else if (!aEmpty && !bEmpty) {

			Charger a = aq.poll();
			Charger b = bq.poll();
			if (a.n == b.n) {
				int sum = (a.c + b.c) / 2;
				max = sum;
				if (!aq.isEmpty()) {
					a = aq.poll();
					max = Math.max(max, sum + a.c);
				}
				if (!bq.isEmpty()) {
					b = bq.poll();
					max = Math.max(max, sum + b.c);
				}
			} else {
				max = a.c + b.c;

			}

		}

		ans += max;
		// System.out.println(max + " " + t);
		ax += dx[arra[t]];
		ay += dy[arra[t]];
		bx += dx[arrb[t]];
		by += dy[arrb[t]];
	}

	public static class Charger implements Comparable<Charger> {
		int c;
		int n;

		public Charger(int c, int n) {
			this.c = c;
			this.n = n;
		}

		public int compareTo(Charger o) {
			if (o.c > this.c) {
				return 1;
			} else if (o.c < this.c) {
				return -1;
			}
			return 0;
		}
	}

}