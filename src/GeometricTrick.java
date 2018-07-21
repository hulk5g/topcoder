import java.util.*;

/**
 * Created by ksharma on 5/18/17.
 */
public class GeometricTrick {

    static int geometricTrick(String s){
        List<Integer> aList=new ArrayList<>();
        List<Integer> bList=new ArrayList<>();
        Map<Integer,Boolean> cMap=new HashMap<>();
        Set<String> resultSet=new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a'){
                aList.add(i);
            }else if(s.charAt(i)=='b'){
                bList.add(i);
            }else{
                cMap.put(i,true);
            }
        }
        for(int i=0;i<aList.size();i++){
            for(int j=0;j<bList.size();j++){
                int c=(((bList.get(j)+1)*(bList.get(j)+1) -(aList.get(i)+1))/(aList.get(i)+1));
                int remainder=(((bList.get(j)+1)*(bList.get(j)+1) -(aList.get(i)+1))%(aList.get(i)+1));
                if(remainder==0 && cMap.get(c)!=null){
                    resultSet.add(String.valueOf(aList.get(i))+String.valueOf(bList.get(j))+String.valueOf(c));
                }
            }
        }
        return resultSet.size();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int result = geometricTrick(s);
        System.out.println(result);

    }
}
