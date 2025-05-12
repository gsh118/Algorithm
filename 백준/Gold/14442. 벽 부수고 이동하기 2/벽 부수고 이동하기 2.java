import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][][] dist = new int[n][m][k+1];
        boolean[][] isWall = new boolean[n][m];

        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            char[] tmp = st.nextToken().toCharArray();
            for (int j=0; j<m; j++){
                isWall[i][j] = tmp[j]=='1';
            }
        }

        br.close();

        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[]{0,0,0});
        dist[0][0][0] = 1;

        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        while(!qu.isEmpty()){
            int[] cur = qu.remove();

            for (int i=0; i<4; i++){
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=m){
                    continue;
                }

                int nz = isWall[nx][ny]? cur[2]+1: cur[2];
                if(nz>k){
                    continue;
                }

                int tmpDist = dist[cur[0]][cur[1]][cur[2]]+1;
                boolean flag = false;

                for (int h=0; h<=nz; h++){
                    if(0<dist[nx][ny][h] && dist[nx][ny][h]<=tmpDist){
                        flag=true;
                        break;
                    }
                }

                if(flag){
                    continue;
                }

                dist[nx][ny][nz] = tmpDist;
                qu.add(new int[]{nx,ny,nz});
            }
        }

        int result=Integer.MAX_VALUE;
        for (int e:dist[n-1][m-1]){
            if(0<e && e<result){
                result=e;
            }
        }

        if(result==Integer.MAX_VALUE){
            result=-1;
        }

        System.out.println(result);
    }
}