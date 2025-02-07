import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(" ".repeat(Math.max(0, i)));
            sb.append("*".repeat(Math.max(0, 2 * (N - i) - 1)));
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
