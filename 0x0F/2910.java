import java.io.*;
import java.util.*;

public class Main {
    static int N, C;
    static ArrayList<Freq> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            boolean isExist = false;
            for (Freq freq : list) {
                if (freq.num == num) {
                    freq.count++;
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                list.add(new Freq(num, 1, i));
            }
        }
        StringBuilder sb = new StringBuilder();
        Collections.sort(list);
        for (Freq freq : list) {
            for (int i = 0; i < freq.count; i++) {
                sb.append(freq.num).append(" ");
            }
        }
        System.out.println(sb);
    }

    static class Freq implements Comparable<Freq> {
        private final int num;
        private int count;
        private final int appear;

        private Freq(int num, int count, int appear) {
            this.num = num;
            this.count = count;
            this.appear = appear;
        }

        @Override
        public int compareTo(Freq freq) {
            if (this.count == freq.count) {
                return this.appear - freq.appear;
            }
            return freq.count - this.count;
        }
    }
}
