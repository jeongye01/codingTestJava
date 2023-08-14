import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        scanner.nextLine(); // consume the newline
        String cmds = scanner.nextLine();
        int hole_i = scanner.nextInt();
        int[][] hole_kinds = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};

        List<int[]> row_i = new ArrayList<>();
        List<int[]> col_i = new ArrayList<>();
        for (int i = 0; i < (1 << k); i++) {
            row_i.add(new int[]{i, 0});
            col_i.add(new int[]{i, 0});
        }

        List<Boolean> row_cmd = new ArrayList<>();
        List<Boolean> col_cmd = new ArrayList<>();
        for (char cmd : cmds.toCharArray()) {
            if (cmd == 'R') {
                col_cmd.add(false);
            } else if (cmd == 'L') {
                col_cmd.add(true);
            } else if (cmd == 'U') {
                row_cmd.add(true);
            } else if (cmd == 'D') {
                row_cmd.add(false);
            }
        }

        List<int[]> row_ret = fold(row_i, row_cmd);
        List<int[]> col_ret = fold(col_i, col_cmd);

        for (int[] row_idx : row_ret) {
            for (int[] col_idx : col_ret) {
                int[] hole_ret = hole_kinds[hole_i].clone();
                if (row_idx[1] == 1) {
                    hole_ret[0] = 1 - hole_ret[0];
                }
                if (col_idx[1] == 1) {
                    hole_ret[1] = 1 - hole_ret[1];
                }
                System.out.print(findIndex(hole_kinds, hole_ret) + " ");
            }
            System.out.println();
        }
    }

    public static List<int[]> fold(List<int[]> list_i, List<Boolean> cmds) {
        if (list_i.size() > 1) {
            List<int[]> ret = new ArrayList<>();
            boolean cmd = cmds.remove(0);
            if (!cmd) {
                for (int i = 0; i < list_i.size() / 2; i++) {
                    list_i.get(i)[1] = 1 - list_i.get(i)[1];
                }
                ret.addAll(fold(new ArrayList<>(list_i.subList(0, list_i.size() / 2)), new ArrayList<>(cmds)));
                ret.addAll(fold(new ArrayList<>(list_i.subList(list_i.size() / 2, list_i.size())), new ArrayList<>(cmds)));
            } else {
                for (int i = list_i.size() / 2; i < list_i.size(); i++) {
                    list_i.get(i)[1] = 1 - list_i.get(i)[1];
                }
                ret.addAll(fold(new ArrayList<>(list_i.subList(0, list_i.size() / 2)), new ArrayList<>(cmds)));
                ret.addAll(fold(new ArrayList<>(list_i.subList(list_i.size() / 2, list_i.size())), new ArrayList<>(cmds)));
            }
            return ret;
        } else {
            return list_i;
        }
    }

    public static int findIndex(int[][] arr, int[] target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] == target[0] && arr[i][1] == target[1]) {
                return i;
            }
        }
        return -1; // Not found
    }
}
