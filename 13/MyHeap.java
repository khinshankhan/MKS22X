import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.lang.StringBuilder;

public class MyHeap{

    private int constant;//constant determines type of heap (min or max),
    private int size;//size is because first element creates problems
    private ArrayList<String>heap;//storage

    public MyHeap(){
	heap=new ArrayList<String>();
	heap.add("72");//filler
	size=0;
    }
    
    public MyHeap(boolean type){//min or max heap?
	this();
	constant = (type) ? 1 : -1;
    }
    
    private int compare(String first, String other) {
	return first.compareTo(other)*constant;
    }
    
    private int parentChild(int i){
	return (i == 0) ? -1 : (i - 1);
    }
    
    private int leftChild(int i){
	return i*2;
    }
    
    private int rightChild(int i){
	return i*2+1;
    }

    private int lesserChild(int i){
        if (leftChild(i) > size - 1){
	    return -1;
	}
        if (rightChild(i) > size - 1){
	    return leftChild(i);
	}
        return (compare(heap.get(leftChild(i)),heap.get(rightChild(i)))<= 0) ? leftChild(i) : rightChild(i);
    }

    public String peek() {
	return heap.get(1);
    }

    public void add(String s){
	heap.add(s);
	pushUp(size);
	size++;
	return;
    }

    public String remove(){
	if(size==0){
	    throw new NoSuchElementException();
	}
	String temp= heap.get(1);
	heap.set(0, heap.get(size));
        heap.remove(size);
        pushDown(0);
	size--;
	return temp;
    }

    private void swap(int index1, int index2){
	String temp= heap.get(index1);
	heap.set(index1, heap.get(index2));
	heap.set(index2, temp);
    }

    private void pushUp(int i){
	int parentIndex = parentChild(i);
        while (i > 0 && compare(heap.get(parentIndex),heap.get(i))<0){
            swap(parentIndex, i);
            i = parentIndex;
            parentIndex = parentChild(i);
        }
    }
    
    private void pushDown(int i){
	int less = lesserChild(i);
        while (less != -1 && compare(heap.get(less),heap.get(i))<0) {
	    swap(less, i);
	    i = less;
	    less = lesserChild(i);
	}
    }

    public int getSize(){
	return size;
    }
    
    public void viewTree(){//needs to be fixed
	StringBuilder sb = new StringBuilder();
	int max=0;
	for(int i=0;i<heap.size();i++){
	    for(int j=0;j<Math.pow(2,i)&&j+Math.pow(2,i)<heap.size();j++){
		if(j>max){
		    max=j;
		}
	    }
	}
	for(int i=0;i<heap.size();i++){
	    for(int j=0;j<Math.pow(2,i)&&j+Math.pow(2,i)<heap.size();j++){
		for(int k=0;(k<max/((int)Math.pow(2, i)));k++){
		    sb.append(" ");
		}
		sb.append(heap.get(j+(int)Math.pow(2,i)-1)+" ");
	    }
	    sb.append("\n");
	}



	System.out.println(sb.toString());

    }

    public String toString(){
	String s="";
	String temp=heap.remove(0);
	for(String x:heap)
	    s+=x+" ";
	heap.add(0,temp);
	return s;
    }

}
    
