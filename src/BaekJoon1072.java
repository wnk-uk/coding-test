
import java.util.Scanner;

public class BaekJoon1072 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        sc.nextLine();

        long rate = (long) ((double)y * 100.0 / (double)x);

        if (rate >= 99) {
            System.out.println(-1);
        } else {
            long lt = 0;
            long rt = Integer.MAX_VALUE;

            while (lt < rt) {
                long mid = (lt + rt) / 2;
                long tmp = (long) ((double)(y + mid) * 100.0 / (x + mid));
                if (tmp > rate) {
                    rt = mid;
                } else {
                    lt = mid + 1;
                }
            }

            System.out.println(rt);
        }

    }
}
