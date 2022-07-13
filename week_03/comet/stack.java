import java.io.*;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer> stack = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");

            switch (input[0]) {
                case "push":
                    push(Integer.parseInt(input[1]));
                    break;
                case "pop":
                    bw.write(pop() + "\n");
                    break;
                case "size":
                    bw.write(size() + "\n");
                    break;
                case "empty":
                    bw.write(empty() + "\n");
                    break;
                case "top":
                    bw.write(top() + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

    static void push(int x) {
        stack.add(x);
    }

    static int pop() {
        if (stack.size() == 0) return -1;
        return stack.remove(stack.size() - 1);
    }

    static int size() {
        return stack.size();
    }

    static int empty() {
        if (stack.isEmpty()) return 1;
        return 0;
    }

    static int top() {
        if (stack.isEmpty()) return -1;
        return stack.get(stack.size() - 1);
    }
}