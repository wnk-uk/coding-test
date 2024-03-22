import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BaekJoon1448 {

    public static void main(String[] args) throws IOException {

        //가장 긴 변의 길이가 나머지 두 변의 길이의 합보다 작아야 함
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int answer = 0;

        while(answer == 0) {

            if (pq.size() == 2) {
                answer = -1;
                break;
            }

            int x = pq.poll();
            int bl = pq.poll();
            int bbl = pq.poll();
            int sum = bl + bbl;

            pq.offer(bl);
            pq.offer(bbl);

            if (x < sum) {
                answer = x + sum;
            }
        }

        System.out.println(answer);
    }
}
