import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;


public class MazeSolver{
    //link for colors:
    //http://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
    public static final String ansiRed = "\u001B[41m";
    public static final String ansiGreen = "\u001B[42m";
    public static final String ansiReset = "\u001B[0m";

    String board="";
    int row=1;
    int col=0;
    

    public MazeSolver(String name){
	add(name);
        //System.out.println(row+" "+col);
	debugPrinter(name);
    }

    public void debugPrinter(String filename){
	try{
	    File infile = new File(filename);// can be a path"/full/path/to/file.txt" 
	    Scanner inf = new Scanner(infile);
	    int lineNumber = 1;
	    while(inf.hasNextLine()){
		String line = inf.nextLine();
		for(int i=0; i<line.length(); i++){
		    if('#'==line.charAt(i)){
			System.out.print(ansiRed+" "+ansiReset);
		    }else{
			System.out.print(line.charAt(i));
		    }
		}
		System.out.print("\n");
	    }
	}catch(Exception e){
	    System.out.println("Looks like the file doesn't exist. Create and try again.");
	}
    }

    public void add(String filename){
	try{
	    File infile = new File(filename);// can be a path"/full/path/to/file.txt" 
	    Scanner inf = new Scanner(infile);
	    int lineNumber = 1;
	    col = inf.nextLine().length();
	    while(inf.hasNextLine()){
		String line = inf.nextLine();
		row+=1;
	        board+=line;
		board+=("\n");
	    }
	}catch(Exception e){
	    System.out.println("Looks like the file doesn't exist. Create and try again.");
	}
    }

    public String toString(){
	String s="";
	for(int i=0; i<col; i++){
	    if('#'==board.charAt(i)){
		System.out.print(ansiRed+" "+ansiReset);
	    }else{
		System.out.print(board.charAt(i));
	    }
	}
        return s;
    }

    public static void main(String args[]){
	try{
	    MazeSolver a= new MazeSolver(args[0]);
	}catch(Exception e){
	    MazeSolver a= new MazeSolver("Maze1.txt");
	}
    }
}
