import java.io.*;
import java.util.*;
// 3분 
public class Main {
	private static class Person implements Comparable<Person> {
		int age;
		String name;
		@Override
		public int compareTo(Person o) {
			// TODO Auto-generated method stub
			
			return this.age-o.age;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine().trim());
		List<Person> list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine().trim());
			Person p = new Person();
			p.age=Integer.parseInt(st.nextToken());
			p.name = st.nextToken();
			list.add(p);
		}
		Collections.sort(list);
		for(Person p:list) {
			sb.append(p.age).append(' ').append(p.name).append('\n');
		}
		System.out.println(sb);
	

	}

}
