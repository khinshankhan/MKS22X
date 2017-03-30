
import java.util.*;

public class Driver2{
    //Random int
    public static int randInt(int min, int max) {
	Random rand = new Random();
	int randomNum = rand.nextInt(max - min) + 1 + min;
	return randomNum;
    }
    
    //creates random array, size and max
    public static int[] randomArray(int size, int max){
	int[] data= new int[size];
	Random num = new Random();
	for(int i=0; i<data.length; i++){
	    data[i]=num.nextInt(max);
	}
	return data;
    }
    
    //creates random array, size, min, and max
    public static int[] randomArray(int size, int min, int max){
	int[] data= new int[size];
	for(int i=0; i<data.length; i++){
	    int ran= min+(int)Math.floor(Math.random()*(max-min+1));
	    data[i]=ran;
	}
	return data;
    }
    public static int[] reverseRandomArray(int size, int max){
	int[] data= new int[size];
	Random num = new Random();
	for(int i=0; i<data.length; i++){
	    data[i]=num.nextInt(max)*-1;
	}
	Arrays.sort(data);
	for(int i=0; i<data.length; i++){
	    data[i]=data[i]*-1;
	}
	return data;
    }
    public static void main(String [] args){
	System.out.println("Small Array:");
	for(int i=0; i< 20; i++){
	    int size=10+(int)Math.floor(Math.random()*(20-10+1));
	    int[] test= randomArray(size, 10);
	    int[] sorted= test.clone();
	    Arrays.sort(sorted);
	    Quick.quickSort(test);
	    if(Arrays.equals(test, sorted)){
		System.out.println("GOOD");
	    }else{
		System.out.println("OH NO");
		return;
	    }
	}
	System.out.println("Big Array:");
	for(int i=0; i< 20; i++){
	    int[] test= randomArray(1000000,Integer.MIN_VALUE,Integer.MAX_VALUE);
	    //System.out.println(Arrays.toString(test)); //dont use this
	    int[] sorted= test.clone();
	    Arrays.sort(sorted);
	    Quick.quickSort(test);
	    if(Arrays.equals(test, sorted)){
		System.out.println("GOOD");
	    }else{
		System.out.println("OH NO");
		return;
	    }
	}
	System.out.println("Same Value Array:");
	for(int i=0; i< 20; i++){
	    int[] test= new int[10+(int)Math.floor(Math.random()*(20-10+1))];
	    int ran= 10+(int)Math.floor(Math.random()*(20-10+1));
	    for(int j=0; j<test.length; j++){
		test[j]=ran;
	    }
	    int[] sorted= test.clone();
	    Arrays.sort(sorted);
	    Quick.quickSort(test);
	    if(Arrays.equals(test, sorted)){
		System.out.println("GOOD");
	    }else{
		System.out.println("OH NO");
		return;
	    }
	}
	System.out.println("Sorted Array:");
	for(int i=0; i< 20; i++){
	    int size=10+(int)Math.floor(Math.random()*(100000-10+1));
	    int[] test= randomArray(size, 10);
	    int[] sorted= test.clone();
	    Arrays.sort(sorted);
	    Arrays.sort(test);
	    Quick.quickSort(test);
	    if(Arrays.equals(test, sorted)){
		System.out.println("GOOD");
	    }else{
		System.out.println("OH NO");
		return;
	    }
	}
	System.out.println("Reverse Sorted Array:");
	//mini test to make sure sound reversal logic
	//int h=10+(int)Math.floor(Math.random()*(20-10+1));
	//int k=10+(int)Math.floor(Math.random()*(20-10+1));
	//int[] d= reverseRandomArray( h, k);
	//System.out.println(Arrays.toString(d));
	//Arrays.sort(d);
	//System.out.println(Arrays.toString(d));	
	for(int i=0; i< 20; i++){
	    int size=10+(int)Math.floor(Math.random()*(100000-10+1));
	    int max=10+(int)Math.floor(Math.random()*(100000-10+1));
	    int[] test= reverseRandomArray(size, max);
	    int[] sorted= test.clone();
	    Arrays.sort(sorted);
	    Quick.quickSort(test);
	    if(Arrays.equals(test, sorted)){
		System.out.println("GOOD");
	    }else{
		System.out.println("OH NO");
		return;
	    }
	}
	System.out.println("You can applaud!");
    }
}
