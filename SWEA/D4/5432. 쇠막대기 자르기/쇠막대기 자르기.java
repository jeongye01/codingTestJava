import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int res = 0, cnt = 0;
			String s = sc.next();
			for(int i = 0; i < s.length() - 1; i++) {
				if(s.charAt(i) == '(' && s.charAt(i + 1) == ')') { // 레이저가 나오면 반으로 가른다.(현재 있는 막대들의 개수만큼 증가된다.)
					res += cnt;
					i++;
				}
				else if(s.charAt(i) == '(') cnt++; // 막대 추가
				else { cnt--; res++; } // 막대 끝
			}
			System.out.println("#" + t + " " + ++res);
		}
	}
}