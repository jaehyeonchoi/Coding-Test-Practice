import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String N = st.nextToken();
        int[] arr = new int[10];

        for (int i = 0; i < N.length(); i++) {
            arr[N.charAt(i) - '0']++;
        }

        arr[6] = (arr[6] + arr[9] + 1) / 2;
        arr[9] = 0;
        System.out.println(Arrays.stream(arr).max().getAsInt());
    }
}
