
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Java1DArray {

    public static void main(String[] args) {

        try (Scanner scan = new Scanner(System.in)) {
            int T = scan.nextInt();
            for (int i = 0; i < T; i++) {
                scan.nextInt();
                int m = scan.nextInt();
                scan.nextLine();
                List lines = Arrays.stream(scan.nextLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());
                System.out.println(isRightWay(m, 0, lines) ? "YES" : "NO");
            }
        }
    }
    private static boolean isRightWay(int m, int i, List<Integer> lines) {
        if(i < 0 || lines.get(i) == 1) return false;
        if( i == lines.size() - 1 || i+m > lines.size() - 1 ) return true;
        lines.set(i,1);
        return isRightWay(m,i+1,lines)||isRightWay(m,i-1,lines)|| isRightWay(m,i+m,lines);
    }
}
