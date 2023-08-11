import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	static int arr[],sum;
   
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr=new int[9]; 
		sum=0;
		for(int i=0;i<9;i++) {
			arr[i]=Integer.parseInt(br.readLine());
			sum+=arr[i];
		}
		for(int i=0;i<8;i++) {
			for(int j=i+1;j<9;j++) {
				if(sum-arr[i]-arr[j]==100) {
					for(int k=0;k<9;k++) {
						if(k!=i && k!=j) {
							System.out.println(arr[k]);
						}
					}
					return;
				}
			}
		}

	}

}
