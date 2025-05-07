import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static CompString[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new CompString[N];

        for (int i = 0; i < N; i++) {
            arr[i] = new CompString(br.readLine());
        }
        Arrays.sort(arr);

        System.out.println(arr[0].string);
        for (int i = 1; i < N; i++) {
            if (!arr[i].string.equals(arr[i - 1].string)) {
                System.out.println(arr[i].string);
            }
        }
    }

    static class CompString implements Comparable<CompString> {
        private final String string;

        private CompString(String string) {
            this.string = string;
        }

        @Override
        public int compareTo(CompString compString) {
            if (this.string.length() == compString.string.length()) {
                return this.string.compareTo(compString.string);
            }
            return this.string.length() - compString.string.length();
        }
    }
}
