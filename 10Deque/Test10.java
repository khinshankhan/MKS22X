import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.*;
public class Test10{

    public static void testException(String name,int size){
	MyDeque base = new MyDeque();
	for(int i =0; i < size; i++){
	    base.addFirst(""+i);
	}
	//System.out.println(base);
	boolean result = true;
	for(int i =0; i < size && result; i++){
	    result = result && base.removeLast().equals(""+i);
	    //System.out.println(base);
	}
	//System.out.println(base);
	String message = "";

	if(result){
	    try{
		base.removeLast();

		message = "FAIL Emptying case (No EXCEPTION THROWN): "+name;
	    }catch(NoSuchElementException e){
		message = "Passed emptying case: "+name;

	    }
	}else
	    {
		message = "FAIL Emptying case (VALUE ERROR): "+name;
	    }
	System.out.println( message);
    }
    public static void testCreation(String name,int size){
	ArrayDeque<String>d = new ArrayDeque<String>(size);
	MyDeque base = new MyDeque();
	long start = System.currentTimeMillis();
	for(int i = 0,j = 0; i < size/2; i++,j+=3){
	    d.addFirst(""+i);
	    base.addFirst(""+i);
	    d.addLast(""+j);
	    base.addLast(""+j);
	}
	/*
	for(Iterator itr = d.iterator();itr.hasNext();)  {
	    System.out.print(itr.next()+",");
	}
	System.out.println();
	System.out.println(base);
	*/
	int s = (size%2==0) ? size : size-1;
	String[]check = new String[s];
	//String[]check = new String[size];
	int index = 0;
	//int index = (size%2==0) ? 0 : 1;
	/*
	  while(index<s){
	    System.out.println(index);
	    check[index] = base.removeFirst();
	    index++;
	    System.out.println(base);
	}
	*/
	
	while(index<s){
	    //System.out.println(index);
	    check[index] = base.removeFirst();
	    index++;
	    //System.out.println(base);
	}
	/*
	for(Iterator itr = d.iterator();itr.hasNext();)  {
	    System.out.print(itr.next()+",");
	}
	System.out.println();
	System.out.println(Arrays.toString(check));
	*/
	long end = System.currentTimeMillis() - start;

	if(Arrays.equals(d.toArray(),check)){
	    System.out.println("Passed case: "+name+" in "+end/1000.0+" seconds.");
	}else{
	    System.out.println("\tFAIL CREATION case: "+name +".");
	}

    }

    public static void main(String[]args){
        int testNum = new Integer(args[0]);
        if(testNum>=0 && testNum <4){
	    testCreation(args[0],new Integer(args[1]));
        }
        if(testNum>=4 && testNum <6){
	    testException(args[0],new Integer(args[1]));
        }

    }
}
