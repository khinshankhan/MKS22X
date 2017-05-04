import java.util.ArrayList;

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
	constant = (type) ? 1 : -1;
        MyHeap();
    }

    private static int compare(String first, String other) {
	return first.compareTo(other)*constant;
    }
    
    public int size() {
	return size;
    }

    public String peek() {
	return heap.get(1);
    }

    public void add(String s){

    }

    public String remove(){
	return "";
    }

    private void pushUp(){

    }
    
    private void pushDown(){

    }

    private int height(){
	return size()/2+1;
    }
    
}
    
