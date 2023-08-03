

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	static List<Integer> primes=new ArrayList<>();
    static int N;
	private static void findPrime(int idx,int prime) {
       if(idx==N) {
    	   System.out.println(prime);
    	   return;
       }
       for(int i=idx>0?1:2;i<=9;i++) {
    	   boolean isPrime=false;
    	   int newPrime=prime*10+i;
    	   for(int j=2;j<=(int)Math.sqrt(newPrime);j++) {
    		   if((newPrime)%j==0) {
    			  isPrime=true;
    			  break;
    		   }
    	   }
    	   if(!isPrime)findPrime(idx+1,newPrime);
       }
       
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		findPrime(0,0);
	}

}
