import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        System.out.println(getFibonacciByMatrix(n));
    }

    public static long getFibonacciByMatrix(long n){
        long[][] mulArr = {{1L, 1L}, {1L, 0L}};
        long[][] firstTermArr = {{1L},{0L}};

        CustomMatrix mul = CustomMatrix.of(mulArr);
        CustomMatrix firstTerm = CustomMatrix.of(firstTermArr);

        CustomMatrix resultMat = mul.exp(n).multiply(firstTerm);
        return resultMat.getPos(1,0);
    }
}

class CustomMatrix{
    long[][] mat;
    long remainder=1000000;

    static CustomMatrix of(long[][] mat){
        return new CustomMatrix(mat);
    }

    public long getPos(int x, int y){
        return mat[x][y];
    }

    private CustomMatrix(long[][] mat){
        this.mat=mat;
    }

    public CustomMatrix multiply(CustomMatrix b){
        int r=mat.length;
        int h=mat[0].length;
        int c=b.mat[0].length;

        long[][] newMat = new long[r][c];

        for (int i=0; i<r; i++){
            for (int j=0; j<c; j++){
                for (int k=0; k<h; k++){
                    newMat[i][j] += (mat[i][k]*b.mat[k][j]);
                    newMat[i][j] %= remainder;
                }
            }
        }

        return CustomMatrix.of(newMat);
    }

    public CustomMatrix exp(long pow){
        if (pow==1){
            return this;
        }

        if(pow%2==1){
            return this.multiply(exp(pow-1));
        }

        CustomMatrix sqrtMat = exp(pow/2);
        return sqrtMat.multiply(sqrtMat);
    }
}