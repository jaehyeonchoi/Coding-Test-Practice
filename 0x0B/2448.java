import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N * 2 - 1];

        for (int i = 0; i < N; i++) {
            for (int j = N - i - 1; j < N + i; j++) {
                arr[i][j] = 1;
            }
        }

        recursive(N, 0, N - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N * 2 - 1; j++) {
                if (arr[i][j] == 1) {
                    sb.append("*");
                }
                else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void recursive(int k, int x, int y) {
        if (k == 3) {
            arr[x + 1][y] = 0;
            return;
        }

        for (int i = 0; i < k / 2; i++) {
            for (int j = 0; j < k - i * 2 - 1; j++) {
                arr[x + k / 2 + i][y - (k - i * 2 - 1) / 2 + j] = 0;
            }
        }

        int nk = k / 2;

        recursive(nk, x, y);
        recursive(nk, x + nk, y - nk);
        recursive(nk, x + nk, y + nk);
    }
}
