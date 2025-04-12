import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[1001];

        arr[0] = 1; // 아무 타일도 안쓰기 -> 1개
        arr[1] = 1; // | 타일 1개 쓰기 -> 1개

        for (int i = 2; i < n + 1; i++) {
            // 한 칸 짧은 거에서 | 타일 1개 붙이기 -> arr[i - 1]개
            // 두 칸 짧은 거에서 ㅁ 또는 = 타일 붙이기 -> arr[i - 2] * 2개
            arr[i] = (arr[i - 1] + arr[i - 2] * 2) % 10007; // 미리 10007으로 나눈 나머지로 저장
        }
        System.out.println(arr[n]);
    }
}
