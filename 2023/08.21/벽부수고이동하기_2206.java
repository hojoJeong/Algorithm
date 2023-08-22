import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기_2206 {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int N, M, ans;
    static int[][] map;
    static boolean[][][] vis;
    static Queue<Position> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        vis = new boolean[2][N][M];
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        if (N == 1 && M == 1) {
            System.out.println(1);
            return;
        }

        System.out.println(getResult());
    }

    static int getResult() {
        queue = new LinkedList<>();
        queue.add(new Position(0, 0, 1, false));
        vis[0][0][0] = true;
        vis[1][0][0] = true;

        while (!queue.isEmpty()) {
            Position cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextR = cur.r + dr[i];
                int nextC = cur.c + dc[i];
                int cnt = cur.cnt + 1;

                if (nextR == N - 1 && nextC == M - 1) return cnt;

                if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= M) continue;

                if (map[nextR][nextC] == 0) { //벽이 아닐 경우
                    if (!cur.destroyed && !vis[0][nextR][nextC]) {    //현재까지(queue에서 현재 꺼내온 값이) 벽을 통과한 적이 없으면
                        queue.add(new Position(nextR, nextC, cnt, false));
                        vis[0][nextR][nextC] = true;
                    } else if (cur.destroyed && !vis[1][nextR][nextC]) {    //벽을 통과한 적이 있으면
                        queue.add(new Position(nextR, nextC, cnt, true));
                        vis[1][nextR][nextC] = true;
                    }
                } else if (map[nextR][nextC] == 1 && !cur.destroyed) {  //벽일 경우 -> 이미 벽을 부순 적이 있으면 또 못부숨
                    queue.add(new Position(nextR, nextC, cnt, true));
                    vis[1][nextR][nextC] = true;
                }
            }
        }

        return -1;
    }

    static class Position {
        int r, c, cnt;
        boolean destroyed;

        public Position(int r, int c, int cnt, boolean destroyed) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.destroyed = destroyed;
        }
    }
}
