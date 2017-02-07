public class Recursion{
  public static String name(){
    return "Khan,Khinshan";};
  public static double sqrt(double n){
    if(n<0)
      throw new IllegalArgumentException("Not dealing with i or negatives");
    if(n==0||n==1)
      return n; 
    return sqrt(n,1);
  }    
  public static double sqrt(double a, double b){
  ...};
  public static double ice(double a, double b){//isCloseEnough
  ...};
}  
