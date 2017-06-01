public class Driver{
    public static void main (String[] args){
	MyDeque a= new MyDeque();
	System.out.println(a);
	for( int i= 0; i< 7; i++){
	    a.addFirst(""+i);
	    System.out.println(a);
	    System.out.println(a.getFirst()+":"+a.getLast());
	}
	for( int i= 0; i< 7; i++){
	    a.removeLast();
	    System.out.println(a);
	    System.out.println(a.getFirst()+":"+a.getLast());
	}
    }
}
