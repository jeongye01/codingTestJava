

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		while (true) {
			String password = br.readLine().trim();

			if ("end".equals(password))
				break;
			boolean check = true;
			
			int moum = 0;
			char prev = ' ';
			int macc = 0;
			int jacc = 0;
			for (int i = 0; i < password.length(); i++) {
				char c = password.charAt(i);
				if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
					moum++;
					macc++;
					jacc = 0;
				} else {
					jacc++;
					macc = 0;
				}
				if (c == prev && c != 'e' && c != 'o') {
					check = false;
					break;
				}
				if (macc >= 3 || jacc >= 3) {
					check = false;
					break;
				}
				prev = c;

			}
			if (moum == 0)
				check = false;

			sb.append('<').append(password).append("> ").append(check ? "is acceptable." : "is not acceptable.")
					.append('\n');

		}

		System.out.println(sb);

	}

}
