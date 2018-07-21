/**
 * @author ksharma
 */
public class KthGrammar {
    public int kthGrammar(int N, int K) {

        String s="0";
        for(int i=0;i<N;i++){
            if(s.endsWith("0")){
                String temp=s.substring(0);
                char[] tempArray=temp.toCharArray();
                for(int j=0;j<tempArray.length;j++){
                    if(tempArray[j]=='0'){
                        tempArray[j]='1';
                    }else{
                        tempArray[j]='0';
                    }
                }

                s=s.concat(String.valueOf(tempArray));

            }else{
                String temp=s.substring(0);
                char[] tempArray=temp.toCharArray();
                int start=0,end=tempArray.length-1;
                while(start<end){
                    char t=tempArray[start];
                    tempArray[start]=tempArray[end];
                    tempArray[end]=t;
                    start++;
                    end--;
                }

                s=s.concat(String.valueOf(tempArray));

            }

        }
        char c=s.charAt(K-1);
        return Character.getNumericValue(c);
    }

    public static void main(String []args){
        int i[]=new int[]{1,2};
        KthGrammar k=new KthGrammar();
        System.out.println(k.kthGrammar(2,2));

    }
}
