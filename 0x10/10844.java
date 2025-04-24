import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[][] arr;
    static long div = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new long[10][N + 1];
        for (int i = 1; i < 10; i++) {
            arr[i][1] = 1;
        }

        for (int i = 2; i <= N; i++) {
            arr[0][i] = arr[1][i - 1] % div;
            for (int j = 1; j <= 8; j++) {
                arr[j][i] = (arr[j - 1][i - 1] + arr[j + 1][i - 1]) % div;
            }
            arr[9][i] = arr[8][i - 1] % div;
        }

        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += arr[i][N] % div;
        }
        System.out.println(sum % div);
    }
}
