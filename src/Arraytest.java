import java.util.ArrayList;
import java.util.Arrays;

public class Arraytest {
	
	 public static Integer[] array = {1,2,3,4,5};
	 static Integer[] myArray1 = {1, 2, 3, 4};
     static Integer[] myArray2 = {5, 6, 7, 8};
     static Integer[] myArray3 = {9, 10, 11, 12};
	
	static Integer[] lastArrayEdit(Integer[] array) {
		int newSize = array.length - 1;
		Integer[] arr = new Integer[newSize];
		for (int i = 0; i < newSize; i++) {
			arr[i] = array[i + 1];
		}
		return arr;
	}
	
	static Integer[] firstArrayEdit(Integer[] array) {
		int newSize = array.length - 1;
		Integer[] arr = new Integer[newSize];
		for (int i = 0; i < newSize; i++) {
			arr[i] = array[i];
		}
		return arr;
	}
	
	static Integer[] expandAlgo(Integer[] array1, Integer[] array2, Integer[] array3) {
		ArrayList<Integer> list1 = new ArrayList<Integer>(Arrays.asList(array1));
	      ArrayList<Integer> list2 = new ArrayList<Integer>(Arrays.asList(array2));
	      ArrayList<Integer> list3 = new ArrayList<Integer>(Arrays.asList(array3));
	      
	      int lastElement1 = list1.get(list1.size() - 1);
	      int firstElement3 = list3.get(0);
	      list2.add(0,lastElement1);
	      list2.add(firstElement3);
	      
	      Integer[] newArray = list2.toArray(array2);
	      return newArray;
	}
	public static void method() {
		firstArrayEdit(myArray1);
		lastArrayEdit(myArray3);
		expandAlgo(myArray1,myArray2,myArray3);
	}

	public static void main(String[] args) {
		
		
	      Integer [][] arrayOfArrays = {myArray1, myArray2, myArray3};
	      System.out.println(Arrays.deepToString(arrayOfArrays));
		
		method();
		System.out.println(Arrays.toString(firstArrayEdit(myArray1)) + " ==>");

	      
	      
	    Integer[] newArray2 = expandAlgo(myArray1,myArray2,myArray3);
		Integer[] newArray1 = firstArrayEdit(myArray1);
		Integer[] newArray3 = lastArrayEdit(myArray3);
		
		Integer [][] updatedArrays = {newArray1, newArray2, newArray3};
		System.out.println(Arrays.deepToString(updatedArrays));
		//second iteration
		Integer[] second2 = expandAlgo(newArray1,newArray2,newArray3);
		Integer[] second1 = firstArrayEdit(newArray1);
		Integer[] second3 = lastArrayEdit(newArray3);
		
		Integer [][] updatedArrays2 = {second1,second2,second3};
		System.out.println(Arrays.deepToString(updatedArrays2));
		System.out.println(5 % 2);
	}

}
