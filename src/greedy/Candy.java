package greedy;

import java.util.Arrays;

/**
 * @author ksharma
 */
public class Candy {
    public int candy(int[] ratings) {
        int []count=new int[ratings.length];
        Arrays.fill(count,1);
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1] && count[i]<=count[i-1]){
                count[i]=count[i-1]+1;
            }
        }

        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1] && count[i]<=count[i+1]){
                count[i]=count[i+1]+1;
            }
        }
        int n=Arrays.stream(count).sum();
        return n;
    }

    public static void main(String []args){
        Candy c=new Candy();
        int []rating={1,2,2};
        System.out.println(c.candy(rating));
    }
}
