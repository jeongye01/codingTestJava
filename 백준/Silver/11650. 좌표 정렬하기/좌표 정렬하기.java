import java.io.*;
import java.util.*;
// 6분 
public class Main {
	//static int N;

    static class Position implements Comparable<Position>{
    	int x;
    	int y;
		@Override
		public int compareTo(Position o) {
			if(o.x==this.x) {
				return this.y-o.y;
			}
			return this.x-o.x;
		}
    	
    }
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine().trim());
		List<Position> list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine().trim());
			int x= Integer.parseInt(st.nextToken());
			int y= Integer.parseInt(st.nextToken());
			Position p = new Position();
			p.x=x;
			p.y=y;
			list.add(p);		
		}
		Collections.sort(list);
		for(Position p:list) {
			sb.append(p.x).append(" ").append(p.y).append('\n');
		}
		System.out.println(sb);
	

	}

}