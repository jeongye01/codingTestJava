import java.io.*;
import java.util.*;

public class Main {
    static class Number implements Comparable<Number>{
    	int value;
    	int idx;
    	public Number(int value,int idx) {
    		this.value = value;
    		this.idx =idx;
    	}
    	
    	@Override
    	public int compareTo(Number o) {
    		return this.value-o.value;
    	}
    }
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[N];
         List<Number> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for(int i=0;i<N;i++) {
        	int n = Integer.parseInt(st.nextToken());
        	list.add(new Number(n,i));
        	
        }
        Collections.sort(list);
        int idx=-1;
        int prev=Integer.MAX_VALUE;
        for(Number n : list) {
        	if(n.value!=prev) {
        		idx++;
        		prev=n.value;
        	}
        	arr[n.idx]=idx;
        	
        	
        	
        }
        for(int i=0;i<N;i++) {
        	sb.append(arr[i]).append(' ');
        }
		System.out.println(sb);
	}

}