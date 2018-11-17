package leetcode.again;

import java.util.HashMap;

public class LongestPalindromeSubseq {
	HashMap<String, Integer> map = new HashMap<>();
	  public int longestPalindromeSubseq(String s) {
		if(map.containsKey(s))return map.get(s);
		if(s.length()<=1)return s.length();
		if(s.charAt(0)==s.charAt(s.length()-1)) {
			int x= 2+longestPalindromeSubseq(s.substring(1, s.length()-1));
			map.put(s, x);
			return x;
		}
		else {
			int x= Math.max(longestPalindromeSubseq(s.substring(0, s.length()-1)),
					longestPalindromeSubseq(s.substring(1,s.length())));
			map.put(s, x);
			return x;
		}
	   }
	  public static void main(String[] args) {
		LongestPalindromeSubseq subseq = new LongestPalindromeSubseq();
		System.out.println(subseq.longestPalindromeSubseq("bbbab"));
		System.out.println(subseq.longestPalindromeSubseq("bbbbb"));
		System.out.println(subseq.longestPalindromeSubseq("gphyvqruxjmwhonjjrgumxjhfyupajxbjgthzdvrdqmdouuukeaxhjumkmmhdglqrrohydrmbvtuwstgkobyzjjtdtjroqpyusfsbjlusekghtfbdctvgmqzeybnwzlhdnhwzptgkzmujfldoiejmvxnorvbiubfflygrkedyirienybosqzrkbpcfidvkkafftgzwrcitqizelhfsruwmtrgaocjcyxdkovtdennrkmxwpdsxpxuarhgusizmwakrmhdwcgvfljhzcskclgrvvbrkesojyhofwqiwhiupujmkcvlywjtmbncurxxmpdskupyvvweuhbsnanzfioirecfxvmgcpwrpmbhmkdtckhvbxnsbcifhqwjjczfokovpqyjmbywtpaqcfjowxnmtirdsfeujyogbzjnjcmqyzciwjqxxgrxblvqbutqittroqadqlsdzihngpfpjovbkpeveidjpfjktavvwurqrgqdomiibfgqxwybcyovysydxyyymmiuwovnevzsjisdwgkcbsookbarezbhnwyqthcvzyodbcwjptvigcphawzxouixhbpezzirbhvomqhxkfdbokblqmrhhioyqubpyqhjrnwhjxsrodtblqxkhezubprqftrqcyrzwywqrgockioqdmzuqjkpmsyohtlcnesbgzqhkalwixfcgyeqdzhnnlzawrdgskurcxfbekbspupbduxqxjeczpmdvssikbivjhinaopbabrmvscthvoqqbkgekcgyrelxkwoawpbrcbszelnxlyikbulgmlwyffurimlfxurjsbzgddxbgqpcdsuutfiivjbyqzhprdqhahpgenjkbiukurvdwapuewrbehczrtswubthodv"));
	}
	  
}
