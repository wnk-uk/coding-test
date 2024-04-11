import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class BaekJoon1744 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        PriorityQueue<Integer> zero = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                zero.offer(x);
            }
            if (x > 0) plus.offer(x);
            else minus.offer(x);
        }

        int answer = 0;

        //음수계산
        while (!minus.isEmpty()) {
            int x = minus.poll();
            if (minus.size() >= 1) {
                int y = minus.poll();
                answer += x * y;
            } else if (!zero.isEmpty()) {
                zero.poll();
            } else {
                answer += x;
            }
        }

        while (!plus.isEmpty()) {
            int x = plus.poll();

            if (plus.size() > 0) {
                int y = plus.poll();
                if (x + y < x * y) {
                    answer += x * y;
                } else {
                    answer += x;
                    plus.offer(y);
                }
            } else {
                answer += x;
            }
        }

        System.out.println(answer);


    }

}
