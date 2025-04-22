import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static ArrayList<Integer> N; // N 리스트
    static long[] p; // p(N) 값 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        N = new ArrayList<>();

        int max = 0;
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            max = Math.max(max, n);
            N.add(n);
        }

        p = new long[101];
        p[1] = 1;
        p[2] = 1;
        p[3] = 1;
        p[4] = 2;
        p[5] = 2;

        for (int i = 6; i <= max; i++) {
            p[i] = p[i - 5] + p[i - 1];
        }

        StringBuilder sb = new StringBuilder();
        for (int n : N) {
            sb.append(p[n]).append("\n");
        }
        System.out.println(sb);
    }
}
