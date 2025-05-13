import java.io.*;
import java.util.*;

public class Main {
    static int E, S, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        long years = 1;
        int e = 1;
        int s = 1;
        int m = 1;
        while (true) {
            if (e == E && s == S && m == M) {
                System.out.println(years);
                return;
            }
            years++;
            e++;
            s++;
            m++;
            if (e == 16) {
                e = 1;
            }
            if (s == 29) {
                s = 1;
            }
            if (m == 20) {
                m = 1;
            }
        }
    }
}
