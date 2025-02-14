import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            list.add(i + 1);
        }
        ListIterator<Integer> iter = list.listIterator();

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for(int i = 0; i < N; i++) {
            int number = 0;
            for(int j = 0; j < K; j++) {
                if (!iter.hasNext()) {
                    iter = list.listIterator();
                }
                number = iter.next();
            }
            iter.remove();
            sb.append(number);
            if (i != N - 1) {
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}
