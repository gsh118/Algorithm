import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        n++;
        while (n>0){
           int cur = n%2==0?4:7;
           list.add(cur);
           n/=2;
        }

        Collections.reverse(list);

        for (int i=1; i<list.size(); i++){
            bw.write(list.get(i)+"");
        }
        bw.close();
    }
}