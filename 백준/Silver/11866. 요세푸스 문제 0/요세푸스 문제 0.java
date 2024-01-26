import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }
        sb.append('<');
        int idx = (K - 1) % N;
        while (true) {

            int r = list.get(idx);

            list.remove(idx);
            if (list.size() == 0) {
                sb.append(r).append('>');
                break;
            } else {
                sb.append(r).append(", ");
                idx = (idx + K-1) % list.size();
            }

        }
        System.out.println(sb);
    }
}
