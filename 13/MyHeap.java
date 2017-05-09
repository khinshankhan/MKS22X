import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Arrays;

public class MyHeap{

    private int constant;//constant determines type of heap (min or max),
    private int size;//size is because first element creates problems
    private ArrayList<String>heap;//storage

    public MyHeap(){
	heap=new ArrayList<String>();
	heap.add("FILLER");//filler
	size=0;
	constant=1;
    }
    
    public MyHeap(boolean type){//min or max heap?
	this();
	constant = (type) ? 1 : -1;
    }
    
    private int compare(String first, String other) {
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

    public String peek(){
	if(size==0){
	    throw new NoSuchElementException("Deque is empty");
	}
	return heap.get(1);
    }

    public void add(String s){
        heap.add(s);
	size++;
	pushUp();
    }

    public String remove(){
	if(size==0){
	    throw new NoSuchElementException("Deque is empty");
	}
        String temp = heap.get(1);
	heap.set(1, heap.get(size));
	heap.remove(size);
	size--;
	pushDown();
	return temp;
    }

    private int swap(int index1, int index2){
	String temp= heap.get(index1);
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
	String temp=heap.remove(0);
	for(String x:heap)
	    s+=x+" ";
	heap.add(0,temp);
	return s;
    }

    private int logbase(int base, int val) {
	if (val == 0){
	    return 0;
	}
        return (int)(Math.log(val) / Math.log(base)); // = log(val) with base 10 / log(base) with base 10
    }
    
    public void viewTree(){ //needs to be fixed
	String s= "";
	int height = (int)logbase(2, size) + 1; //levels of the tree
	System.out.println("Height: "+height);
	//\t
	int currentHeight=0;
	int c=1;
	//int spaces= 48;
	for(int i=1; i<=height; i++){
	    s+=c;
	    //System.out.print(chStringOfSize(height-i, '\t'));
	    double nums=Math.pow(2,currentHeight);
	    for(int j=0, p=c; j< nums && p<heap.size(); j++){
		//System.out.print(chStringOfSize(height-i, '\t'));
		System.out.print(chStringOfSize(height-i+1, '\t'));
		//System.out.print(chStringOfSize(spaces-1, ' '));
		//System.out.print("TEST "+nums);
		System.out.print(heap.get(p));
		p++;
	    }
	    System.out.println("");
	    currentHeight++;
	    c*=2;
	    //spaces= (spaces*2)/3;
	    //System.out.println("what c\n"+s);
	}
    }

    private String chStringOfSize(int size, char ch) {
        char[] a = new char[size];
        Arrays.fill(a, ch);
        return new String(a);
    }
    
}
    
