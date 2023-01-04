import java.util.ArrayList;
import java.util.Arrays;

public class wut {

	public static void main(String[] args) {
		//three arrays, top third; middle algo third; bottom third
		Integer[] myArray1 = {1, 2, 3, 4};
	      Integer[] myArray2 = {5, 6, 7, 8};
	      Integer[] myArray3 = {9, 10, 11, 12};
	      
	      Integer [][] arrayOfArrays = {myArray1, myArray2, myArray3};
	      System.out.println(Arrays.deepToString(arrayOfArrays));
	      System.out.println(Arrays.toString(myArray1));
	      ArrayList<Integer> list1 = new ArrayList<Integer>(Arrays.asList(myArray1));
	      ArrayList<Integer> list2 = new ArrayList<Integer>(Arrays.asList(myArray2));
	      ArrayList<Integer> list3 = new ArrayList<Integer>(Arrays.asList(myArray3));
	      
	      
	      int lastElement1 = list1.get(list1.size() - 1);
	      int firstElement2 = list2.get(0);
	      int lastElement2 = list2.get(list2.size() - 1);
	      int lastElement3 = list3.get(list3.size() - 1);
	      int firstElement3 = list3.get(0);
	      //start messing with the arraylists start with the add-ons
	      list2.add(0,lastElement1);
	      list2.add(list2.size() - 1, firstElement3);
	      //then do the take outs
	      
	      list1.remove(list1.size() - 1);
	      System.out.println(list1 + " is the altered list we want to change back into Array1");
	      
	      Integer[] a = Arrays.copyOf(myArray1, (myArray1.length - 1));
	      System.out.println(Arrays.toString(a) + " test");
	      
	      
	      System.out.println(Arrays.toString(myArray1) + " test");
	      myArray1 = list1.toArray(myArray1);
	      System.out.println(Arrays.toString(myArray1) + " is Array1 that has a problem");
	      System.out.println(list2 + " is the list we want the array2 to be");
	      //switch back to arrays
	      myArray2 = list2.toArray(myArray2); 
	      
	      System.out.println(Arrays.toString(myArray2) + " is an actual array2");
	      
	      
	}

}
