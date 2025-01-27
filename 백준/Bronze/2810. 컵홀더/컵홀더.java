import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        char[] c = sc.nextLine().toCharArray();
        int i=0;
        int holder=0;
        while(i<c.length){
            holder+=1;
            if(c[i]=='S'){
                i+=1;
            } else{
                i+=2;
            }
        }
        holder+=1;
        System.out.println(Math.min(holder,n));
    }
}