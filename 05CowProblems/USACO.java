import java.io.*;
import java.util.*;

public class USACO {

    public USACO(){
	//do nothing, but just to use nonstatic methods
    }

    private int[][] lake;
    int m=0;
    //String debug="1";
    private ArrayList<int[]> instructions;
    
    public int bronze(String filename) {
	int x=0;
	//String debug2=debug;
	try {
	    //debug+="s";//=99;
	    File f = new File( filename );
	    Scanner in = new Scanner( f );
	    String fL = in.nextLine();
	    //System.out.println(fL);
	    String[] firstLine = fL.split(" ");
	    //System.out.println(Arrays.toString(firstLine));
	    //System.out.println(firstLine.length);
	    int rows = Integer.parseInt( firstLine[0] );
	    int cols = Integer.parseInt( firstLine[1] );
	    int el= Integer.parseInt(firstLine[2]);
	    //debug+="s";//=1;
	    lake = new int[ rows ][ cols ];
	    for (int i = 0; i < rows; i++) {
		String[] numbers = in.nextLine().split(" ");
		for (int j= 0;j < cols; j++) {
		    lake[ i ][ j ] = Integer.parseInt( numbers[j] );
		    //debug+="s";//+=9;
		}
	    }
	    //debug+="s";//=88;
	    instructions = new ArrayList<>();
	    int upTo = 0;
	    //debug+="s";//=92;
	    while ( in.hasNextLine() ) {
		//debug+="s";//=1;
		//System.out.println(instructions.size());
		String []line = in.nextLine().split(" ");
		//debug+="s";//=221;
		int []temp= new int[3];
		for (int i = 0; i < 3; i++) {
		    temp[i] = Integer.parseInt(line[i]);
		    //debug+="s";//=51;
		}
		//upTo++;
		//System.out.println(Arrays.toString(temp));
		//debug+="s";//=9000;
		instructions.add(temp);
		//debug+="s";//=77;
	    }
	    //debug+="s";//2=101;
	    x= bronzeH(el);}
	catch (Exception e) {
	    System.out.println(" Invalid file");
	    System.exit(0);}
	return x;
	
    }

    public int bronzeH (int e){
	//debug+="L";//=152;
	for (int[] currentInstructions : instructions){
	    //System.out.println(printer());
	    //System.out.println(Arrays.toString(currentInstructions));
	    //debug+="s";//=99;
	    int row = currentInstructions[0]-1;
	    int col = currentInstructions[1]-1;
	    int el = currentInstructions[2];
	    int max= findMax( row,col,el );
	    //System.out.println(printer());
	    for(int a=row; a<row+3; a++){
		//debug+="c";//=17;
		for(int b=col; b<col+3; b++){
		    //debug+="s";//=-11;
		    //System.out.println(Arrays.toString(lake));
		    if(lake[a][b]>max){
		        //System.out.println("DEBUGS:+\n"+printer());
			lake[a][b] = max;
		    }
		}	    
	    }
	}
	//debug+="s";//=6000;
	return findVolume(e);
    }

    public int findMax(int r, int c, int e){
	//System.out.println("R="+r+","+"C"+c);
	int max = 0, row = 0, col = 0;
	//debug+="r";//+=5;
	//String s="";
	for(int a=r; a<r+3; a++){
	    for(int b=c; b<c+3; b++){
		//s+=lake[a][b]+" ";
		//debug+="s";//=0;
		if(lake[a][b]>max) {
		    //System.out.println(r+","+c);
		    //System.out.println(lake[a][b]);
		    //row = a;
		    //col = b;
		    //System.out.println(row+","+col);
		    max=lake[a][b];	  
		}
	    }
	    //s+="\n";
	    //debug+="o";
	}
	//System.out.println(s);
	//lake[ row ][ col ] -= e;
	//debug+="s";//=100;
	//m=max-e;
	//System.out.println("MAX:"+m);
	return max-e;
    }
    /*		    
    public int findVolume(int el){
	System.out.println("EL:"+el);
	debug+="s";//=5000;
	int o = 0;
	for (int r = 0; r < lake.length; r++) {
	    for (int c = 0; c < lake[r].length; c++) {
		int hi = m - lake[r][c];
		debug+="s";//=-90;
		if (hi > 0) {
		    o += hi;
		}
	    }
	}
	System.out.println(o);
	return o *72 * 72;
    }
    */

    public int findVolume(int e){
	int d=0;
	for(int i=0; i<lake.length;i++){
	    for(int j=0; j<lake[i].length;j++){
		if(lake[i][j]>e)
		    continue;
		lake[i][j]=Math.abs(lake[i][j]-e);
		    d+=lake[i][j];
	    }
	}
	return d*72*72;
    }
    
    public String printer(){
	String s="";
	for(int i=0; i<lake.length;i++){
	    for(int j=0; j< lake[0].length;j++)
		s+=lake[i][j]+" ";
	    s+="\n";
	}
	return s;
    }
	
	    
    public static void main(String args[]){
	USACO x=new USACO();
	if(args.length>0){
	    System.out.println(x.bronze(args[0]));
	}else{System.out.println("Invalid file");}
    }
	    
}
