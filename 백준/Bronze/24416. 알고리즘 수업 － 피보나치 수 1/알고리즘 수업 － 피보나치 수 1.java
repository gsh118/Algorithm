import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] callCount = new long[n+1];
        callCount[1]=1;
        callCount[2]=1;
        for (int i=3; i<=n; i++)
            callCount[i]=callCount[i-1]+callCount[i-2];

        System.out.println(callCount[n] + " " + (n-2));
    }
}