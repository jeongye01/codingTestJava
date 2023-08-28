import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int n = sc.nextInt();
		 int tmp;
		 int sum = 0;
		 int num=0;
		 for (int i = 0; i < n; i++) {
			tmp= sc.nextInt();
			sum += tmp;
			if(tmp%2==1) {
				num++;
			}
		}
		if(sum%3==0 && num<=sum/3) {
			System.out.println("YES");
		}else
			System.out.println("NO");
	}
}