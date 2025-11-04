import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int[][] board;
    private static List<int[]> zeros;

    private static boolean dfs(int depth) {
        if (depth == zeros.size()) return true;
        
        int[] position = zeros.get(depth);
        
        int r = position[0], c = position[1];
        int boxR = (r / 3) * 3, boxC = (c / 3) * 3;

        for (int n=1; n<=9; n++) {
            boolean canFilled = true;
            
            for (int i=boxR; i<boxR + 3; i++) {
                for (int j=boxC; j<boxC + 3; j++) {
                    if (board[i][j] == n) {
                        canFilled = false;
                        break;
                    }
                }
            }

            for (int i=0; i<9; i++) {
                if (!canFilled || board[position[0]][i] == n || board[i][position[1]] == n) {
                    canFilled = false;
                    break;
                }
            }

            if (canFilled) {
                board[position[0]][position[1]] = n;
                if (dfs(depth + 1)) return true;
                board[position[0]][position[1]] = 0;
            }
        }

        return false;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board = new int[9][9];
        zeros = new LinkedList<>();

        for (int r=0; r<9; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c=0; c<9; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());

                if (board[r][c] == 0)
                    zeros.add(new int[]{r, c});
            }
        }

        br.close();
    }

    private static void process() {
        StringBuilder answer = new StringBuilder();

        dfs(0);

        for (int r=0; r<9; r++) {
            for (int c=0; c<9; c++) {
                answer.append(board[r][c]).append(" ");
            }
            answer.append("\n");
        }

        System.out.println(answer.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
