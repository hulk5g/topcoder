package topcoder.DivII500;

/**
 * @author ksharma
 */
public class FolderSize {
    public int[] calculateWaste(String[] files, int folderCount, int clusterSize){
        int[]result=new int[folderCount];
        for(String s:files){
            String[]file=s.split(" ");
            int fSize=Integer.parseInt(file[1]);
            result[Integer.parseInt(file[0])]+=clusterSize-(fSize%clusterSize);
        }
        return result;
    }

    public static void main(String[] args) {
        FolderSize fs=new FolderSize();
        System.out.println(fs.calculateWaste(new String[]{"0 93842", "1 493784", "2 43212", "3 99327", "4 456209",
                "5 947243", "6 59348", "7 58237", "8 5834", "9 492384",
                "0 58342", "3 538432", "6 1432", "9 453983", "2 4321",
                "4 583729", "6 6974", "8 9864", "4 43211", "8 38437"},10,22485));
    }
}
