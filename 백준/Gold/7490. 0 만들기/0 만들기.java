import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i=0; i<t; i++){
            int n = sc.nextInt();
            ExpressMaker em = new ExpressMaker(n);
            List<String> list = em.getZeroSumList();
            list.forEach(System.out::println);
            System.out.println();
        }
    }
}

class ExpressMaker{
    int n;
    int[] arr;
    int cnt;
    char[] opComb;
    char[] op = {' ', '+', '-'};
    List<String> zeroSumList;

    public ExpressMaker(int n){
        this.n = n;
        arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = i+1;
        }
        opComb = new char[n-1];
        zeroSumList = new ArrayList<>();
    }

    public List<String> getZeroSumList(){
        findAndCheckAllOperation(0);
        return zeroSumList;
    }

    void findAndCheckAllOperation(int idx){
        if(idx==opComb.length){
            if(calcSum()==0){
                StringBuilder sb = new StringBuilder("1");
                for (int i=0; i<opComb.length; i++){
                    sb.append(opComb[i]);
                    sb.append(arr[i+1]);
                }
                zeroSumList.add(sb.toString());
            }
            return;
        }

        for (int i=0; i<3; i++){
            opComb[idx]=op[i];
            findAndCheckAllOperation(idx+1);
        }
    }

    int calcSum(){
        List<Integer> numbers = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        int numIdx=0;
        for (int opIdx=0; opIdx<opComb.length; opIdx++){
            if(opComb[opIdx]==' '){
                continue;
            }

            ops.add(opComb[opIdx]);
            int current=0;
            while(numIdx<=opIdx){
                current = current * 10 + arr[numIdx++];
            }
            numbers.add(current);
        }

        int current=0;
        while (numIdx<arr.length){
            current = current * 10+arr[numIdx++];
        }
        numbers.add(current);

        int sum = numbers.get(0);
        for (int i=0; i<ops.size(); i++){
            if(ops.get(i)=='+'){
                sum+=numbers.get(i+1);
            } else{
                sum-=numbers.get(i+1);
            }
        }

        return sum;
    }
}