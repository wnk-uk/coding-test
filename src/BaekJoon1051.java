import java.util.Scanner;

public class BaekJoon1051 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        int max = Math.min(n, m);
        int[][] sqare = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                sqare[i][j] = str.charAt(j) - 48;
            }
        }

        if (max > 1) {

            while (true) {
                for (int i = 0; i <= n - max; i++) {
                    for (int j = 0; j <= m - max; j++) {
                        int point = sqare[i][j];

                        if (point == sqare[i][j + (max - 1)] && point == sqare[i + (max - 1)][j] && point == sqare[i + (max - 1)][j + (max - 1)]) {
                            System.out.println(max * max);
                            return;
                        }

                    }
                }
                max--;
            }

        } else {
            System.out.println(1);
        }
    }

}
