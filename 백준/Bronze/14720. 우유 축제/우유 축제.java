import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int cnt = 0;
		int flag = 0;
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			if (n == flag) {
				cnt++;

				flag = (flag + 1) % 3;
			} 
			

		}
		System.out.println(cnt);

	}
}