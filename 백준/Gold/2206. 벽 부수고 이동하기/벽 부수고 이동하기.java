import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] wallMap = new char[n][m];
        for (int i=0; i<n; i++){
            char[] tmp = br.readLine().toCharArray();
            for (int j=0; j<m; j++){
                wallMap[i][j]=tmp[j];
            }
        }
        br.close();
        
        System.out.println(calcMinDist(wallMap));
    }

    public static int calcMinDist(char[][] wallMap){
        int n = wallMap.length;
        int m = wallMap[0].length;
        int over = 10000000;

        int[][][] dist = new int[2][n][m];
        for (int[][] tmp:dist){
            for (int[] arr:tmp){
                Arrays.fill(arr, over);
            }
        }

        int[] dx={1,0,-1,0};
        int[] dy={0,1,0,-1};

        Queue<Pair> qu = new LinkedList<>();
        dist[0][0][0]=1;
        qu.add(new Pair(0,0,0));

        while (!qu.isEmpty()){

            Pair p = qu.remove();
            int curX=p.x;
            int curY=p.y;
            int curC=p.c;

            for (int i=0; i<4; i++){
                int nx=curX+dx[i];
                int ny=curY+dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=m){
                    continue;
                }

                if (curC==1 && wallMap[nx][ny]=='1'){
                    continue;
                }

                int nc = wallMap[nx][ny]=='1'? curC+1 : curC;

                if(dist[nc][nx][ny]>dist[curC][curX][curY]+1){
                    dist[nc][nx][ny]=dist[curC][curX][curY]+1;
                    qu.add(new Pair(nc,nx,ny));
                }
            }
        }

        int candidate = Math.min(dist[0][n-1][m-1], dist[1][n-1][m-1]);
        return candidate<over? candidate:-1;
    }
}

class Pair{
    int x;
    int y;
    int c;
    public Pair(int c, int x, int y){
        this.x=x;
        this.y=y;
        this.c=c;
    }
}