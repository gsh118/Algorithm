import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        String y = sc.nextLine();

        LCS solver = new LCS(x,y);
        System.out.println(solver.getLcsLength());
    }
}

class LCS{
    char[] x;
    char[] y;
    int[][] lenDp;

    public LCS(String x, String y){
        this.x=x.toCharArray();
        this.y=y.toCharArray();
        lenDp=new int[this.x.length+1][this.y.length+1];
    }

    public int getLcsLength(){
        int xLen = x.length;
        int yLen = y.length;

        for (int i=1; i<=xLen; i++){
            for (int j=1; j<=yLen; j++){
                //현재 인덱스 글자가 같은지
                if(x[i-1]==y[j-1]){
                    lenDp[i][j]=lenDp[i-1][j-1]+1;
                } else{
                    lenDp[i][j]=Math.max(lenDp[i][j-1],lenDp[i-1][j]);
                }
            }
        }
        return lenDp[xLen][yLen];
    }
}