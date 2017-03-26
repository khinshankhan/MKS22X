public class Merge{
    
    public static void mergesort(int[]ary){
	if(ary.length == 1)
	    return;
	
	int len=ary.length/2;
	int[] left = new int[len];
	int[] right = new int[ary.length-len];
	
	for(int i=0, li=0, ri=0; i<ary.length; i++){
	    if(i<len){
		left[li]=ary[i];
		li++;
	    }else{
		right[ri]=ary[i];
		ri++;
	    }
	}
	
	if(left.length > 1)
	    mergesort(left);
	if(right.length > 1)
	    mergesort(right);
	
	merge(left,right,ary);
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
