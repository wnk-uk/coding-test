import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BaekJoon12018 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //과목 수
        int m = Integer.parseInt(st.nextToken()); // 마일리지

        int sum = 0;
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken()); //신청한 사람
            int l = Integer.parseInt(st.nextToken()); // 과목 수강인원
            
            //각각의 마일리지
            Integer[] tmp = new Integer[p];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < p; j++) {
                tmp[j] = Integer.parseInt(st.nextToken());

            }

            Arrays.sort(tmp, Collections.reverseOrder());

            if (p < l) arr.add(1);
            else arr.add(tmp[l - 1]);
        }

        Collections.sort(arr);

        int answer = 0;
        int calc = 0;
        for (int i = 0; i < arr.size(); i++) {
            calc += arr.get(i);
            if (calc > m) break;
            answer++;
        }

        System.out.println(answer);
    }
}
