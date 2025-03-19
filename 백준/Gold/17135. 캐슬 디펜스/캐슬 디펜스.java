import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] ipt = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<3; i++){
            ipt[i] = Integer.parseInt(st.nextToken());
        }

        int[][] arr = new int[ipt[0]][ipt[1]];

        for (int i=0; i<arr.length; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<arr[i].length; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        CastleDefense cd = new CastleDefense(
                ipt[0], ipt[1], ipt[2], arr
        );

        int result = cd.getMaxKills();
        System.out.println(result);
    }
}

class CastleDefense {
    int n;
    int m;
    int d;
    int[][] arr;

    public CastleDefense(int n, int m, int d, int[][] arr) {
        this.n = n;
        this.m = m;
        this.d = d;
        this.arr = arr;
    }
    
    public int getMaxKills(){
        int max=0;
        // 궁수 조합
        for (int i=0; i<m-2; i++){
            for (int j=i+1; j<m-1; j++){
                for (int k=j+1; k<m; k++){
                    int curCnt = findKillCountByArcher(new int[] {i,j,k});
                    max = Math.max(curCnt, max);
                }
            }
        }

        return max;
    }

    int findKillCountByArcher(int[] archers){
        List<int[]> enemies = new ArrayList<>();
        int killCount=0;

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if(arr[i][j]==1){
                    enemies.add(new int[]{i,j});
                }
            }
        }

        while(!enemies.isEmpty()){
            Map<int[], Integer> killedMap = new HashMap<>();
            for (int[] enemy:enemies){
                killedMap.put(enemy, 0);
            }

            //궁수가 제거할 좀비 찾기
            for (int archer:archers){
                int dist = d+1;
                int[] toDel = null;
                for (int[] enemy: enemies){
                    int curDist = n-enemy[0]+Math.abs(archer- enemy[1]);
                    if(curDist>d)
                        continue;

                    if(curDist<dist){
                        dist=curDist;
                        toDel = enemy;
                    } else if(curDist==dist){
                        if(toDel==null|| enemy[1]<toDel[1]){
                            toDel = enemy;
                        }
                    }
                }
                if (dist<=d){
                    killedMap.put(toDel, killedMap.get(toDel)+1);
                }
            }

            // 제거할 좀비와 남길 좀비 선택
            List<int[]> tmp = new ArrayList<>();
            for (int[] enemy:killedMap.keySet()){
                if(killedMap.get(enemy)==0){
                    if(enemy[0]==n-1){
                        //성에 도착
                        continue;
                    } else{
                        enemy[0]++;
                        tmp.add(enemy);
                    }
                } else{
                    killCount++;
                }
            }
            enemies = tmp;
        }
        
        return killCount;
    }
}