import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BaekJoon1063 {

    static int[] yp = {0, 0, -1, 1, 1, 1, -1, -1};
    static int[] xp = {1, -1, 0, 0, 1, -1, 1, -1};
    static String[] move = {"R", "L", "B", "T", "RT", "LT", "RB", "LB"};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ST = new StringTokenizer(br.readLine());

        String k = ST.nextToken(); //king
        String s = ST.nextToken(); //stone
        int n = Integer.parseInt(ST.nextToken());


        int kingX = k.charAt(0) - 64;
        int kingY = k.charAt(1) - 48;
        int stoneX = s.charAt(0) - 64;
        int stoneY = s.charAt(1) - 48;

        for (int i = 0; i < n; i++) {

            String m = br.readLine();
            int cnt = 0;

            for (String tmp : move) {
                if (m.equals(tmp)) {
                    break;
                }
                cnt++;
            }

            int dx = kingX + xp[cnt];
            int dy = kingY + yp[cnt];
            if (dx > 0 && dx < 9 && dy > 0 && dy < 9) {

                int sx = stoneX + xp[cnt];
                int sy = stoneY + yp[cnt];

                if (dx == stoneX && dy == stoneY) {
                    if (sx > 0 && sx < 9 && sy > 0 && sy < 9) {
                        stoneX += xp[cnt];
                        stoneY += yp[cnt];
                        kingX = dx;
                        kingY = dy;
                    }
                } else {
                    kingX = dx;
                    kingY = dy;
                }
            }
        }
        String king = (char) (kingX + 64) + "" + kingY;
        String stone = (char) (stoneX + 64) + "" + stoneY;

        System.out.println(king);
        System.out.println(stone);


    }
}
