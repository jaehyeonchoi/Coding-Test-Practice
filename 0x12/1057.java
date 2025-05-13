import java.io.*;
import java.util.*;

public class Main {
    static int N, j, h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        j = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        int round = 1;
        while (true) {
            int min = Math.min(j, h);
            int max = Math.max(j, h);
            if (max - min == 1 && max % 2 == 0) {
                System.out.println(round);
                break;
            }
            j = (j + 1) / 2;
            h = (h + 1) / 2;
            round++;
        }
    }
}
