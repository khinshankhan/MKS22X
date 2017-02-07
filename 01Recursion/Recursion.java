public class Recursion{
    public static String name(){
	return "Khan,Khinshan";
    }
    
    public static double sqrt(double n){
	if(n<0)
	    throw new IllegalArgumentException("Not dealing with i or negatives");
	if(n==0||n==1)
	    return n;
	return sqrt(n,1);
    }

    public static double sqrt(double a, double b){
	if(ice(a,b*b))
	    return b;
	return sqrt(a,((a/b)+b)/2);
    }

    public static boolean ice(double a, double b){//isCloseEnough
      return Math.abs(a-b)<0.0000000001;
  }
}  
