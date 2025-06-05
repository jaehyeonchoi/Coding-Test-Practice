import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        long count = 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                int lowerBound = binarySearch(-(arr[i] + arr[j]), j + 1 ,true);
                int upperBound = binarySearch(-(arr[i] + arr[j]), j + 1 ,false);
                count += upperBound - lowerBound;
            }
        }
        System.out.println(count);
    }

    public static int binarySearch(int target, int start, boolean isLowerBound) {
        int end = N;
        while (start < end) {
            int mid = (start + end) / 2;
            if (isLowerBound && target <= arr[mid]) { // lowerBound 찾기
                // mid가 target보다 크거나 같으면, end를 mid까지 당김 -> target보다 크거나 같은 첫번째 값 찾기
                end = mid;
            }
            else if (!isLowerBound && target < arr[mid]) { // upperBound 찾기
                // mid가 target보다 큰 경우, end를 mid까지 당김 -> target보다 큰 첫번째 값 찾기
                end = mid;
            }
            else { // mid가 target보다 작은 경우, start를 mid + 1까지 당김
                start = mid + 1;
            }
        }
        return end;
    }
}
