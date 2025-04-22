import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[] arr0;
    static long[] arr1;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr0 = new long[N + 1];
        arr1 = new long[N + 1];

        arr0[1] = 0;
        arr1[1] = 1;

        System.out.println(dp(N));
    }

    private static long dp(int k) {
        for (int i = 2; i <= k; i++) {
            arr0[i] = arr0[i - 1] + arr1[i - 1];
            arr1[i] = arr0[i - 1];
        }
        return arr0[k] + arr1[k];
    }
}
