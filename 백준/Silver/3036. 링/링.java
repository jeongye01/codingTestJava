import java.io.*;
import java.util.*;

public class Main {
	public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    int N = Integer.parseInt(br.readLine().trim());
	    StringTokenizer st = new StringTokenizer(br.readLine().trim());
	    int f = Integer.parseInt(st.nextToken());
	    for(int i=1;i<N;i++) {
	    	int a=f;
	    	int b= Integer.parseInt(st.nextToken());
	    	 int gcd = gcd(a,b); 
	    	 a /= gcd ;
	        b /= gcd ;
	    	sb.append(a).append('/').append(b).append('\n');
	    }
	   System.out.println(sb);
	   
	}

}
