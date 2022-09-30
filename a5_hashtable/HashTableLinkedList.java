package a5_hashtable;

import java.util.Arrays;
import java.util.LinkedList;

public class HashTableLinkedList {
	private class Entry{
		public int key;
		public String value;
		public Entry(int key, String value) { this.key = key; this.value = value; }
	}
	private LinkedList<Entry>[] entries;
	
	public HashTableLinkedList() {
		entries = new LinkedList[5];
	}
	
	private int hash(int key) { return key % entries.length; }
	private LinkedList<Entry> getBucket(int key){
		return entries[hash(key)];
	}
	private boolean startBucket(int key){
		var bucket = getBucket(key);
		if(bucket == null) { entries[hash(key)] = new LinkedList<>(); return true; }
		return false;
	}
	private Entry getEntery(int key) {
		var bucket = getBucket(key);
		if (bucket != null) for (var e: bucket) if(e.key == key) return e;
		return null;
	}
	
	public void put(int key, String value) {	// לחזור!
		var bucket = getBucket(key);
		var e = getEntery(key); 
		if(!startBucket(key)) if(e != null) { e.value = value; return; }
		entries[hash(key)].addLast( new Entry(key, value) );
//		int index = hash(key);
//		var bucket = entries[index];
//		if (bucket == null) entries[index] = new LinkedList<>();
//		else for(var e: bucket) if (e.key == key) { e.value = value; return; }//value update	
//		entries[hash(key)].addLast( new Entry(key, value) );
	}
	public String get(int key) {
		var e = getEntery(key);
		return e == null ? null : e.value;
//		var index = hash(key);
//		var bucket = entries[index];
//		if (bucket == null) return null;
//		for(var e: bucket) if (e.key == key) return e.value;
//		return null;
	}
	public void remove(int key) {
		var e = getEntery(key);
		if( e == null ) throw new IllegalStateException();
		getBucket(key).remove(e);
//		var index = hash(key);
//		var bucket = entries[index];
//		if (bucket == null) throw new IllegalStateException();//return;
//		for(var e: bucket) if (e.key == key) { bucket.remove(e); return; }
//		throw new IllegalStateException();
	}
	
}
