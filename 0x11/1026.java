import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Integer[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Integer[2][N];

        StringTokenizer st;
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(arr[0]);
        Arrays.sort(arr[1], Comparator.reverseOrder());

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[0][i] * arr[1][i];
        }
        System.out.println(sum);
    }
}
