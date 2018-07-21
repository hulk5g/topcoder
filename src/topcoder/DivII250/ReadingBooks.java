package topcoder.DivII250;

/**
 * @author ksharma
 */
public class ReadingBooks {

    public int countBooks(String[] readParts){
        int []a=new int[3];
        int count=0;
        for(String s:readParts){
            switch (s){
                case "introduction":
                    a[0]++;
                    break;
                case "story":
                    a[1]++;
                    break;
                case "edification":
                    a[2]++;
                    break;
            }
        }
        while(true){
            if(a[0]!=0 && a[1]!=0 && a[2]!=0){
                count++;
                a[0]--;a[1]--;a[2]--;
            }else{
                break;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        ReadingBooks rb=new ReadingBooks();

        System.out.println(rb.countBooks(new String[]{"introduction", "story", "edification", "introduction", "story", "edification"}));
    }
}
