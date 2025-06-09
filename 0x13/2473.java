import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        long min = Long.MAX_VALUE; // 세 용액의 합의 최소 절댓값
        int[] minArr = new int[3]; // 절댓값이 최소일 때의 세 용액의 인덱스 배열
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                long target = arr[i] + arr[j]; // 첫 두 용액을 고정하고, 현재의 합과 부호가 반대인 용액을 찾기
                int lowerBound = getLowerBound(-target, j + 1); // lowerBound로 처음으로 target보다 같거나 커지는 index를 찾기

                // lowerBound index의 용액을 섞으면 세 용액이 합이 0 또는 양수값이 나옴
                // lowerBound보다 뒤의 용액을 섞으면 합이 더욱 커지므로 고려할 필요 X
                // 따라서 찾고자 하는 세 번째 용액은 lowerBound 또는 lowerBound 하나 앞에서 나옴
                long localMin = Long.MAX_VALUE; // 첫 두 용액이 정해졌을 때의 세 용액의 합의 최소 절댓값
                int localMinIdx = -1; // localMin이 나올 때의 세 번째 용액의 index

                // lowerBound는 (j + 1)부터 N까지의 값을 갖게 됨
                // 따라서 lowerBound와 (lowerBound - 1)가 인덱스 범위 내에 있는지 확인하여 최솟값 갱신
                if (lowerBound < N) { // lowerBound가 인덱스 범위 내에 있는 경우
                    // lowerBound 번째 용액을 섞었을 때의 절댓값
                    long newAbsValue = Math.abs(target + arr[lowerBound]);
                    if (newAbsValue < localMin) {
                        localMin = newAbsValue;
                        localMinIdx = lowerBound;
                    }
                }
                if (j < lowerBound - 1) { // (lowerBound - 1)이 인덱스 범위 내에 있는 경우
                    // (lowerBound - 1) 번째 용액을 섞었을 때의 절댓값
                    long newAbsValue = Math.abs(target + arr[lowerBound - 1]);
                    if (newAbsValue < localMin) {
                        localMin = newAbsValue;
                        localMinIdx = lowerBound - 1;
                    }
                }

                if (localMin < min) { // 현재 찾은 최소값이 전체 최솟값보다 작으면 갱신
                    min = localMin;
                    minArr[0] = i;
                    minArr[1] = j;
                    minArr[2] = localMinIdx;
                }
            }
        }
        for (int idx : minArr) {
            System.out.print(arr[idx] + " ");
        }
        System.out.println();
    }

    public static int getLowerBound(long target, int start) {
        int end = N;
        while (start < end) {
            int mid = (start + end) / 2;
            if (target <= arr[mid]) { // lowerBound 찾기
                // mid가 target보다 크거나 같으면, end를 mid까지 당김 -> target보다 크거나 같은 첫번째 값 찾기
                end = mid;
            }
            else { // mid가 target보다 작은 경우, start를 mid + 1까지 당김
                start = mid + 1;
            }
        }
        return end;
    }
}
