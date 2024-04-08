import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BaekJoon12931 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);
        int answer = 0;

        while (true) {
            int doubleCnt = 0;
            for (int i = 0; i < list.size(); i++) {

                //짝수
                if (list.get(i) % 2 == 0) {
                    doubleCnt++;
                } else { //홀수
                    list.set(i, list.get(i) - 1);
                    answer++;
                }
            }

            if (Collections.max(list) == 0) {
                break;
            }

            if (doubleCnt == list.size()) {
                for (int i = 0; i < list.size(); i++) {
                    list.set(i, list.get(i) / 2);
                }
                answer++;
            }
        }
        System.out.println(answer);
    }

}
