import java.util.*;

public class Quick{

    //swap two values in int array
    public static void swap(int[] data, int a, int b) {
	int store = data[a];
	data[a] = data[b];
	data[b] = store;
    }
    
    //easy randomizer
    public static int randInt(int min, int max) {

	// Usually this can be a field rather than a method variable
	Random rand = new Random();

	// nextInt is normally exclusive of the top value,
	// so add 1 to make it inclusive
	int randomNum = rand.nextInt(max - min) + 1 + min;

	return randomNum;
    }

    //return the value that is the kth smallest value of the array. 
    //use your partition method to help you accomplish this.
    public static int quickSelect(int[] data, int k){
	/*
        int pos=0;
	int start=0;
	int end=data.length-1;
	
	while(true){
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
	return data[pos];
	*/
	//return qselect(data, k, 0, data.length-1);
	return dutchPartition(data, k, 0, data.length-1);
    }
    
    public static int qselect ( int [] data, int k, int start, int end){
	int pos = part(data, start, end);
	if(k == pos){
	    return data[pos];
	}else if(k < pos){
	    return qselect(data, k, 0, pos);
	}else{
	    return qselect(data, k, pos, data.length-1);
	}
    }
    
    public static int part(int[] data, int start, int end){
    	int pos =randInt(start,end);
    	int v = data[pos];
    	swap(data, pos, end);
    	int i = start;
    	int j = end-1;
    	while(i <= j){
    	    if(data[i] < v){
    		i++;
    	    }else{
    		swap(data, i, j);
    		j--;
    	    }
    	}
    	swap(data, i, end);
    	return i;

    }

    public static int dutchPartition(int[] data, int k, int start, int end){
	//System.out.println(k+":"+start+";"+end);
	int i = start;
	int lt = start;
	int gt = end;
	int pos = randInt(start,end);
	int v = data[pos];
	swap(data, pos, end);
	while(i <= gt){
	    if(data[i] == v){
		i++;
	    }else if(data[i] < v){
		swap(data, i, lt);
		i++;
		lt++;
	    }else{
		swap(data, i, gt);
		gt--;
	    }
	}
	if(k==lt || k==gt || (k>lt && k<gt))
	    return data[k];
        if (k < lt){
            return dutchPartition(data, k, start, lt);
        } else{
            return dutchPartition(data, k, gt, end);
        }
    }
    public static void quickSort(int[] data){
	qsortH(data, 0, data.length-1);
    }
    
    public static void qsortH ( int [] data, int start, int end){
	//Used to be part 
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
        if(start == end)
	    return;
	int i = start;
	int lt = start;
	int gt = end;
	int pos = randInt(start,end);
	int v = data[pos];
	swap(data, pos, end);
	while(i <= gt){
	    if(data[i] == v){
		i++;
	    }else if(data[i] < v){
		swap(data, i, lt);
		i++;
		lt++;
	    }else{
		swap(data, i, gt);
		gt--;
	    }
	}
	if(lt != 0)
	    qsortH(data, start, lt-1);
	qsortH(data, gt, end);
    }
}
