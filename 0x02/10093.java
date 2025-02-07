import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        if (A > B) {
            long temp = A;
            A = B;
            B = temp;
        }

        System.out.println(A == B ? 0 : B - A - 1);

        StringBuilder sb = new StringBuilder();
        for (long i = A + 1; i < B; i++) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
