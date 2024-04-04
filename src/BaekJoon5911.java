import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BaekJoon5911 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        ArrayList<Friend> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long pi = Long.parseLong(st.nextToken());
            long si = Long.parseLong(st.nextToken());
            arr.add(new Friend(pi, si));
        }

        ArrayList<Long> answer = new ArrayList<>();
        long[] sum;

        for (int i = 0; i < arr.size(); i++) {

            //하나의 리스트
            sum = new long[N];
            for (int y = 0; y < arr.size(); y++) {
                if (i == y) {
                    sum[y] += arr.get(y).c_sum;
                } else {
                    sum[y] += arr.get(y).sum;
                }
            }


            Arrays.sort(sum);
            long tmpSum = 0, cnt = 0;
            for (int y = 0; y < sum.length; y++) {
                tmpSum += sum[y];
                if (tmpSum > B) {
                    break;
                }
                cnt++;
            }
            answer.add(cnt);
        }

        System.out.println(Collections.max(answer));
    }

    public static class Friend {

        long pi;
        long si;

        long sum;
        long c_sum;

        public Friend(long pi, long si) {
            this.pi = pi;
            this.si = si;
            this.sum = pi + si;
            this.c_sum = (pi / 2) + si;
        }
     }

}
