import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] arr; // 플러그에 꽂는 순서
    static Device[] plug; // 플러그에 꽃혀 있는 제품 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[K + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int count = 0; // 현재 꽂혀있는 플러그의 개수
        plug = new Device[N];

        for (int i = 0; i < K; i++) {
            boolean isExist = false;
            for (Device device : plug) { // 이미 꽃혀있는 제품이면 pass
                if (device != null && device.num == arr[i]) {
                    isExist = true;
                    break;
                }
            }
            if (!isExist) { // 꽂혀있지 않은 제품인 경우
                if (count < N) { // 남은 플러그 자리가 있는 경우, 바로 꽂기
                    plug[count] = new Device(arr[i], K + 1);
                    count++;
                }
                else { // 남은 플러그 자리가 없는 경우
                    for (Device device : plug) {
                        for (int k = i + 1; k <= K; k++) { // 가장 늦게 다시 사용되는 제품을 뽑기
                            if (arr[k] == device.num) {
                                device.time = k;
                                break;
                            }
                            device.time = K + 1; // 앞으로 꽂힐 일 없는 제품은 최대값
                        }
                    }
                    int max = 0; // 가장 늦게 다시 사용되는 제품의 시간
                    int index = 0; // 가장 늦게 다시 사용되는 제품의 번호
                    for (int k = 0; k < N; k++) {
                        if (max < plug[k].time) {
                            max = plug[k].time;
                            index = k;
                        }
                    }
                    plug[index] = new Device(arr[i], K + 1); // 가장 늦게 다시 사용되는 자리에 뽑기
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }

    public static class Device implements Comparable<Device> {
        private final int num;
        private int time;

        public Device(int num, int time) {
            this.num = num;
            this.time = time;
        }

        @Override
        public int compareTo(Device d) {
            return this.time - d.time;
        }
    }
}
