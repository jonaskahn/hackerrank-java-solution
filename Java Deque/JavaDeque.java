import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class JavaDeque {
       public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        Map newMap = new ConcurrentHashMap();
        int n = in.nextInt();
        int m = in.nextInt();
        int countMax = 0;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            if (newMap.get(num) != null) {
                int check = (int) newMap.get(num);
                newMap.remove(num);
                newMap.put(num, ++check);

            } else {
                newMap.put(num, 1);
            }
            deque.addLast(num);
            if (deque.size() == m) {
                countMax = Math.max(countMax, newMap.size());
                int frs = (int) deque.pollFirst();
                int check = (int) newMap.get(frs);
                if(check == 1) newMap.remove(frs);
                else newMap.put(frs,--check);

            }

        }
        System.out.println(countMax);
    }
  }
