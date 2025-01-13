import java.util.Scanner;

public class Main {

    static int nextIndex(String[] strList){
        for (int i=0; i<strList.length; i++){
            char letter = strList[i].toCharArray()[0];

            if('0'<=letter && letter<='9')  {
                return Integer.parseInt(strList[i])+3-i;
            }
        }
        return 0;
    }

    static String getFizzBuzzWord(int n){
        if (n%15==0)
            return "FizzBuzz";
        if (n%3==0)
            return "Fizz";
        if (n%5==0)
            return "Buzz";
        return n+"";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strList = new String[3];

        for (int i=0; i<3; i++){
            strList[i] = sc.nextLine();
        }

        int nextNumber = nextIndex(strList);
        System.out.println(getFizzBuzzWord(nextNumber));
    }
}