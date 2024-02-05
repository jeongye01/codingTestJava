import java.io.*;
import java.util.*;

public class Main {
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	    StringBuilder sb = new StringBuilder();
	    int N = Integer.parseInt(br.readLine().trim());
	    Stack<Integer> stk = new Stack<>();
		
	    for(int i=0;i<N;i++) {
	    	int m = Integer.parseInt(br.readLine().trim());
	    	if(m==0) {
	    		stk.pop();
	    	}else {
	    		stk.push(m);
	    	}
	    }
	    int sum=0;
	    while(!stk.isEmpty()) {
	    	sum+=stk.pop();
	    }
		System.out.println(sum);

	}

}
