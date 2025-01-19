import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long n=sc.nextLong();

        long result = (long)Math.pow((long)Math.pow(2,n)+1, 2);
        System.out.println(result);
    }
}