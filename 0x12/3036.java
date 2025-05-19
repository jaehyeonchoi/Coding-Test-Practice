import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            int gcd = gcd(arr[0], arr[i]);
            System.out.println(arr[0] / gcd + "/" + arr[i] / gcd);
        }
    }

    private static int gcd(int a, int b) {
        int temp;
        while (true) {
            temp = b;
            b = a % b;
            a = temp;
            if (b == 0) {
                break;
            }
        }
        return temp;
    }
}
