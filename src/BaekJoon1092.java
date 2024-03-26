import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon1092 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N]; //크레인
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine()); //box 개수

        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> box = new ArrayList<Integer>();
        for (int i = 0; i < M; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }

        box.sort(Collections.reverseOrder());

        int answer = 0;
        while(box.size() > 0) {
            int start = box.size();
            int crainIdx = arr.length - 1;
            int boxIdx = 0;

            while (crainIdx >= 0) {
                if (boxIdx == box.size()) break;

                if (arr[crainIdx] >= box.get(boxIdx)) {
                    box.remove(boxIdx);
                    crainIdx--;
                } else {
                    boxIdx++;
                }
            }

            if (start == box.size()) {
                System.out.println(-1);
                return;
            }

            answer++;

        }

        System.out.println(answer);



    }



}
