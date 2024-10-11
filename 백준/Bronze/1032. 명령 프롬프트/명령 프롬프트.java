import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        String[] arr = new String[n];
        for (int i=0; i<n; i++){
            arr[i]=sc.nextLine();
        }

        String rst=arr[0];
        for (int i=0; i<arr[0].length(); i++){
            for (int j=0; j<n; j++){
                if(arr[0].charAt(i)!=arr[j].charAt(i)){
                    rst = rst.substring(0,i)+"?"+rst.substring(i+1,arr[0].length());
                    break;
                }
            }
        }

        System.out.println(rst);
    }
}