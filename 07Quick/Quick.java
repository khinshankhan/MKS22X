import java.util.*;

public class Quick{

    //swap two values in int array
    public static void swap(int[] data, int a, int b) {
	int store = data[a];
	data[a] = data[b];
	data[b] = store;
    }
    
    public static int quickselect(int []data, int k){
	//return the value that is the kth smallest value of the array. 
	//use your partition method to help you accomplish this.
	int pos=0;
	int start=0;
	int end=data.length-1;
	
	while(true){
	    //System.out.println(Arrays.toString(data));
	    int x = part(data, start, end);
	    pos=x;
	    if(k==pos)
		break;
	    if(k < pos) {
		end = pos;
	    } else {
		start = pos;
	    }
	}
	//System.out.println(Arrays.toString(data));
	return data[pos];
    }
    
    public static int[] part ( int [] data, int start, int end){
	
	/*
	Random random = new Random();
	System.out.println(start+":"+end+"\n"+Arrays.toString(data));
	int pos = random.nextInt(end - start) + start;
	
	//testing for a friend
	int pos=start+(int)Math.floor(Math.random()*(end-start+1));
	//System.out.println(pos+";"+data[pos]);
	//System.out.println(pos+":"+data[pos]);
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
	*/

	//Dutch Flag Problem

	int lt=start;
	int i=start;
	int gt=end;
	int pos=start+(int)Math.floor(Math.random()*(end-start+1));
	swap(data,0,pos);
	int v=data
	while(i<=gt)
	    if(a[i]==v){
		i++;
	    }else if(a[i]<v){
		swap(data, i, lt);
		i++;
		lt++;
	    }else{
		swap(data, i, gt);
		g--;
	    }
	swap(data, 0, lt);
	int[] posHolder=new int [2];
	posHolder[0]=lt;
	posHolder[1]=gt;
	return posHolder;
    }
}
