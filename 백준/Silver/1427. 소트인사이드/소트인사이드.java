
import java.io.*;
import java.util.*;
// 6분 
public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine().trim());
		List<Integer> nums = new ArrayList<>();
		while(N>0) {
			nums.add(N%10);
			N/=10;
		}
		Collections.sort(nums);
		Collections.reverse(nums);
		for(Integer n:nums) {
			sb.append(n);
		}
		System.out.println(sb);
	

	}

}
