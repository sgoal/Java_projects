package leetcode.again;

public class Trie {
	class TrieNode{
		boolean isTail;
		TrieNode [] points = new TrieNode['z'-'a'+1];
	}
	TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
    	root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	TrieNode temp = root;
        for(char c: word.toCharArray()) {
        	if(temp.points[c-'a']==null) {
        		temp.points[c-'a'] = new TrieNode();
        	}
        	temp = temp.points[c-'a'];
        }
        temp.isTail = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	TrieNode temp = root;
        for(char c: word.toCharArray()) {
        	if(temp.points[c-'a']==null) {
        		return false;
        	}
        	temp = temp.points[c-'a'];
        }
        return temp.isTail;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	TrieNode temp = root;
        for(char c: prefix.toCharArray()) {
        	if(temp.points[c-'a']==null) {
        		return false;
        	}
        	temp = temp.points[c-'a'];
        }
        return true;
    }
    
    public static void main(String[] args) {
    	Trie trie = new Trie();

    	trie.insert("apple");
    	System.out.println(trie.search("apple"));   // returns true
    	System.out.println(trie.search("app"));     // returns false
    	System.out.println(trie.startsWith("app")); // returns true
    	trie.insert("app");   
    	System.out.println(trie.search("app"));     // returns true
	}
}
