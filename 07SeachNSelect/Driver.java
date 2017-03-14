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
	int []data= randomArray(10, 100);
	System.out.println(Arrays.toString(data));
	System.out.println(QuickSelect.part(data, 0, 9));
	System.out.println(Arrays.toString(data));
    }
}
	
