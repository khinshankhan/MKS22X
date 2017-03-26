import java.util.*;

public class Driver{
    //creates random array
    public static int[] randomArray(int size, int max){
	int[] data= new int[size];
	Random num = new Random();
	for(int i=0; i<data.length; i++){
	    data[i]=num.nextInt(max);
	}
	return data;
    }
    
    public static void main(String [] args){
	int[] a= randomArray(5, 100);
	int[] b= randomArray(7, 100);
	Arrays.sort(a);
	Arrays.sort(b);
	System.out.println(Arrays.toString(a)+"\n"+Arrays.toString(b));
	int[] c=new int[a.length+b.length];
	Merge.merge(a,b,c);
	System.out.println(Arrays.toString(c));
    }
}
