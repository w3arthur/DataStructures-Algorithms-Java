
package b4_trie;
public class Main {
	public static void main(String[] args) {
		System.out.println("Trie");
		var trie = new Trie();
		trie.insert("cat");
		trie.insert("can");
		trie.insert("car");
		trie.insert("care");
		System.out.println(trie.contains("can"));
		System.out.println(trie.contains("cant"));
		System.out.println(trie.contains("ca"));
		
		System.out.println("\nPost Order Traversal"); 
		trie.traverse_PostOrder();
		System.out.println("\nPre Ordere Traversal"); 
		trie.traverse_PreOrder();
		System.out.println("");
		trie.remove("care");
		//trie.remove("book"); //v
		trie.remove(""); //v
		trie.remove(null);
		System.out.println(trie.contains("car"));
		System.out.println(trie.contains("care"));
		
		System.out.println(trie.findWords("ca"));
		System.out.println("++++++++++++");
		System.out.println(trie.countWords("ca"));
	}
}
