import java.util.Arrays;
import java.util.Scanner;

public class FightTheMonster {

        static int getMaxMonsters(int n, int hit, int t, int[] h){
            Arrays.sort(h);
            int count=0;
            int i=0;
            for(i=0;i<h.length;i++){
                if(count==t){
                    break;
                }
                if(h[i]<=hit){
                    count++;
                    continue;
                }
                int div=h[i]/hit;
                int remainder=h[i]%hit;
                int stepsToKill=0;
                if(remainder==0){
                    stepsToKill=div;
                }else{
                    stepsToKill=div+1;
                }
                if((count+stepsToKill)>t){
                    return i;
                }
                count=count+stepsToKill;

            }
            return i;
        }

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int hit = in.nextInt();
            int t = in.nextInt();
            int[] h = new int[n];
            for(int h_i=0; h_i < n; h_i++){
                h[h_i] = in.nextInt();
            }
            int result = getMaxMonsters(n, hit, t, h);
            System.out.println(result);
        }
    }


