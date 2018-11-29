package leetcode.again;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collector;
import java.util.stream.Collectors;

//https://leetcode.com/problems/reorganize-string/
public class ReorganizeString {
	class CharCount{
		CharCount(int count1,char c1){count=count1;c=c1;}
		int count;
		char c;
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return c +" " + count;
		}
	}
    public String reorganizeString1(String S) {
        if(S.length()==0)return "";
        char[] temp = S.toCharArray();
        int[] hash = new int[26];
        for(char c:temp)hash[c-'a']++;
        PriorityQueue<CharCount> queue = new PriorityQueue<>((x,y)->x.count==y.count?x.c-y.c:y.count-x.count);
        for(int i=0;i<26;i++)if(hash[i]>0) {
        	if(hash[i]>(S.length()+1)/2)return "";
        	queue.add(new CharCount(hash[i], (char)(i+'a')));
        }
//        System.out.println(queue);
        StringBuilder sb = new StringBuilder();
        while(queue.size()>=2) {
        	CharCount c1 = queue.poll();
        	CharCount c2 = queue.poll();
        	sb.append(c1.c);
        	sb.append(c2.c);
        	if(--c1.count>0)queue.add(c1);
        	if(--c2.count>0)queue.add(c2);
        }
        if (queue.size() > 0) sb.append(queue.poll().c);
        
        return sb.toString();
    }
    
    public String reorganizeString(String S) {
        if(S.length()==0)return "";
        char[] temp = S.toCharArray();
        int[] hash = new int[26];
        for(char c:temp)hash[c-'a']++;
        ArrayList<CharCount> counts1 = new ArrayList<>();
        for(int i=0;i<26;i++)if(hash[i]>0) {
        	if(hash[i]>(S.length()+1)/2)return "";
        	counts1.add(new CharCount(hash[i],(char)(i+'a')));
        }
        counts1.sort((x,y)->y.count==x.count?x.c-y.c:x.count-y.count);
        CharCount[] counts = counts1.stream().toArray(CharCount[]::new);
        //System.out.println(Arrays.toString(counts));
        char []res = new char[S.length()];
       
        int start = 1;
        for(CharCount cc:counts) {
        		for(int j=0;j<cc.count;j++) {
        			if(start>=res.length)start=0;
        			res[start] = cc.c;
        			start+=2;       			
        		}
        }
        
        return String.valueOf(res);
    	
    	
    }
    
    public static void main(String[] args) {
    	ReorganizeString solution = new ReorganizeString();
    	System.out.println(solution.reorganizeString("abcngrccc"));
    	System.out.println(solution.reorganizeString("tndsewnllhrtwsvxenkscbivijfqnysamckzoyfnapuotmdexzkkrpmppttficzerdndssuveompqkemtbwbodrhwsfpbmkafpwyedpcowruntvymxtyyejqtajkcjakghtdwmuygecjncxzcxezgecrxonnszmqmecgvqqkdagvaaucewelchsmebikscciegzoiamovdojrmmwgbxeygibxxltemfgpogjkhobmhwquizuwvhfaiavsxhiknysdghcawcrphaykyashchyomklvghkyabxatmrkmrfsppfhgrwywtlxebgzmevefcqquvhvgounldxkdzndwybxhtycmlybhaaqvodntsvfhwcuhvuccwcsxelafyzushjhfyklvghpfvknprfouevsxmcuhiiiewcluehpmzrjzffnrptwbuhnyahrbzqvirvmffbxvrmynfcnupnukayjghpusewdwrbkhvjnveuiionefmnfxao"));
    	System.out.println(solution.reorganizeString("abc"));
    	System.out.println(solution.reorganizeString("aab"));
    	System.out.println();
	}
}
