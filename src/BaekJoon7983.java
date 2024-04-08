import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BaekJoon7983 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Assignment> arr = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr.add(new Assignment(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())));
        }
        Collections.sort(arr);

        long min = arr.get(0).e - arr.get(0).s;
        for (int i = 1; i < arr.size(); i++) {
            if (min > arr.get(i).e) {
                min = arr.get(i).e - arr.get(i).s;
            } else {
                min -= arr.get(i).s;
            }
        }

        System.out.println(min);



    }

    public static class Assignment implements Comparable<Assignment>{
        long s, e;

        public Assignment (long s, long e) {
            this.s = s;
            this.e = e;
        }


        @Override
        public int compareTo(Assignment o) {
            return (int) (o.e - this.e);
        }
    }

}
