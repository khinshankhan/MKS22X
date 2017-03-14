import java.util.*;

public class Driver{
    public static String printer(String word){
	ArrayList<String>words =Quiz2Redux.combinations(word);
	String s="";
	for(int i=0; i<words.size(); i++){
	    s+=words.get(i);
	    if(i!=words.size()-1)
		s+=", ";
	}
	return s;
    }
    
    public static void main(String[] args){
	System.out.println(printer("abcd"));
	System.out.println(printer("kji"));
    }
}
