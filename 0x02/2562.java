import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int max = 0;
        int idx = 0;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());

            if (x > max) {
                max = x;
                idx = i;
            }
        }
        System.out.println(max);
        System.out.println(idx + 1);
    }
}
