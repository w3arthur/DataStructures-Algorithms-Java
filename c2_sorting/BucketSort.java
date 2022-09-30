package c2_sorting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort { // לחזור
	public static void sort(int[] array, int numberOfBuckets) {
		var buckets = creatBuckets(array, numberOfBuckets);
		var index = 0;
		for (var bucket: buckets) {
			Collections.sort(bucket); //java quick sort each bucket
			for(var item : bucket) array[index++] = item;
		}
	}
	private static List<List<Integer>> creatBuckets(int[] array, int numberOfBuckets) {
		List<List<Integer>> buckets = new ArrayList<>();	//not initialized
		for (var i = 0; i < numberOfBuckets; i++) buckets.add( new ArrayList<>()); //initialize each element as list
		for (var item : array) buckets.get(item / numberOfBuckets).add(item);
		return buckets;
	}
	
}
