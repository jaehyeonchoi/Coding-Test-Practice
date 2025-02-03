import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if (a == b && b == c) {
            System.out.println(10000 + 1000 * a);
        }
        else if (a == b) {
            System.out.println(1000 + 100 * a);
        }
        else if (b == c) {
            System.out.println(1000 + 100 * b);
        }
        else if (c == a) {
            System.out.println(1000 + 100 * c);
        }
        else {
//            if (a >= b) {
//                if (a >= c) {
//                    System.out.println(100 * a);
//                }
//                else {
//                    System.out.println(100 * c);
//                }
//            }
//            else {
//                if (b >= c) {
//                    System.out.println(100 * b);
//                }
//                else {
//                    System.out.println(100 * c);
//                }
//            }
            System.out.println(100 * Math.max(a, Math.max(b, c)));
        }
    }
}
