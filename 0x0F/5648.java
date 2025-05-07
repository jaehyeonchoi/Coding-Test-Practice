import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new long[N];

        int count = 0;
        while (count < N) {
            while (st.hasMoreTokens()) {
                String num = st.nextToken();
                arr[count++] = Long.parseLong(reverse(num));
            }
            if (count < N) {
                st = new StringTokenizer(br.readLine());
            }
        }
        Arrays.sort(arr);
        for (long num : arr) {
            System.out.println(num);
        }
    }

    public static String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
