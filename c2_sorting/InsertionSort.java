package c2_sorting;
import javax.crypto.interfaces.DHPrivateKey;

public class InsertionSort {
	public static void sort(int[] array) { // לחזור !
		for(var i = 1; i < array.length; i++) {
//			var current = array[i];
//			var j1 = i - 1;
//			while( j1 >= 0 && array[j1] > current) {
//				array[j1 + 1] = array[j1];
//			}
//			array[j1 + 1] = current;
			
			var current = array[i];
			int j;
			for(j = i - 1; j >= 0; j--) {
				if(array[j] > current) array[j + 1] = array[j];
				else { break;}
			}
			array[j + 1] = current;
			
		}
	}
}
