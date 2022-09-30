package a5_hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFinder {
	public char firstNonUnrepeatedCharacter(String str) {
		Map<Character, Integer> map = new HashMap<>();
		char[] charArray = str.toCharArray();
		for(var ch: charArray) {
//			if(map.containsKey(ch)) {
//				var count = map.get(ch);
//				map.put(ch, count + 1);
//			} else map.put(ch, 1);
			var count = map.containsKey(ch) ? map.get(ch): 0;
			map.put(ch, count + 1);
		} 
		for (var ch: charArray) if(map.get(ch) == 1) return ch;
		return Character.MIN_VALUE;
	}
	
	public char firstRepeatedCharacter(String str) {
		Set<Character> set = new HashSet<>();
		for (var ch: str.toCharArray() ) {
			if( set.contains(ch) ) return ch;
			set.add(ch);
		}
		return Character.MIN_VALUE;
	}


}
