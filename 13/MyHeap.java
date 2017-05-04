import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MyHeap{

    private int constant;//constant determines type of heap (min or max),
    private int size;//size is because first element creates problems
    private ArrayList<String>heap;//storage

    public MyHeap(){
	heap=new ArrayList<String>();
	heap.add("1447");//filler
	size=0;
    }
    
    public MyHeap(boolean type){//min or max heap?
	this();
	constant = (type) ? 1 : -1;
    }

    private int compare(String first, String other) {
	return first.compareTo(other)*constant;
    }

    public String peek() {
	return heap.get(1);
    }

    public void add(String s){
	heap.add(s);
	pushUp(size);
	return;
    }

    public String remove(){
	if(size==0){
	    throw new NoSuchElementException();
	}
	return "";
    }

    private void swap(int index1, int index2){
	String temp= heap.get(index1);
	heap.set(index1, heap.get(index2));
	heap.set(index2, temp);
    }

    private void pushUp(int child){
	int parent=child/2;
	if(size==1){
	    return;
	}
        if(compare(heap.get(child), heap.get(parent))>0){
	    swap(child, parent);
	    pushUp(parent);
	}
	return;
    }
    
    private void pushDown(){

    }
    public String toString(){
	String s="";
	for(String x: heap){
	    s+=x+",";
	}
	return s;
    }

    private int height(){
	return size/2;
    }
    
}
    
