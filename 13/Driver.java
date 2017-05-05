import java.util.*;

public class Driver{
    public static void main(String[] args){
        MyHeap a= new MyHeap(true);
	a.add(55+"");
	a.add(0+"");
	a.add(54+"");
	System.out.println(a);
    }
}
