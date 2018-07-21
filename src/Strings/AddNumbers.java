package Strings;

/**
 * @author ksharma
 */
public class AddNumbers {
    public String addStrings(String num1, String num2) {
        int carry=0;
        StringBuilder sb=new StringBuilder();
        int s1=num1.length()-1;
        int s2=num2.length()-1;
        while(s1>=0 && s2>=0){
            int c1=num1.charAt(s1)-'0';
            int c2=num2.charAt(s2)-'0';
            int temp=c1+c2+carry;
            sb.append(temp%10);
            carry=0;
            carry=temp/10;
            s1--;
            s2--;
        }
        while(s1>=0){
            int temp=num1.charAt(s1)-'0' +carry;
            sb.append(temp%10);
            carry=0;
            carry=temp/10;
            s1--;
        }
        while(s2>=0){
            int temp=num2.charAt(s2)-'0' +carry;
            sb.append(temp%10);
            carry=0;
            carry=temp/10;
            s2--;
        }
        if(carry!=0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static void main(String []args){
        AddNumbers num=new AddNumbers();
        System.out.println(num.addStrings("999","9"));
    }
}
