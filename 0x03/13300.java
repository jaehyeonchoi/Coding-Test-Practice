import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[12];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());
            arr[(grade - 1) * 2 + sex]++;
        }

        int room = 0;
        for (int i = 0; i < 12; i++) {
            room += arr[i] / K;
            if (arr[i] % K != 0) {
                room++;
            }
        }
        System.out.println(room);
    }
}
