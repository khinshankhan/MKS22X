import java.util.*;
public class Quiz2Redux{  
    /*Returns an ArrayList<String> that contains all subsets of the
     *characters of String s. Assume s has no duplicate characters.
     *the characters should appear in the same order that they occur 
     *in the original string.
     */
    public static ArrayList<String> combinations(String s){
	ArrayList<String>words = new ArrayList<String>();
	help( words , s, "", 0/*fill this in with more */);
	Collections.sort(words);
	return words;
    }
  
    private static void help( ArrayList<String> words,String s, String work, int index){ 
	/*fill this in with more arguments*/ 
	/*METHOD TO BE WRITTEN BY YOU.*/
	if(index>=s.length()){
	    if(!words.contains(work))
	    words.add(work);
	    //System.out.println(index);
	    if(!words.contains(s))
		words.add(s);
	    return;
	}
	//System.out.println(work);
	if(!words.contains(work))
	    words.add(work);
	help(words,s, work+s.charAt(index), index+1);
	help(words,s, work, index+1);
    }
}
