import java.io.*;
import java.util.*;

public class Main {
    static int t, n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int test = 0; test < t; test++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long sum = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    sum += gcd(arr[i], arr[j]); // 가능한 모든 조합의 최대공약수의 총합을 계산
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }

    private static int gcd(int x, int y) { // 유클리드 호제법으로 최대공약수
        int a = Math.max(x, y);
        int b = Math.min(x, y);

        while (true) {
            int temp = a;
            a = b;
            b = temp % b;
            if (b == 0) {
                return a;
            }
        }
    }
}
