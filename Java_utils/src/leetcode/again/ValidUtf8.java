package leetcode.again;

//https://leetcode-cn.com/explore/interview/card/bytedance/247/bonus/1037/
public class ValidUtf8 {
	 public boolean validUtf8(int[] data) {
		 if(data.length==0)return true;
	     int count =0;
	     int n = data.length;
	     
	     for(int i=0;i<n;i++) {
	    	
	    	 if(i==0||count==0) {
	    		 int f = data[i];
	    		 while((f&0x80)!=0) {
			    	 count++;
			    	 f = f<<1;
			     }
	    		 System.out.println(count);
	    		 if(count==1||count>4)return false;
	    		 if(count>0) count--;
	    		 
	    		
		    }else {
		    	if(count>0) {
//		    		System.out.println(String.valueOf((data[i]&0x80)==0x80) + "  " +String.valueOf( (data[i]&0x40)==0));
			    	if(!((data[i]&0x80)==0x80&&(data[i]&0x40)==0))return false;
			    		count--;
		    	}
		    	
			}
	    	 System.out.println(Integer.toBinaryString(data[i]));
//	    	 System.out.println(count);
		    
	    	}
	     if(count>0)return false;
	     return true;
	  }
	 public static void main(String[] args) {
		 ValidUtf8 solution = new ValidUtf8();
//		 System.out.println(solution.validUtf8(new int[] {235,140,4}));
//		 System.out.println(solution.validUtf8(new int[] {197,130,1}));
//		 System.out.println(solution.validUtf8(new int[] {145}));
		 System.out.println(solution.validUtf8(new int[] {250,145,145,145,145}));
		 
	}
}
