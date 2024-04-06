import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BaekJoon1263 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Work> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            int ti = Integer.parseInt(st.nextToken()); //처리하는데 걸리는 시간
            int si = Integer.parseInt(st.nextToken()); //내에 일을 처리하는 시간

            list.add(new Work(ti, si));
        }
        Collections.sort(list);

        long min = 1000000;
        for (int i = 0; i < list.size(); i++) {
            min = Math.min(min, list.get(i).si) - list.get(i).ti;
            if (min < 0) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(min);

    }

    public static class Work implements Comparable<Work> {
        int ti, si;

        public Work (int ti, int si) {
            this.ti = ti;
            this.si = si;
        }


        @Override
        public int compareTo(Work o) {
            return o.si - this.si;
        }
    }

}
