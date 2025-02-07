import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int Y = 0;
        int M = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());

            Y += (a / 30 + 1) * 10;
            M += (a / 60 + 1) * 15;
        }

        if (Y < M) {
            System.out.println("Y " + Y);
            return;
        }
        else if (Y > M) {
            System.out.println("M " + M);
            return;
        }
        System.out.println("Y M " + M);

    }
}
