import java.util.*;

public class Driver{
    //to compare min+max heaps to b/c runtime doesnt matter for test
    static List<Integer> list= new ArrayList<>();
    
    public static void sort(List<Integer> a){
	Collections.sort(a);
    }
    public static double median(List<Integer> a){
	int middle= a.size()/2;
	if(a.size() % 2 == 1)
	    return a.get(middle);
	return (a.get(middle)+a.get(middle-1))/2.0;
    }

    public static void main(String [] args){
	int Ls=0;
	int Ws=0;
	RunningMedian test= new RunningMedian();
	String ans= "";
        for(int i=0; i<1000; i++){
	    int a=(i*(int)(Math.random()*10));//random
	    list.add(a);
	    test.add(a);
	    sort(list);
	    //System.out.println(median(list)+":"+test.getMedian());//decrease 1000 to like 10 and debug
	    //System.out.println(list.toString());//see the list
	    int extra=(median(list) == test.getMedian()) ? Ws++ : Ls++;//ternary operator for those interested
	}
        System.out.println(String.format("Successfully ran(no errors or exceptions)! \n Failures: %s : Successes: %s", Ls, Ws));
    }
}
