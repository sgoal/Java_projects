package leetcode.again;

public class ToHex {
    public String toHex(int num) {
    	if(num==0)return "";
        String HEX0 = "0123456789abcdef";
        char[] HEX = HEX0.toCharArray();
        StringBuilder sb = new StringBuilder(8);
        while(num!=0 && sb.length()<8) {
        	sb.append(HEX[num&0xf]);
        	num = num>>4;
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
		ToHex toHex = new ToHex();
		System.out.println(toHex.toHex(-1));
		System.out.println(toHex.toHex(26));
	}
}
