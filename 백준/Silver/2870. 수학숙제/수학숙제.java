import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        ArrayList<String> input= new ArrayList<>();
        for (int i=0; i<n; i++){
            input.add(br.readLine());
        }

        ArrayList<BigInteger> outputs = new ArrayList<>();

        for (var str:input){
            outputs = (ArrayList<BigInteger>) Stream.concat(outputs.stream(), extractInt(str).stream())
                    .collect(Collectors.toList());
        }

        outputs.stream().sorted().forEach((i)-> {
            try {
                bw.write(i + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        bw.close();
    }

    public static ArrayList<BigInteger> extractInt(String str){
        ArrayList<BigInteger> integers = new ArrayList<>();

        int i=0;
        char[] chars=str.toCharArray();
        while(i<chars.length){
            BigInteger cur=new BigInteger("0");
            if(chars[i]>'9' || chars[i]<'0'){
                i++;
                continue;
            }

            while(i<chars.length && '0'<=chars[i] && chars[i]<='9'){
                cur = cur.multiply(new BigInteger("10"));
                cur = cur.add(new BigInteger(chars[i]-'0'+""));
                i++;
            }

            integers.add(cur);
        }
        return integers;
    }
}