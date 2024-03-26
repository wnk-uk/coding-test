import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BaekJoon1106 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken()); //필요고객
        int N = Integer.parseInt(st.nextToken()); //도시개수
        int[] dy = new int[C + 101];
        Arrays.fill(dy, 987654321);
        dy[0] = 0;

        ArrayList<Point> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); //비용
            int y = Integer.parseInt(st.nextToken()); //고객수
            list.add(new Point(x, y));
        }

        Collections.sort(list);

        for (int i = 0; i < N; i++) {
            int x =  list.get(i).x;
            int y =  list.get(i).y;

            for (int j = y; j < C + 101; j++) {
                dy[j] =  Math.min(dy[j], dy[j - y] + x);
            }
        }

        //dy[C] 보다 큰 인덱스 중에 가장 작은 수
        int answer = Integer.MAX_VALUE;

        for (int i = C; i < C + 101; i++) {
            answer = Math.min(answer, dy[i]);
        }

        System.out.println(answer);

    }

    public static class Point implements Comparable<Point> {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.y == o.y) {
                return this.x - o.x;
            } else {
                return this.y - o.y;
            }
        }
    }

}
