import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        recursive(N, 0, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0) {
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
        if (k == 1) {
            return;
        }

        int nk = k / 3;
        for (int i = 0; i < nk; i++) {
            for (int j = 0; j < nk; j++) {
                arr[x + nk + i][y + nk + j] = 1;
            }
        }

        recursive(nk, x, y);
        recursive(nk, x + nk, y);
        recursive(nk, x + nk * 2, y);
        recursive(nk, x, y + nk);
        recursive(nk, x + nk * 2, y + nk);
        recursive(nk, x, y + nk * 2);
        recursive(nk, x + nk, y + nk * 2);
        recursive(nk, x + nk * 2, y + nk * 2);
    }
}
