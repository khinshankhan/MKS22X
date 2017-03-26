import java.util.*;

public class Merge{
    public static void mergesort(int[]ary){
	return;
    }
    public static void merge(int[]a,int[]b,int[]destination){
        for(int i=0, ai=0, bi=0; i<destination.length; i++){
	    if(ai==a.length){
		for(int j=bi; ai+j<destination.length; j++){
		    destination[i]=b[j];
		    i++;
		}
		break;
	    }
	    if(bi==b.length){
	        for(int j=ai; bi+j<destination.length; j++){
		    destination[i]=a[j];
		    i++;
		}
		break;
	    }
	    if(a[ai]>b[bi]){
		destination[i]=b[bi];
		bi++;
	    }else if(a[ai]<b[bi]){
		destination[i]=a[ai];
		ai++;
	    }else{
		destination[i]=a[ai];
		ai++;
		i++;
		destination[i]=b[bi];
		bi++;
	    }
	}
	return;
    }
}
