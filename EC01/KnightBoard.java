public class KnightBoard{
    private int[][]board;
    int moves[][] = {{-2,1},{-1,2},{1,2},{2,1},
		       {2,-1},{1,-2},{-1,-2},{-2,-1}};
    int sr;
    int sc;
    //helps with string
    boolean solver=false;
    
    public KnightBoard(int startingRows,int startingCols){
	sr=startingRows;
	sc=startingCols;
        board = new int[sr][sc];
	//checkingFill();
    }
    /*
    public void checkingFill(){
	for(int r=0; r<sr;r++){
	    for(int c=0;c<sc;c++){
		board[r][c]=1;
	    }
	}
	for(int r=1; r<sr;r++){
	    for(int c=0;c<sc;c++){
		board[r][c]=10;
	    }
	}
	for(int r=2; r<sr;r++){
	    for(int c=0;c<sc;c++){
		board[r][c]=100;
	    }
	}
	for(int r=3; r<sr;r++){
	    for(int c=0;c<sc;c++){
		board[r][c]=1000;
	    }
	}
    }
    */

    public String toString(){
	String s="";
	for(int r=0; r<sr;r++){
	    for(int c=0;c<sc;c++){
		if(board[r][c]<10){
		    s+="   "+board[r][c]+" ";
		}
		if(!(board[r][c]<10)&&
		   board[r][c]<100){
		    s+="  "+board[r][c]+" ";
		}
	        if(!(board[r][c]<10||
		     board[r][c]<100)&&
		   board[r][c]<1000){
		    s+=" "+board[r][c]+" ";
		}
		if(!(board[r][c]<10||
		     board[r][c]<100||
		     board[r][c]<1000)&&
		   board[r][c]<10000){
		    s+=+board[r][c]+" ";
		}
		s+=((c==sc-1) ? "\n" : "");
	    }
	}
	return s;
    }

    public static void main(String args[]){
	int a= Integer.parseInt(args[0]);
	int b= Integer.parseInt(args[0]);
	KnightBoard c=new KnightBoard(a,b);
	System.out.println(c);
    }
}
