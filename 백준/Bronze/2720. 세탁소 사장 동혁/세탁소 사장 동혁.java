import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine().trim());
			
			sb.append(N/25).append(" ");
			N%=25;
			sb.append(N/10).append(" ");
			N%=10;
			sb.append(N/5).append(" ");
			N%=5;
			sb.append(N).append("\n");
		}
		System.out.println(sb);

	}
}
