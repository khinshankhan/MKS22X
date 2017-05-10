import java.util.*;

public class Driver{
    public static void main(String[] args){
	String s="";
        MyHeap a= new MyHeap(true);
	for(int i=0; i<9; i++)
	    a.add(i+"");
	System.out.println(a);
	a.viewTree();
	for(int i=0; i<9; i++)
	    s+=a.remove();
	System.out.println(a);
	System.out.println(s);
	a.viewTree();
    }
}
