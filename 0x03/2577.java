import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int mul = 1;
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            mul *= Integer.parseInt(st.nextToken());
        }

        String str = Integer.toString(mul);
        int[] arr = new int[10];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - '0']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int a : arr) {
            sb.append(a).append("\n");
        }
        System.out.println(sb);
    }
}
