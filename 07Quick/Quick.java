import java.util.*;

public class Quick{
    //swap two values in int array
    public static void swap(int[] data, int a, int b) {
	int store = data[a];
	data[a] = data[b];
	data[b] = store;
    }
    
    public static int part ( int [] data, int start, int end){
	Random random = new Random();
	int pos = random.nextInt(end - start) + start;
	//***System.out.println(pos+":"+data[pos]);
	//System.out.println(Arrays.toString(data)+"\n");
	swap(data, pos, end); // move pivot to end
	//System.out.println(Arrays.toString(data));
	int currenti = start;
	for(int i = start; i < end; i++) {
	    //System.out.println(Arrays.toString(data));
	    if(data[i] < data[end]) {
		swap(data, currenti, i);
		currenti++;
	    }
	}
	//System.out.println(Arrays.toString(data));
	swap(data, end, currenti); // Move pivot to its final place
	//System.out.println(Arrays.toString(data));
	return currenti;
    }
}