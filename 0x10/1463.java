import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        arr[1] = 0;

        for (int i = 2; i < N + 1; i++) {
            int min = arr[i - 1] + 1;

            if (i % 2 == 0) {
                min = Math.min(min, arr[i / 2] + 1);
            }
            if (i % 3 == 0) {
                min = Math.min(min, arr[i / 3] + 1);
            }

            arr[i] = min;
        }
        System.out.println(arr[N]);
    }
}
