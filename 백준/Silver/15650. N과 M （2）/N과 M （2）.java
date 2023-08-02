import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	static int picked[];
	static int numbers[];
	static int N;
	static int M;
    private static void permutaion(int cnt) {
    	if(cnt==M ) {
    	  for(int i=0;i<M;i++) {
    		  System.out.print(picked[i]+" ");
    	  }
    	  System.out.println();
    	  return;
    	}
    	int st=cnt!=0?picked[cnt-1]+1:1;
    	for(int i=st;i<=N;i++) {
    		if(numbers[i]==1 ) {
    			continue;
    		}
    		numbers[i]=1;
    		picked[cnt]=i;
    		permutaion(cnt+1);
    		numbers[i]=0;
    	}
    }
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] sin=in.readLine().split(" ");
		N=Integer.parseInt(sin[0]);
		M=Integer.parseInt(sin[1]);
		numbers=new int[N+1];
		picked=new int[M];
		permutaion(0);
		
		

	}

}