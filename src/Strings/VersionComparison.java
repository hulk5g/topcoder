package Strings;

/**
 * @author ksharma
 */
public class VersionComparison {
    public int compareVersion(String version1, String version2) {

        String []arr1=version1.split("\\.");
        String []arr2=version2.split("\\.");
        int i=0;
        while(i< arr1.length || i< arr2.length){
            int a=i<arr1.length ? Integer.parseInt(arr1[i]):0;
            int b=i<arr2.length ? Integer.parseInt(arr2[i]):0;

        }
        if(i==arr1.length && i==arr2.length)return 0;
        return i==arr2.length?1:-1;

    }

    public static  void main(String []args){
        VersionComparison vc=new VersionComparison();
        System.out.println(vc.compareVersion("0.1","0.1"));
    }
}
