import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] arr = new int[5];
        int sum = 0;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        Arrays.sort(arr);

        System.out.println(sum / 5);
        System.out.println(arr[2]);
    }
}
