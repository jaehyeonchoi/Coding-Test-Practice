import java.io.*;
import java.util.*;

public class Main {
    static int A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        System.out.println(func(B) - func(A - 1));
    }

    public static int func(int index) {
        int sum = 0;
        int n = 1;
        while (index >= n) {
            sum += n * n;
            index -= n;
            n++;
        }
        sum += n * index;
        return sum;
    }
}
