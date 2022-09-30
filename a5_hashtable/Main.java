package a5_hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Maps: k -> v
// Sets: k (s)	//not allowed to duplicate keys (as Map)

//Insert O(1)
//Remove O(1)
//Lookup O(1)


public class Main {

	public static void main(String[] args) {
		//Map
		System.out.println("hi structure hashmap!");
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "Mosh");
		map.put(2, "Mary");
		map.put(3, "John");
		map.put(3, "Marianne");	//overwrite = no duplicate key
		map.put(null, null);	//allows null keys or null value
		map.get(3);
		map.remove(null);
		System.out.println( map.get(3) );
		map.containsKey(3); // O(1)
		map.containsValue("Mosh"); // O(n)	itterate all the objects
		System.out.println(map);
		for(var item: map.keySet()) System.out.println( item );
		for(var item: map.entrySet()) System.out.println( item.getValue() );
		
		//Find first Non Repeated Character
		// A Green Apple
		String string = "a green apple";
		CharFinder charFinder = new CharFinder();
		System.out.println("First unrepeated character is: " + charFinder.firstNonUnrepeatedCharacter(string) );
			
		//Set
		System.out.println("");
		System.out.println("/////");
		Set<Integer> set =new HashSet<>();
		int[] numbers = {1, 2, 3  ,3 , 2, 1, 4};
		for( var number: numbers ) set.add( number );
		set.remove(1);
		//set.clear();
		//set.removeAll(set);
		set.contains(2);
		set.size();
		System.out.println("The unique list of values:");
		System.out.println( set );
		
		
		
		
		//Find first Repeated Character
		string = "green apple";
		CharFinder charFinder2 = new CharFinder();
		System.out.println( charFinder2.firstRepeatedCharacter(string) );
		
		//Hashing
		Map<String, String> map100 = new HashMap<>();
		map100.put("123456-A", "Mosh");
		System.out.println(  hash(123456) );
		System.out.println(  hash("123456-A") );
		String s1 = "abc";
		System.out.println(  s1.hashCode() );
		
		//Collision, hash key1 == hash key2
		System.out.println("");
		System.out.println("/////");
		HashTableLinkedList table1 = new HashTableLinkedList();
		table1.put(6, "A");
		table1.put(8, "B");
		table1.put(11, "C");
		table1.put(6, "A+");
		//table1.remove(6);
		System.out.println(table1.get(6));
		System.out.println(table1.get(11));
		System.out.println(table1.get(10));
	} 
	
	public static int hash(String key) {
		int hash = 0;
		for (var ch: key.toCharArray()) hash += ch;
		return hash % 100;
	}
	public static int hash(int number) {
		return number % 100;
	}
}
