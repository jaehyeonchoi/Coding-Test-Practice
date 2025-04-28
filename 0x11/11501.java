import java.io.*;
import java.util.*;

public class Main {
    static int T, N;
    static int[] price;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int test = 0; test < T; test++) {
            N = Integer.parseInt(br.readLine());
            price = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int num = 0; num < N; num++) {
                price[num] = Integer.parseInt(st.nextToken());
            }

            long sum = 0;
            int max = price[N - 1];
            for (int i = N - 2; i > -1; i--) {
                if (max < price[i]) {
                    max = price[i];
                    continue;
                }
                sum += max - price[i];
            }
            System.out.println(sum);
        }
    }
}
