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
    char[][]ary;
    

    public MazeSolver(String name){
	add(name);
        //System.out.println(row+" "+col);
	//debugPrinter(name);
	ary=new char[row][col];
	System.out.println(board.length());
	clearAry();
	con();
    }

    public void con(){
        int r=0;
	int c=0;
        for (int i = 0; i < board.length(); i++) {
	    ary[r][c] =board.charAt(i);
	    c++; 
	    if (i % (ary[0].length - 1) == 0) {
		r++; 
		c = 0; 
	    }
	}
	for(int i=0; i<ary.length; i++){
	    for(int j=0; j<ary[i].length; j++)
		System.out.print(ary[i][j]);
	    System.out.println("");
	}
    }
    private void clearAry(){
	for(int r=0; r<ary.length;r++){
	    for(int c=0; c<ary[r].length;c++)
		ary[r][c]='0';
	}
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
	    }
	    inf = new Scanner(infile);
	    lineNumber = 1;
	    while(inf.hasNextLine()){
		String line = inf.nextLine();
		for(int i=0; i<line.length(); i++){
		    board+=line.charAt(i);
		}
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
