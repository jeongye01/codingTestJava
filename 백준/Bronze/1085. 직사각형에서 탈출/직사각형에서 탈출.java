

import java.util.*;
import java.io.*;

public class Main {
	static int[][] board = new int[9][9];
	static List<int[]> blank;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int min = Math.min(x, w - x);
		min = Math.min(y, min);
		min = Math.min(h - y, min);
		System.out.println(min);
	}

}