import java.util.*;

public class Driver{
    public static int[] randomArray(int size, int max){
	int[] data= new int[size];
	Random num = new Random();
	for(int i=0; i<data.length; i++){
	    data[i]=num.nextInt(max);
	}
	return data;
    }
    
    public static void main(String [] args){
	/*int []data= randomArray(10, 100);
	  System.out.println(Arrays.toString(data));
	  System.out.println(Quick.part(data, 0, 9));
	  System.out.println(Arrays.toString(data));
	*/
	int[]ary = { 2, 10, 15, 23, 0,  5};
	System.out.println(Quick.quickselect( ary , 0 )); //would return 0
	System.out.println(Quick.quickselect( ary , 1 )); //would return 2
	System.out.println(Quick.quickselect( ary , 2 )); //would return 5
	System.out.println(Quick.quickselect( ary , 3 )); //would return 10
	System.out.println(Quick.quickselect( ary , 4 )); //would return 15
	System.out.println(Quick.quickselect( ary , 5 )); //would return 23
    }
}
	
