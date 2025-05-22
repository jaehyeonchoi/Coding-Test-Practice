import java.io.*;
import java.util.*;

public class Main {
    static int nA, nB;
    static int[] A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        nA = Integer.parseInt(st.nextToken());
        nB = Integer.parseInt(st.nextToken());
        A = new int[nA];
        B = new int[nB];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nA; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nB; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        Arrays.sort(B);

        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nA; i++) { // A의 각 원소에 대해서
            if (!func(A[i])) { // B에 속하지 않는 원소인 경우
                count++;
                sb.append(A[i]).append(" ");
            }
        }
        System.out.println(count);
        System.out.println(sb);
    }
    private static boolean func(int x) { // 이진탐색으로 x를 찾기
        int start = 0;
        int end = nB - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (B[mid] > x) {
                end = mid - 1;
            }
            else if (B[mid] < x) {
                start = mid + 1;
            }
            else {
                return true;
            }
        }
        return false;
    }
}
