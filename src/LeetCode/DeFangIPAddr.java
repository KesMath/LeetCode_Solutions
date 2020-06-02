package LeetCode;

import java.lang.StringBuilder;
import java.lang.Integer;

public class DeFangIPAddr {
    public static String defangIPaddr(String address) {
        char[] charArray = address.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i<charArray.length; i++){
            if (charArray[i] == '.'){
                builder.append("[.]");

            }
            else{
                builder.append(charArray[i]);
            }
        }
        return builder.toString();
    }


    public static void main(String[] args) {
        String address = "255.100.50.0";
        System.out.println(DeFangIPAddr.defangIPaddr(address));
    }
}
