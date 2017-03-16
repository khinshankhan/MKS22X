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
	//Partition Test Cases (Need to check the array visually)
	/*int []data= randomArray(10, 100);
	  System.out.println(Arrays.toString(data));
	  System.out.println(Quick.part(data, 0, 9));
	  System.out.println(Arrays.toString(data));
	*/
	//K's Test Cases
	/*
	  int[]ary = { 2, 10, 15, 23, 0,  5};
	  System.out.println(Quick.quickselect( ary , 0 )); //would return 0
	  System.out.println(Quick.quickselect( ary , 1 )); //would return 2
	  System.out.println(Quick.quickselect( ary , 2 )); //would return 5
	  System.out.println(Quick.quickselect( ary , 3 )); //would return 10
	  System.out.println(Quick.quickselect( ary , 4 )); //would return 15
	  System.out.println(Quick.quickselect( ary , 5 )); //would return 23
	*/
	//Quick Select Test Cases, can just look to see if a line isn't spaced and is "ERROR"
	//Might modify to give more insight, but what works works.
	for(int i=0; i<10; i++){
	    //checking for a friend; 10 min and 20 max
	    int size=10+(int)Math.floor(Math.random()*(20-10+1));
	    int []data= randomArray(size, 1000);
	    System.out.println(" Original:"+Arrays.toString(data));
	    //checking for a friend
	    int randompos=(int)Math.floor(Math.random()*(data.length));
	    int q= Quick.quickselect(data, randompos);
	    Arrays.sort(data);
	    if(q==data[randompos]){
		System.out.println(String.format(" Woo! for %s \n %s \n sortedSelect: %s : quickSelect: %s",
						 randompos, Arrays.toString(data), data[randompos], q));
	    }else{System.out.println("ERROR");}
	}

    }
}

	
