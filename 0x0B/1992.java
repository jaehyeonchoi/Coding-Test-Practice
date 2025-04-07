import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static int[] count = new int[2];
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        sb = new StringBuilder();
        recursive(N, 0, 0);

        System.out.println(sb);
    }

    public static void recursive(int k, int x, int y) {
        int start = arr[x][y]; // 좌측 상단의 숫자

        if (k > 1) { // 한 칸 짜리 종이가 아닌 경우
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < k; j++) {
                    if (arr[x + i][y + j] != start) { // 다른 숫자가 발견되면 4등분
                        int nk = k / 2;
                        sb.append("(");
                        recursive(nk, x, y);
                        recursive(nk, x, y + nk);
                        recursive(nk, x + nk, y);
                        recursive(nk, x + nk, y + nk);
                        sb.append(")");
                        return;
                    }
                }
            }
        }
        // 종이 한 장이 전부 같은 숫자인 경우
        sb.append(start);
    }
}
