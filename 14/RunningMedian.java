public class RunningMedian{
    private MyHeap min, max;
    
    public RunningMedian(){
	min= new MyHeap(true);
	max= new MyHeap(false);
    }

    public void add(int){
	if(n<=small.peek()){
	    small.add(n);
	}else{
	    large.add(n);
	}
	balance(); //assume works rn, procedural abstraction
    }

    public void balance(){//not sure about else, but w/e it'll work
	//if(max.getSize()==min.getSize())
	//return;
	if(Math.abs(large.getSize()-small.getSize())> 1){//will trigger
	    if(max.getSize()> min.getSize()){
		min.add(max.remove());
	    }else{
		max.add(min.remove());
	    }
	}
    }
    
    public double getMedian(){//idk if the thhird case haapens?
        if(max.getSize()==min.getSize())
	    return (max.peek() + min.peek())/ 2.0;
	if(max.getSize()> min.getSize())
	    return max.peek()*1.0;
	return min.peek()*1.0;
    }
}

    
