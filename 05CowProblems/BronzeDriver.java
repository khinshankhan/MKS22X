public class BronzeDriver{
    public static void main(String args[]){
	USACO x=new USACO();
	if(args.length>0){
	    System.out.println(x.bronze(args[0]));
	}else{System.out.println("Invalid file");}
    }	    
}
