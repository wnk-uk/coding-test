import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BaekJoon1021 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) queue.add(i);


        int answer = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            int x = Integer.parseInt(st.nextToken());

            while(queue.getFirst() != x) {

                if ((queue.size() / 2) >= queue.indexOf(x)) {
                    queue.addLast(queue.getFirst());
                    queue.removeFirst();
                } else {
                    queue.addFirst(queue.getLast());
                    queue.removeLast();
                }

                answer++;
            }

            if (queue.getFirst() == x) {
                queue.removeFirst();
            }

        }

        System.out.println(answer);

    }
}
