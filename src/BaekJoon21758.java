import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon21758 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        int right = 0;
        //꿀통 오른쪽
        int tmp = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            int b1 = 0; //1이 될때까지 반복
            int b2 = i + 1; // 0이 될때까지 반복
            tmp += arr[b2];
            right = Math.max(right, (sum - arr[b1] - arr[b2]) + (sum - tmp - arr[b1]));
        }
        
        //꿀통 왼쪽
        int left = 0;
        tmp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int b1 = arr.length - 1; //1이 될때까지 반복
            int b2 = (arr.length - 2) - i; // 0이 될때까지 반복
            tmp += arr[b2];
            left = Math.max(left, (sum - arr[b1] - arr[b2]) + (sum - tmp - arr[b1]));
        }


        //꿀통 가운데
        int center = 0;
        tmp = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            tmp += arr[i]; //A의 합
            int b2 = arr.length - 1;
            center = Math.max(center, (tmp) + (sum - (tmp + arr[0]) + arr[i] - arr[b2]));
        }

        System.out.println(Math.max(right, Math.max(left, center)));



    }
}
