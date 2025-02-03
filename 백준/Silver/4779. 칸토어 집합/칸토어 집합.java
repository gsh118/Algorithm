import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try{
            while(true){
                int n=Integer.parseInt(br.readLine());

                CantorSet set = new CantorSet((int)Math.pow(3,n));
                bw.write(set.getResult()+"\n");
            }
        } catch(Exception e){
            br.close();
            bw.close();
        }
    }
}

class CantorSet{
    char[] arr;
    String result;

    public CantorSet(int l){
        arr= new char[l];
        for (int i=0; i<l; i++){
            arr[i]='-';
        }
    }

    public String getResult(){
        if(result==null){
            eraseArrayMid(0, arr.length);
            result = new String(arr);
        }

        return result;
    }

    private void eraseArrayMid(int start, int end){
        int dist = end-start+1;
        if(dist<3){
            return;
        }

        for (int i=start+dist/3; i<start+dist/3*2; i++){
            arr[i]=' ';
        }

        eraseArrayMid(start, start+dist/3);
        eraseArrayMid(start+dist/3*2, end);
    }
}