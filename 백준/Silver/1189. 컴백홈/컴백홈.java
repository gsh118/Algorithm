import java.util.*;

class Main{
    static int cnt=0;
    static int[][] arr;
    static int k;
    static int[] dx={1,0,-1,0};
    static int[] dy={0,1,0,-1};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int r=sc.nextInt();
        int c=sc.nextInt();
        k=sc.nextInt();
        sc.nextLine();

        arr = new int[r][c];

        for (int i=0; i<r; i++){
            char[] tmp = sc.nextLine().toCharArray();
            for (int j=0; j<c; j++){
                if(tmp[j]=='T'){
                    arr[i][j]=-1;
                }
            }
        }

        arr[r-1][0]=1;
        dfs(arr, r-1, 0);

        System.out.println(cnt);
    }

    public static void dfs(int[][] arr, int x, int y){
        int r=arr.length;
        int c=arr[0].length;
        if(x==0 && y==c-1){
            if(arr[x][y]==k){
                cnt++;
            }
            return;
        }

        for (int i=0; i<4; i++){
            int nx=x+dx[i];
            int ny=y+dy[i];

            if (nx<0 || nx>=r || ny<0 || ny>=c){
                continue;
            }

            if(arr[nx][ny]!=0){
                continue;
            }

            arr[nx][ny]=arr[x][y]+1;
            dfs(arr, nx, ny);
            arr[nx][ny]=0;
        }
    }
}