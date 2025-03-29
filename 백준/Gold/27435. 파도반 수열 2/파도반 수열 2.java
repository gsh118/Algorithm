import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int i=0; i<t; i++){
            long n = Long.parseLong(br.readLine());
            bw.write(getPadovan(n)+"\n");
        }
        br.close();
        bw.close();
    }

    public static long getPadovan(long n){
        long exp = (n+1)/2-1;

        int[][] arr = {{1,1,0},{0,1,1},{1,0,0}};
        Matrix m = Matrix.of(arr);

        int[][] init = {{1},{1},{1}};
        Matrix padovanMat = m.pow(exp).mul(Matrix.of(init));

        return padovanMat.getPos((int)(n%2+1),0);
    }
}

class Matrix{
    long[][] arr;
    final long mod = 998_244_353;

    Matrix(long[][] arr){
        this.arr = arr;
    }

    long getPos(int x, int y){
        return arr[x][y];
    }

    public static Matrix identity(int size){
        long[][] arr = new long[size][size];

        for (int i=0; i<size; i++){
            arr[i][i]=1;
        }

        return new Matrix(arr);
    }

    public static Matrix of(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;

        long[][] newArr = new long[n][m];

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                newArr[i][j] = arr[i][j];
            }
        }
        return new Matrix(newArr);
    }

    public Matrix mul(Matrix other){
        int n = arr.length;
        int m = arr[0].length;
        int k = other.arr[0].length;
        long[][] newArr = new long[n][k];

        for (int i=0; i<n; i++){
            for (int j=0; j<k; j++){
                for (int l=0; l<m; l++){
                    newArr[i][j] += arr[i][l]*other.arr[l][j];
                    newArr[i][j]%=mod;
                }
            }
        }

        return new Matrix(newArr);
    }

    public Matrix pow(long exp){
        if(exp==0){
            return Matrix.identity(3);
        }

        if(exp==1){
            return this;
        }

        if(exp%2==1){
            return this.mul(pow(exp-1));
        }

        Matrix tmp = pow(exp/2);
        return tmp.mul(tmp);
    }
}