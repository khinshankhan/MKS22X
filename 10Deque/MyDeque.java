import java.util.*;

public class MyDeque{

    String[] sdeque; //deque of strings
    private int front, back;
    
    public MyLinkedList(){
        sdeque= new String[10];
        front= back= 0;
    }
    
    //private methods
    
    //will double capacity only (details)
    private void resize(){
    int r = sdeque.length - back; // number of elements to the right of back
    String[] temp = new String[2*(sdeque.length)];
    //NEED TO WORK THIS OUT
    for(int i=0, li=0, ri=0; i<sdeque.length; i++){
      if(i<)
    sdeque = temp;
    }
    
    //add methods
    public void addFirst(String){}
    public void addLast(String){}
    
    //remove methods
    public String removeFirst(){}
    public String removeLast(){}
    
    //get methods
    public String getFirst(){}
    public String getLast(){}
    
