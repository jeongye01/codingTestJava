
import java.io.*;
import java.util.*;
// 3분 
public class Main {
	private static class Position implements Comparable<Position> {
		int x,y;
		
		@Override
		public int compareTo( Position o) {
			// TODO Auto-generated method stub
			if(this.y==o.y) {
				return this.x-o.x;
			}
			return this.y-o.y;
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
			Position p = new Position();
			p.x=Integer.parseInt(st.nextToken());
			p.y = Integer.parseInt(st.nextToken());
			list.add(p);
		}
		Collections.sort(list);
		for(Position p:list) {
			sb.append(p.x).append(' ').append(p.y).append('\n');
		}
		System.out.println(sb);
	

	}

}
