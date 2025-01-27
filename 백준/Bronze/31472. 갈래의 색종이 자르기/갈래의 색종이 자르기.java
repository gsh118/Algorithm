import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int e=0;
        while(e*e<2*w){
            e+=2;
        }
        System.out.println(4*e);
    }
}