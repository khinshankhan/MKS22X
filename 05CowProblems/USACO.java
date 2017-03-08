import java.io.*;
import java.util.*;

public class USACO {

    public USACO(){
	//do nothing, but just to use nonstatic methods
    }

    private int[][] lake;
    int m=0;
    private ArrayList<int[]> instructions;
    
    public int bronze(String filename) {
	int x=0;
	int debug=0;
	try {
	    File f = new File( filename );
	    Scanner in = new Scanner( f );
	    String fL = in.nextLine();
	    System.out.println(fL);
	    String[] firstLine = fL.split(" ");
	    System.out.println(Arrays.toString(firstLine));
	    System.out.println(firstLine.length);
	    int rows = Integer.parseInt( firstLine[0] );
	    int cols = Integer.parseInt( firstLine[1] );
	    int el= Integer.parseInt(firstLine[2]);
	    debug=1;
	    lake = new int[ rows ][ cols ];
	    for (int i = 0; i < rows; i++) {
		String[] numbers = in.nextLine().split(" ");
		for (int j= 0;j < cols; j++) {
		    lake[ i ][ j ] = Integer.parseInt( numbers[j] );
		    debug+=9;
		}
	    }
	    debug=88;
	    instructions = new ArrayList<>();
	    int upTo = 0;
	    debug=92;
	    while ( in.hasNextLine() ) {
		debug=1;
		String []line = in.nextLine().split(" ");
		debug=221;
		for (int i = 0; i < 3; i++) {
		    instructions.get(upTo)[i] = Integer.parseInt(line[i]);
		    debug=51;
		}
		upTo++;
		debug=77;
	    }
	    debug+=101;
	    x= bronzeH(el);
	}
	catch (Exception e) {
	    System.out.println("Invalid file "+debug);
	    System.exit(0);}
	return x;
	
    }

    public int bronzeH (int e) 
    {
	for (int[] currentInstructions : instructions){
	    int row = currentInstructions[0];
	    int col = currentInstructions[1];
	    int el = currentInstructions[2];
	    int max= findMax( row,col,el );
	    for(int a=row; a<row+3; a++){
		for(int b=col; b<col+3; b++){
		    if(lake[a][b]>max) {
			lake[a][b] = max;
		    }
		}	    
	    }
	}
	return findVolume(e);
    }

    public int findMax(int r, int c, int e){
	int max = 0, row = 0, col = 0;
	for(int a=r; a<r+3; a++){
	    for(int b=c; b<c+3; b++){
		if(lake[a][b]>max) {
		    row = a;
		    col = b;
		    max=lake[a][b];	  
		}
	    }	    
	}
	lake[ row ][ col ] -= e;
	m=max;
	return max - e;
    }
		    
    public int findVolume(int el)
    {
	int o = 0;
	for (int r = 0; r < lake.length; r++) {
	    for (int c = 0; c < lake[r].length; c++) {
		int hi = m - lake[r][c];
		if (hi > 0) {
		    o += hi;
		}
	    }
	}
	return o * 66 * 66;
    }
	    
    public static void main(String args[]){
	USACO x=new USACO();
	if(args.length>0){
	    System.out.println(x.bronze(args[0]));
	}else{System.out.println("Invalid file");}
    }
	    
}
