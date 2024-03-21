
public class BaekJoon1105 {

    static int answer = 0;

    public static void main(String[] args) {


        java.util.Scanner sc = new java.util.Scanner(System.in);
        String x = sc.next();
        String y = sc.next();

        if (x.length() != y.length()) {
            System.out.println(answer);
            return;
        }


        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) == '8' && y.charAt(i) == x.charAt(i)) {
                answer++;
                continue;
            }

            if (y.charAt(i) != x.charAt(i)){
                break;
            }
        }


        System.out.println(answer);
    }
}
