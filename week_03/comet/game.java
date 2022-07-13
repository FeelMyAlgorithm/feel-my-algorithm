import java.io.*;

public class Main1103 {
    static int n, m;
    static int[][] board;
    static boolean[][] visited;
    static int[][] dp;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();

            for (int j = 0; j < m; j++) {
                char num = temp.charAt(j);
                if (num == 'H') {
                    board[i][j] = 0;
                } else {
                    board[i][j] = num - '0';
                }
            }
        }

        visited = new boolean[n][m];
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }

        int answer = dfs(0, 0);
        bw.write(Integer.toString(answer));
        bw.flush();
    }

    static int dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= m || y >= n || board[y][x] == 0) return 0;

        if (visited[y][x]) return -1;

        if (dp[y][x] != -1) return dp[y][x];

        visited[y][x] = true;
        dp[y][x] = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + board[y][x] * dx[i];
            int ny = y + board[y][x] * dy[i];

            int dfs = dfs(nx, ny);
            if (dfs == -1) return -1;
            dp[y][x] = Math.max(dp[y][x], dfs(nx, ny) + 1);
        }

        visited[y][x] = false;

        return dp[y][x];
    }
}