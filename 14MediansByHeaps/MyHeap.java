import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Arrays;

public class MyHeap{

    private int constant;//constant determines type of heap (min or max),
    private int size;//size is because first element creates problems
    private ArrayList<Integer>heap;//storage

    public MyHeap(){
	heap=new ArrayList<Integer>();
	heap.add(1447);//filler
	size=0;
	constant=1;
    }
    
    public MyHeap(boolean type){//min or max heap?
	this();
	constant = (type) ? 1 : -1;
    }
    
    private int compare(Integer first, Integer other) {
	return first.compareTo(other)*constant;
    }

    private int leftChild(int i){
	return i*2;
    }
    
    private int rightChild(int i){
	return i*2+1;
    }

    private int switchChild(int i){
        if (leftChild(i) > size){
	    return -1;
	}
        if (rightChild(i) > size){
	    return leftChild(i);
	}
        return (compare(heap.get(rightChild(i)),heap.get(leftChild(i)))>0) ? rightChild(i) : leftChild(i);
    }

    public Integer peek(){
	if(size==0){
	    throw new NoSuchElementException("Deque is empty");
	}
	return heap.get(1);
    }

    public void add(Integer s){
        heap.add(s);
	size++;
	pushUp();
    }

    public Integer remove(){
	if(size==0){
	    throw new NoSuchElementException("Deque is empty");
	}
        Integer temp = heap.get(1);
	heap.set(1, heap.get(size));
	heap.remove(size);
	size--;
	pushDown();
	return temp;
    }

    private int swap(int index1, int index2){
	Integer temp= heap.get(index1);
	heap.set(index1, heap.get(index2));
	heap.set(index2, temp);
	return index2;
    }

    private void pushUp(){
	int child= size;
	int parent = size / 2;
	while (parent > 0 && compare(heap.get(parent), heap.get(child)) < 0){
	    child= swap(child, parent);
	    parent = child / 2;
	}
    }
    
    private void pushDown(){
	int parent= 1;
	int child=switchChild(1);
	while(child>0 && compare(heap.get(child), heap.get(parent))>0){
	    parent= swap(parent, child);
	    child=switchChild(parent);
	}
    }

    public int getSize(){
	return size;
    }
    
    public String toString(){
	String s="";
	Integer temp=heap.remove(0);
	for(Integer x:heap)
	    s+=x+" ";
	heap.add(0,temp);
	return s;
    }
    //Will add tree printing when done in other file
    
}
    
