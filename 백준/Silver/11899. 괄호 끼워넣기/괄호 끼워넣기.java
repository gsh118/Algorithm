import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(minAddBrackets(str));
    }

    public static int minAddBrackets(String s){
        int toAdd=0;
        int opCount=0;
        char[] arr=s.toCharArray();

        for (char c:arr){
            if(c=='('){
                opCount++;
            } else if(opCount>0){
                opCount--;
            } else{
                toAdd++;
            }
        }

        toAdd+=opCount;
        return toAdd;
    }
}