package topcoder.DivII500;

import java.util.Arrays;
import java.util.Map;

/**
 * @author ksharma
 */
public class SentenceDecomposition {
    int large=100000;

    public int decompose(String sentence, String[] validWords){
        int n=sentence.length();
        int[]dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0;i<n;i++){
            if(dp[i]< Integer.MAX_VALUE){
                for(String s:validWords){
                    if(i+s.length()<=n &&
                            isAnagram(s,sentence.substring(i,i+s.length()))){
                        dp[i+s.length()]=Math.min(dp[i+s.length()],getCost(s,sentence.substring(i,i+s.length()))+dp[i]);
                    }
                }
            }
        }
       // int result=helper(sentence,validWords,hm);
        if(dp[n]==Integer.MAX_VALUE)return -1;
        return dp[n];
    }

    public int helper(String sen,String []dict,Map<String, Integer>hm){
        if(sen.isEmpty()){
            return 0;
        }
        if(hm.containsKey(sen) && hm.get(sen)!=large){
            return hm.get(sen);
        }
        int totalCost=large;
        for(int j=0;j<dict.length;j++){
            String s1=dict[j];
            String s2=sen.substring(0,s1.length()>sen.length()?sen.length():s1.length());
            if(isAnagram(s1,s2)){
                String s3=sen.substring(s1.length());
                int temp=getCost(s1,s2)+helper(s3,dict,hm);
                totalCost=Math.min(totalCost,temp);
            }
        }
        hm.put(sen,totalCost);
        return hm.get(sen);
    }

    private int getCost(String s1, String s2) {
        int count=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i))count++;
        }
        return count;
    }

    private boolean isAnagram(String s1, String s2) {
        char[] arr1=s1.toCharArray();
        char[] arr2=s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        SentenceDecomposition sd=new SentenceDecomposition();
        System.out.println(sd.decompose(				"jysohnwxsooodfmrhxczrqowxhgggbbilajwxnf", new String[]{"sibgcskjutlofvhxslgscmcrhgatmxppytqljufemk", "yfnninipoetesuazbqtzax", "cogyxdiuhzwnxrdzuumepiifw", "bqze", "bhgxrbjfmchgxosjhowoyaozogslwdinrxq", "bjgakyklvayvwnzugwicjebjaxupozvydnaoi", "qtdquxfqyooylvzhp", "maxfkjprcq", "ffhcvrlutjszyfnqszwqunhlbaajfxwtxoxgdumvqwonaxe", "ogiwxxqybfzalgosdnwojsrwhbhoxmjcxfnoghr", "chzaxzylamfvnfpdsnxtwiqqdm", "zmfmiinnjygignaipkvnnkrcyswrvhlzqiotxyhsqwnpxcskn", "quirtnfpimjhimgqxmeovgpvepfnqhvogyucjhfa", "bwwqxyg", "hlmlijjznobueqgisdudhwuojjkohhrvqeevtuqvqfytr", "fuwnhbbwntujt", "qbtrhldvzgsraupriauhccrqtphcdlfufczjvuwknqgazexhh", "inplmvzdwiduhrgttzppwkcvj", "oondfjlyjfyzda", "gblagwbjfngxi", "txtoet", "zozvqtoayrtmhwhqkzbxlg", "wlglxukxngchcpgwhqgqzzt", "lbxqzjgdctmchspyzlpwj", "nvt", "geerdimhpwcbblnzmaxztbosrjxbhgqjwqtojiwyj", "wxajphlkazwvoacndddxorrgtsawnyfokzvgy", "lkwomzqhwzqxskhneoovqzwwyhfhtfiahcauuwdrzmavvyk", "osonxswoxhorhjmyfd", "kyffbdoxhjqifgskepdqw", "mpkrkbyhygefghm", "ewtoxzlfcueidgiklsgkwgnuvsowuzwewgusjprojuzptsjjw", "xwnf", "qmlgxmjkvarufgzyeciymrwlhhehirkwrtkzwy", "bomwhmtywcxhfitjgdpasozvullhgpqnjjjkrvximd", "ttmredxydrlomqjhkkjaumi", "aferhpniczuqji", "kxqpkmfpphbbzfzngknuaumofwurojkaifgqgvtnugx", "zyixcktalnzqyvdn", "xrohzwcq", "cchpbsjdzeilrdyeprshmxqwzrsvccwyamixojxtozt", "sv", "zxnaekdqgkdlopjvyytqypqtoiyjv"}

        ));
    }
}
