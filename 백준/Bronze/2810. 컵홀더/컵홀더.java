import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int ans=1;
		String s=br.readLine().trim();
		for(int i=0;i<N;i++) {
			char c=s.charAt(i);
			if(c=='L') {
				i++;
			   
			}
			ans++;
		}
		System.out.println(ans>N?N:ans);

	}
}
