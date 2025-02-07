import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b= Integer.parseInt(st.nextToken()) - 1;

            for (int j = 0; j < (b - a) / 2 + 1; j++) {
                int temp = arr[a + j];
                arr[a + j] = arr[b - j];
                arr[b - j] = temp;
            }
        }

        for (int card : arr) {
            System.out.print(card + " ");
        }
    }
}
