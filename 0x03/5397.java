import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            LinkedList<Character> charList = new LinkedList<>();
            String commands = br.readLine();

            ListIterator<Character> cursor = charList.listIterator();
            for (int j = 0; j < commands.length(); j++) {
                char command = commands.charAt(j);
                switch (command) {
                    case '<':
                        if (cursor.hasPrevious()) {
                            cursor.previous();
                        }
                        break;
                    case '>':
                        if (cursor.hasNext()) {
                            cursor.next();
                        }
                        break;
                    case '-':
                        if (cursor.hasPrevious()) {
                            cursor.previous();
                            cursor.remove();
                        }
                        break;
                    default:
                        cursor.add(command);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (char c : charList) {
                sb.append(c);
            }
            System.out.println(sb);
        }
    }
}
