import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Maze{
    //link for colors:
    //http://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
    public static final String ansiRed = "\u001B[41m";
    public static final String ansiGreen = "\u001B[42m";
    public static final String ansiCyanBack = "\u001B[46m";
    public static final String ansiReset = "\u001B[0m";
    
    String board="";
    String formatted="";
    int row=1;
    int col=0;
    char[][]ary;
    int x,y;
    //for reset
    int startx, starty;

    private boolean animate;
    

    public Maze(String name){
	try{
	File infile = new File(name);// can be a path"/full/path/to/file.txt" 
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
		formatted+=line.charAt(i);
	    }
	    formatted+="\n";
	}
	if(!validPuzzle()){
	    System.out.println("Not a puzzle");
	    System.exit(0);
	}
	}catch(Exception e){
	    System.out.println("Looks like the file doesn't exist. Create and try again.");
	}
	//add(name);
        //System.out.println(row+" "+col);
	//debugPrinterFromFile(name);
	ary=new char[row][col];
	//System.out.println(board.length());
	//System.out.println(board);
	//System.out.println(formatted);
	//clearAry();
	constructAry();
	//System.out.println(x+" "+y);
	//ary[7][1]='L';
	startx=x;
	starty=y;
	//solve();
	//formatAry();
    }

    public boolean validPuzzle(){
	int count=0;
	for (int i = 0; i < board.length(); i++) {
	    if (board.charAt(i) == 'S'||board.charAt(i) == 'E') {
		count++;
	    }
	}
	if(count==2)
	    return true;
	return false;
    }
    
    private void constructAry(){
	int r=0;
	int c=0;
        for (int i = 0; i < board.length(); i++) {
	    if(board.charAt(i)=='S'){
		x=r;
		y=c;
	    }
	    ary[r][c] =board.charAt(i);
	    c++; 
	    if ((i+1)% (ary[0].length) == 0) {
		r++; 
		c = 0; 
	    }
	}
    }
    /*
    private void debugAry(){
        for(int i=0; i<ary.length; i++){
	    for(int j=0; j<ary[i].length; j++)
		System.out.print(ary[i][j]);
	    System.out.println("");
	}
    }

    private void formatAry(){
	for(int i=0; i<ary.length; i++){
	    for(int j=0; j<ary[i].length; j++){
		if(ary[i][j]=='#'){
		    System.out.print(ansiRed+" "+ansiReset);
		}else if(ary[i][j]=='.'){
		    System.out.print(ansiGreen+" "+ansiReset);
		}else if(ary[i][j]=='S'||ary[i][j]=='E'){
		    System.out.print(ansiCyanBack+ary[i][j]+ansiReset);
		}else{
		    System.out.print(ary[i][j]);
		}
	    }
	    System.out.println("");
	}
    }
    
    private void clearAry(){
	for(int r=0; r<ary.length;r++){
	    for(int c=0; c<ary[r].length;c++)
		ary[r][c]='0';
	}
    }
    */
    /*
    private void debugPrinterFromFile(String filename){
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
    */
    /*
    private void add(String filename){
	try{
	    File infile = new File(filename);// can be a path"/full/path/to/file.txt" 
	    Scanner inf = new Scanner(infile);
	    int lineNumber = 1;
	    col = inf.nextLine().length();
	    while(inf.hasNextLine()){
		String line = inf.nextLine();
		row+=1;
	    }
`	    inf = new Scanner(infile);
	    lineNumber = 1;
	    while(inf.hasNextLine()){
		String line = inf.nextLine();
		for(int i=0; i<line.length(); i++){
		    board+=line.charAt(i);
		    formatted+=line.charAt(i);
		}
		formatted+="\n";
	    }
	}catch(Exception e){
	    System.out.println("Looks like the file doesn't exist. Create and try again.");
	}
    }
    */
    /*
    private String stringFromString(){
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
    */
    public void solve(){
	solveH(x,y);
	//ary[startx][starty]='S';
    }

    private boolean solveH(int x, int y){
	if(animate){
            System.out.println("\033[2J\033[1;1H"+this);

            wait(20);
        }
	//PACMAN FORMAT
	/*
	if(pacmanSolver){
	    System.out.println(pacmanMaker());
            wait(20);
        }
	*/

	//End base case
	if (ary[x][y] == 'E')
	    return true;
	//wall or went there already
	if (ary[x][y] == '#' || ary[x][y] == '@'||ary[x][y]=='.')
	    return false;
	//ark path i went
	ary[x][y] = '@';
	boolean went;

	// right
	went=solveH(x, y+1);
	if (went)
	    return true;
	//up
	went=solveH(x-1, y);
	if (went)
	    return true;
	//left
	went=solveH(x, y-1);
	if (went)
	    return true;		
	//down
	went=solveH(x+1, y);
	if (went)
	    return true;
	//couldnt go
	ary[x][y] = '.';
		
	// Go back
	return false;
    }

    public String formattedToString(){
	ary[startx][starty]='S';
	String s="";
	for(int i=0; i<ary.length; i++){
	    for(int j=0; j<ary[i].length; j++){
		if(ary[i][j]=='#'){
		    s+=(ansiRed+" "+ansiReset);
		}else if(ary[i][j]=='@'){
		    s+=(ansiGreen+" "+ansiReset);
		}else if(ary[i][j]=='S'||ary[i][j]=='E'){
		    s+=(ansiCyanBack+ary[i][j]+ansiReset);
		}else{
		    s+=(ary[i][j]);
		}
	    }
	    s+=("\n");
	}
	ary[startx][starty]='@';
	return s;
    }

    public String toString(){
	String s="";
	for(int i=0; i<ary.length; i++){
	    for(int j=0; j<ary[i].length; j++)
	        s+=(ary[i][j]);
	    s+=("\n");
	}
	return s;
    }
    //stuff k had that i didnt notice

    private void wait(int millis){ //ADDED SORRY!
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }


    public void setAnimate(boolean b){

        animate = b;

    }


    public void clearTerminal(){

        //erase terminal, go to top left of screen.

        System.out.println("\033[2J\033[1;1H");

    }

    public static void main(String args[]){
	Maze a;
	try{
	    a= new Maze(args[0]);
	}catch(Exception e){
	    a= new Maze("Maze1.txt");
	}
	a.setAnimate(true);
	a.solve();
	System.out.println(a);
        System.out.print(a.formattedToString());
	//System.out.println(a);
    }
}
