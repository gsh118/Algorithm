import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str;
        int i=1;
        while((str=br.readLine()).charAt(0)!='-'){
            Solver solver = new Solver(str);
            bw.write(i+". "+solver.getMinOperation()+"\n");
            i++;
        }

        br.close();
        bw.close();
    }
}

class Solver{
    int cnt;
    char[] arr;
    Deque<Character> dq;

    public Solver(String s){
        arr=s.toCharArray();
        dq =new ArrayDeque<>();
    }

    public int getMinOperation(){
        for (char c : arr) {
            if (c == '}') {
                if (dq.isEmpty()) {
                    cnt++;
                    dq.addLast('{');
                } else {
                    dq.removeLast();
                }
            } else {
                dq.addLast('{');
            }
        }

        while(!dq.isEmpty()){
             dq.removeLast();
             dq.removeLast();
             cnt++;
        }

        return cnt;
    }
}