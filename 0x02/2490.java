import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int count = 0;

            for(int j = 0; j < 4; j++) {
                if (st.nextToken().equals("0")) {
                    count++;
                }
            }

            if (count == 1) {
                System.out.println("A");
            }
            if (count == 2) {
                System.out.println("B");
            }
            if (count == 3) {
                System.out.println("C");
            }
            if (count == 4) {
                System.out.println("D");
            }
            if (count == 0) {
                System.out.println("E");
            }
        }
    }
}
