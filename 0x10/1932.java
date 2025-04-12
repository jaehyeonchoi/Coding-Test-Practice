import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        int max = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                int left = (i > 0 && j > 0) ? arr[i - 1][j - 1] : 0; // 왼쪽 위 칸까지의 최대 누적값
                int right = i > 0 ? arr[i - 1][j] : 0; // 오른쪽 위 칸까지의 최대 누적값
                arr[i][j] = Math.max(left, right) + Integer.parseInt(st.nextToken()); // 둘 중에서 더 큰 값에 현재 칸의 값을 새로 누적

                if (i == n - 1) { // 마지막 줄에서는 전체 최대 누적값을 찾음
                    if (max < arr[i][j]) {
                        max = arr[i][j];
                    }
                }
            }
        }
        System.out.println(max);
    }
}
