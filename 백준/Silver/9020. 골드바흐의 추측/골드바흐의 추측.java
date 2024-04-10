import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine().trim());
			int prime = 0;
			int min = Integer.MAX_VALUE;
			for (int i = 2; i <= N; i++) {
				boolean isprime = true;
				for (int j = 2; j <= Math.sqrt(i); j++) {
					if (i % j == 0) {
						isprime = false;
						break;
					}
				}
				if (isprime) {

					if (N - i >= i) {
						boolean isprime2 = true;
						for (int j = 2; j <= Math.sqrt(N - i); j++) {
							if ((N - i) % j == 0) {
							
								isprime2 = false;
								break;
							}
						}
						if (isprime2) {
							prime = i;
							
						}

//						if (isprime2 && Math.abs(i - (N - i)) < min) {
//							min = Math.abs(i - (N - i));
//							prime = i;
//						}
					}

				}
			}
			sb.append(prime).append(' ').append(N - prime).append('\n');
		}
		System.out.println(sb);
	}

}
