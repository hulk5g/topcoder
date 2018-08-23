package topcoder.DivII500;

/**
 * @author ksharma
 */
public class HuffmanDecoding {

    public 	String decode(String archive, String[] dictionary){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<dictionary.length;i++){
            if(archive.startsWith(dictionary[i])){
                String remainder=archive.substring(dictionary[i].length());
                sb.append((char) (i+'A'));
                sb.append(decode(remainder,dictionary));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        HuffmanDecoding hd=new HuffmanDecoding();
        System.out.println(hd.decode("001101100101100110111101011001011001010",
        new String[]{"110","011","10","0011","00011","111","00010","0010","010","0000"}));
    }
}
