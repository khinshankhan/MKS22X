public class Driver{
    
    public static void main(String[] a){
	boolean w=true;
	for(int i=0; i<100000; i++){
	    if(!Recursion.ice(Recursion.sqrt(i),Math.sqrt(i)))
	        w=false;;
	}
	System.out.println(w);
    }
}
