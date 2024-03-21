import java.util.*;
import java.util.zip.Adler32;

public class BaekJoon1213 {

    public static void main(String[] args) {

        //전체 돌려서 갯수만큼
        //사전순으로
        // A:2 B:4 C:1   ABBCBBA
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] arr = new int[26];

        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'A';
            arr[idx] += 1;
        }

        int isOne = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                isOne++;
            }
        }

        if (isOne > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }


        StringBuffer prefix = new StringBuffer();
        StringBuffer mid = new StringBuffer();
        String answer = "";

        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];

            for (int j = 0; j < x / 2; j++) {
                int tmp = i + 'A';
                prefix.append((char) tmp);
            }

            if (x % 2 == 1) {
                int tmp = i + 'A';
                mid.append((char) tmp);
            }
        }

        answer = prefix.toString();
        answer += mid.toString();
        answer += prefix.reverse().toString();

        System.out.println(answer);

    }

}
