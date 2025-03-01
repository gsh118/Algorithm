import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [][] arr = new int[n][n];
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int [][] areaSumArr = makeAreaSum(arr);

        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int[] p = new int[4];
            for (int j=0; j<4; j++){
                p[j] = Integer.parseInt(st.nextToken());
            }

            bw.write(findAreaVal(areaSumArr, p[0],p[2],p[1],p[3])+"\n");
        }

        br.close();
        bw.close();
    }

    public static int getVal(int[][] arr, int x, int y){
        int n = arr.length;
        if(x<0||x>=n||y<0||y>=n){
            return 0;
        }
        return arr[x][y];
    }

    public static int findAreaVal(int[][] arr, int x1, int x2, int y1, int y2){
        return getVal(arr,x2-1,y2-1)-getVal(arr,x1-2,y2-1)-getVal(arr,x2-1,y1-2)
                +getVal(arr, x1-2,y1-2);
    }

    public static int[][] makeAreaSum(int[][] arr){
        int n = arr.length;
        int [][] area = new int[n][n];

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                area[i][j]=arr[i][j]
                        +getVal(area, i-1,j)+getVal(area, i, j-1)-getVal(area,i-1,j-1);
            }
        }

        return area;
    }
}