import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BaekJoon1270 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<SerialNum> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new SerialNum(sc.next()));
        }
        Collections.sort(list);

        for (SerialNum s : list) {
            System.out.println(s.serial);
        }

    }

    public static class SerialNum implements Comparable<SerialNum>{
        public String serial;

        SerialNum(String serial) {
            this.serial = serial;
        }

        @Override
        public int compareTo(SerialNum o) {
            if (this.serial.length() == o.serial.length()) {
                int sumA = 0;
                int sumB = 0;

                for (int i = 0; i < this.serial.length(); i++) {
                    if ('0' <= this.serial.charAt(i) && this.serial.charAt(i) <= '9') {
                        sumA += Integer.parseInt(String.valueOf(this.serial.charAt(i)));
                    }
                    if ('0' <= o.serial.charAt(i) && o.serial.charAt(i) <= '9') {
                        sumB += Integer.parseInt(String.valueOf(o.serial.charAt(i)));
                    }
                }

                if (sumA == sumB) {
                    for (int i = 0; i < this.serial.length(); i++) {
                        if (this.serial.charAt(i) == o.serial.charAt(i)) {
                            if (i == this.serial.length() -1) {
                                return 0;
                            } else {
                                continue;
                            }
                        } else {
                            return this.serial.charAt(i) - o.serial.charAt(i);
                        }
                    }
                    return 0;
                   // return this.serial.compareTo(o.serial);
                } else {
                    return sumA - sumB;
                }
            } else {
                return this.serial.length() - o.serial.length();
            }
        }
    }


}
