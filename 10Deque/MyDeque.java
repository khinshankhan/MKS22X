import java.util.*;

public class MyDeque{

    private String[] sdeque; //deque of strings
    private int front, back, size;
    
    public MyDeque(){
        sdeque= new String[5];
        front= back= size= 0;
    }
    
    //private methods
    
    //will double capacity only (details)
    private void resize(){
	int r = sdeque.length - back; // number of elements to the right of back
	String[] temp = new String[2*(sdeque.length)];
	for(int i=0, li=0, ri=temp.length-r; i<sdeque.length; i++){
	    if(i<back){
		temp[i]=sdeque[i];
	    }else{
		temp[ri]=sdeque[i];
		ri++;
	    }
	}
	front=temp.length-r-1;
	sdeque = temp;
    }
    
    //add methods
    public void addFirst(String a){
	//trying to add null element
	if(a == null){
	    throw new NullPointerException("No null elements allowed");
	}
	//capacity full
	if (size == sdeque.length) {
            resize();
        }
	if(size==0){
	    back= 1;
	}
	sdeque[front]= a;
	
	if(front==0){
	    front=sdeque.length-1;
	}else{
	    front--;
	}
        size++;
    }
    
    public void addLast(String a){
        //trying to add null element
	if(a == null){
	    throw new NullPointerException("No null elements allowed");
	}
	//capacity full
	if (size == sdeque.length) {
            resize();
        }
	if(size==0){
	    front= sdeque.length-1;
	}
	sdeque[back]= a;
	
	if(back==sdeque.length-1){
	    back=0;
	}else{
	    back++;
	}
        size++;
    }
    
    //remove methods
    public String removeFirst(){
	if(size==0){
	    throw new NoSuchElementException("Deque is empty");
	}
	String temp= getFirst();
	int realFront;
	if(front==sdeque.length-1){
	    realFront=0;
	}else{
	    realFront=front+1;
	}   
	sdeque[realFront]=null;
	if(front==sdeque.length-1){
	    front=0;
	}else{
	    front++;
	}
	size--;
	return temp;
    }
    
    public String removeLast(){
	if(size==0){
	    throw new NoSuchElementException("Deque is empty");
	}
	String temp= getLast();
	int realBack;
	if(back==0){
	    realBack=sdeque.length-1;
	}else{
	    realBack=back-1;
	}   
	sdeque[realBack]=null;
	if(back==0){
	    back=sdeque.length-1;
	}else{
	    back--;
	}
	size--;
	return temp;
    }
    
    //get methods
    public String getFirst(){
	if(size==0){
	    throw new NoSuchElementException("Deque is empty");
	}
	int realFront;
	if(front==sdeque.length-1){
	    realFront=0;
	}else{
	    realFront=front+1;
	}   
	return sdeque[realFront];
    }
    
    public String getLast(){
        if(size==0){
	    throw new NoSuchElementException("Deque is empty");
	}
	int realBack;
	if(back==0){
	    realBack=sdeque.length-1;
	}else{
	    realBack=back-1;
	}   
	return sdeque[realBack];
    }
    /*
    public String toString(){
	String s= "";
	for(String x : sdeque)
	    s+=x+",";
	//System.out.println(front+","+back+","+size);
	return s;
    }
    */
}
