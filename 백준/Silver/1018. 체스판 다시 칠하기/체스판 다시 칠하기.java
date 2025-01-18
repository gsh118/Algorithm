import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] boardArr=new char[n][m];

        for (int i=0; i<n; i++){
            char[] boardLine = br.readLine().toCharArray();
            for (int j=0; j<m; j++){
                boardArr[i][j] = boardLine[j];
            }
        }
        br.close();

        Board board = new Board(boardArr);
        int minChangeColor=board.countMinChangeColor();

        bw.write(""+minChangeColor);
        bw.close();
    }
}

class Board{
    private char[][] board;

    public Board(char[][] board){
        this.board = board;
    }

    public int countMinChangeColor(){
        int row=board.length;
        int col=board[0].length;
        int minCount=row*col+1;

        for (int i=0; i+7<row; i++){
            for (int j=0; j+7<col; j++){
                int curCount = countChangeColorWhenFixStart(i,j);

                if(curCount<minCount){
                    minCount=curCount;
                }
            }
        }
        return minCount;
    }

    public int countChangeColorWhenFixStart(int r, int c){
        int unvalidCount = 0;

        for (int i=r; i<r+8; i++){
            for (int j=c; j<c+8; j++){
                if(!isValidColor(r,c,i,j)){
                    unvalidCount++;
                }
            }
        }
        if (unvalidCount>32){
            unvalidCount=64-unvalidCount;
        }

        return unvalidCount;
    }

    public boolean isValidColor(int startRow, int startCol, int curRow, int curCol){
        return haveSameColor(startRow, startCol, curRow, curCol)
                == (board[startRow][startCol] == board[curRow][curCol]);
    }

    public boolean haveSameColor(int firstRow, int firstCol, int secondRow, int secondCol){
        return (secondRow+secondCol-firstRow-firstCol)%2==0;
    }
}