import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        recursive(0);
    }

    public static void recursive(int k) {
        if (k == M) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        int start = 0;
        if (k > 0) {
            start = arr[k - 1];
        }
        for (int i = start; i < N; i++) {
            arr[k] = i + 1;
            recursive(k + 1);
        }
    }
}
