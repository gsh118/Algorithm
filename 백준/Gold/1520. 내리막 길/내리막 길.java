import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        Board board = new Board(m,n);

        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                board.setPositionValue(i,j,Integer.parseInt(st.nextToken()));
            }
        }

        br.close();

        int solution = board.countNumberOfRoads();
        bw.write(""+solution);
        bw.close();
    }
}

class Board{
    int[][] board;
    int[][] dp;
    boolean[][] isVisited;
    int row;
    int col;

    int[] dx={0,1,0,-1};
    int[] dy={1,0,-1,0};

    public Board(int r, int c) {
        this.row=r;
        this.col=c;
        this.board = new int[r][c];
        this.isVisited = new boolean[r][c];
        this.dp = new int[r][c];
    }

    public void setPositionValue(int r, int c, int val){
        board[r][c]=val;
    }

    public int countNumberOfRoads(){
        dp[row-1][col-1]=1;
        isVisited[row-1][col-1]=true;
        return countNumberByPosition(0,0);
    }

    private int countNumberByPosition(int x, int y){
        if(!isInBoard(x,y))
            return 0;
        
        if(isVisited[x][y])
            return dp[x][y];

        for (int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if (isValidNeighborhood(x,y,nx,ny))
                dp[x][y]+=countNumberByPosition(nx,ny);
        }

        isVisited[x][y]=true;
        return dp[x][y];
    }
    
    private boolean isInBoard(int x, int y){
        return x>=0 && x<row && y>=0 && y<col;
    }

    private boolean isValidNeighborhood(int x, int y, int nx, int ny){
        return isInBoard(nx,ny)
                && (board[x][y]>board[nx][ny]);
    }
}