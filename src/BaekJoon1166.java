import java.util.Scanner;

public class BaekJoon1166 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long n = sc.nextInt();
        long l = sc.nextInt();
        long w = sc.nextInt();
        long h = sc.nextInt();


        //int min = Math.min(Math.min(l, w), h);
        long max = Math.max(Math.max(l, w), h);

        double lt = 0;
        double rt = max;

        for (int i = 0; i < 10000; i++) {
            double mid = (lt + rt) / 2;

            if ((long)(l/mid) * (long)(w/mid) * (long)(h/mid)  >= n) {
                lt = mid;
            } else {
                rt = mid;
            }
        }

        System.out.println(lt);

    }
}
